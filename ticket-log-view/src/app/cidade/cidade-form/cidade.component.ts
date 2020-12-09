import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {Cidade} from '../../model/Cidade';
import {CidadeService} from '../cidade.service';
import {EstadoService} from '../../estado/estado.service';
import {Estado} from '../../model/Estado';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-cidade',
  templateUrl: './cidade.component.html'
})
export class CidadeComponent implements OnInit {
  model: Cidade;
  estados: Estado[];
  cidades: Cidade[];

  constructor(private service: CidadeService, private estadoService: EstadoService,
              private location: Location, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.service.getOne(id).subscribe(estados => {
      }
      // Print the parameter to the console.

    });
  };


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
    model.estado.bandeira = null;
    this.service.save(model).subscribe(model => (model = model));
  }

  salvarTodos(cidades: Cidade[]): void {
    this.service.salvarLista(cidades);
  }

  remover(i: number): void {
    this.cidades.splice(i, 1);
  }

  voltar(): void {
    this.location.back();
  }

  adicionar(model: Cidade) {
    if (!this.cidades) {
      this.cidades = [];
    }
    this.cidades.push(model);
    this.model = new Cidade();
    this.model.estado = this.estados.find(estado => estado.uf === 'SC');
  }

  confirm(msg: string): boolean {
    return confirm(msg);
  }
}
