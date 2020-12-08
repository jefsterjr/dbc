import {Cidade} from './Cidade';

export class Estado {
  id:number;
  nome:string;
  uf:string;
  cidades:Cidade[];
  populacao:number;
  bandeira:any;
  custoPopulacional:number;
}
