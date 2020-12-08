import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {Cidade} from '../../model/Cidade';
import {CidadeService} from '../cidade.service';
import {EstadoService} from '../../estado/estado.service';
import {Estado} from '../../model/Estado';

@Component({
  selector: 'app-cidade',
  templateUrl: './cidade.component.html'
})
export class CidadeComponent implements OnInit {
  model: Cidade;
  estados: Estado[];

  constructor(private service: CidadeService, private estadoService: EstadoService, private location: Location) {
  }

  ngOnInit(): void {
    this.getAllEstados();
    this.model = new Cidade();
  }

  getAllEstados(): void {
    this.estadoService.getAll().subscribe(estados => {
      this.estados = estados;
      this.model.estado = this.estados.find(estado => estado.uf === 'SC');
    });
  }

  salvar(model: Cidade): void {
    this.service.save(model).subscribe(model => (this.model = model));
  }

  delete(id: number): void {
    this.service.delete(id).subscribe();
  }

  voltar(): void {
    this.location.back();
  }
}
