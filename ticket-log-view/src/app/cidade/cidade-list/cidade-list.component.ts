import {Component, OnInit} from '@angular/core';
import {Cidade} from '../../model/Cidade';
import {Estado} from '../../model/Estado';
import {CidadeService} from '../cidade.service';
import {EstadoService} from '../../estado/estado.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-cidade-list',
  templateUrl: './cidade-list.component.html'
})
export class CidadeListComponent implements OnInit {
  model: Cidade;
  estados: Estado[];
  cidades: Cidade[];

  constructor(private service: CidadeService, private estadoService: EstadoService, private location: Location) {
  }

  ngOnInit(): void {
    this.getAllEstados();
    this.pesquisar(null);
    this.model = new Cidade();
  }

  getAllEstados(): void {
    this.estadoService.getAll().subscribe(estados => {
      this.estados = estados;
    });
  }

  pesquisar(model:Cidade): void {
    this.service.getAll(model).subscribe(cidades => (this.cidades = cidades));
  }

  limpar(): void {
    this.model = new Cidade();
  }

  voltar(): void {
    this.location.back();
  }

  editar(cidade: Cidade) {

  }

  deletar(id: number): void {
    this.service.delete(id).subscribe();
  }
}
