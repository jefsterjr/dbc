import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {CidadeComponent} from './cidade/cidade-form/cidade.component';
import {CidadeListComponent} from './cidade/cidade-list/cidade-list.component';
import {EstadoListComponent} from './estado/estado-list/estado-list.component';
import {AppRoutingModule} from './app.routing.module';
import {MessagesComponent} from './messages/messages.component';
import {HttpErrorHandler} from './http-error-handler.service';
import {MessageService} from './messages/message.service';

@NgModule({
  declarations: [
    AppComponent,
    CidadeComponent,
    EstadoListComponent,
    CidadeListComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule

  ],
  providers: [
    HttpErrorHandler,
    MessageService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
