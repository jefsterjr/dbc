import {Component, OnInit} from '@angular/core';
import {Cidade} from '../../model/Cidade';
import {Estado} from '../../model/Estado';
import {EstadoService} from '../estado.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-estado-list',
  templateUrl: './estado-list.component.html'
})
export class EstadoListComponent implements OnInit {
  estados: Estado[];

  constructor(private service: EstadoService, private location: Location) {
  }

  ngOnInit(): void {
    this.getAllCustoPopulacional();
  }

  getAllCustoPopulacional(): void {
    this.service.getAll().subscribe(estados => {
      this.estados = estados;
    });
  }
}
