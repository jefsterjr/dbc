import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Estado} from '../model/Estado';
import {environment} from '../../environments/environment';
import {ApiPaths} from '../model/enums/api-paths';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  baseUrl = environment.baseUrl;
  url = `${this.baseUrl}/${ApiPaths.estado}`;

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Estado[]> {
    return this.httpClient.get<Estado[]>(this.url + '/all');
  }

  getAllCustoPopulacional(): Observable<Estado[]> {
    return this.httpClient.get<Estado[]>(this.url);
  }
}
