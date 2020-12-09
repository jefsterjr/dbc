import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {ApiPaths} from '../model/enums/api-paths';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cidade} from '../model/Cidade';
import {HandleError, HttpErrorHandler} from '../http-error-handler.service';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {
  private handleError: HandleError;
  baseUrl = environment.baseUrl;
  url = `${this.baseUrl}/${ApiPaths.cidade}`;

  constructor(private httpClient: HttpClient, httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('CidadeService');
  }


  getAll(nome: string): Observable<Cidade[]> {

    return this.httpClient.get<Cidade[]>(this.url, {
      params: {
        nome:nome
      }
    });
  }
  getOne(id: number): Observable<Cidade> {
    return this.httpClient.get<Cidade>(this.url+'/'+id).pipe(
      catchError(this.handleError('getOne', id)));
  }


  save(cidade: Cidade): Observable<Cidade> {
    return this.httpClient.post<Cidade>(this.url, cidade).pipe(
      catchError(this.handleError('save', cidade))
    );
  }

  salvarLista(cidades: Cidade[]): void {
    this.httpClient.post<Cidade>(this.url, cidades).pipe(
      catchError(this.handleError('salvarLista', cidades)));
  }

  delete(id: number) {
    return this.httpClient.delete<void>(this.url + '/' + id).pipe(
      catchError(this.handleError('save', id)));
  }
}
