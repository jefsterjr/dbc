import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {ApiPaths} from '../model/enums/api-paths';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cidade} from '../model/Cidade';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  baseUrl = environment.baseUrl;
  url = `${this.baseUrl}/${ApiPaths.cidade}`;

  constructor(private httpClient: HttpClient) {
  }

  getAll(model:any): Observable<Cidade[]> {
    // let params = {};
    // if(model.nome ) params.nome = model.nome;
    // if(model.estado ) params.idEstado = model.estado.id;

    return this.httpClient.get<Cidade[]>(this.url,{
      params:null
    });
  }


  save(cidade: Cidade): Observable<Cidade> {
    return this.httpClient.post<Cidade>(this.url, cidade);
  }
  salvarLista(cidades: Cidade[]): void {
    this.httpClient.post<Cidade>(this.url, cidades);
  }

  delete(id: number) {
    return this.httpClient.delete<void>(this.url + '/' + id);
  }
}
