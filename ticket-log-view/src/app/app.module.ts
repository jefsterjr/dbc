import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {CidadeComponent} from './cidade/cidade-form/cidade.component';
import {CidadeListComponent} from './cidade/cidade-list/cidade-list.component';
import {EstadoListComponent} from './estado/estado-list/estado-list.component';
import {AppRoutingModule} from './app.routing.module';
import {CidadeLoteComponent} from './cidade/cidade-lote/cidade-lote.component';

@NgModule({
  declarations: [
    AppComponent,
    CidadeComponent,
    EstadoListComponent,
    CidadeListComponent,
    CidadeLoteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
