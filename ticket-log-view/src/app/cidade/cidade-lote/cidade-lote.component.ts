import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {Cidade} from '../../model/Cidade';
import {CidadeService} from '../cidade.service';
import {EstadoService} from '../../estado/estado.service';
import {Estado} from '../../model/Estado';

@Component({
  selector: 'app-cidade-lote',
  templateUrl: './cidade-lote.component.html'
})
export class CidadeLoteComponent implements OnInit {
  model: Cidade;
  estados: Estado[];
  cidades: Cidade[];

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

  salvar(models: Cidade[]): void {
    console.log('salvar')
    this.service.salvarLista(models);
  }

  remover(i: number): void {
    this.cidades.splice(i, 1);
  }

  adicionar(cidade: Cidade): void {
    if(!this.cidades) this.cidades = [];
    this.cidades.push(cidade);
    this.model = new Cidade();
  }

  voltar(): void {
    this.location.back();
  }
}
