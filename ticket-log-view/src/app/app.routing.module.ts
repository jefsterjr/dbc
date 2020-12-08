import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CidadeComponent} from './cidade/cidade-form/cidade.component';
import {CidadeListComponent} from './cidade/cidade-list/cidade-list.component';
import {EstadoListComponent} from './estado/estado-list/estado-list.component';
import {CidadeLoteComponent} from './cidade/cidade-lote/cidade-lote.component';

const routes: Routes = [
  { path: '', redirectTo: '/estado-list', pathMatch: 'full' },
  {path: 'cidade-form', component: CidadeComponent},
  {path: 'cidade-lote', component: CidadeLoteComponent},
  {path: 'cidade-form/:id', component: CidadeComponent},
  {path: 'cidade-list', component: CidadeListComponent},
  {path: 'estado-list', component: EstadoListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
