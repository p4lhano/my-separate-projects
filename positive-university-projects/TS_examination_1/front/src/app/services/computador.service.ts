import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Computador } from 'src/models/computador';

@Injectable({
  providedIn: 'root'
})
export class ComputadorService {
  baseURL = "http://localhost:3000/";
  constructor(private http: HttpClient) { }

  listar(): Observable<Computador[]>{
    return this.http.get<Computador[]>(`${this.baseURL}computador/listar`);
  }

  cadastrar(computador: Computador):Observable<Computador>{
    return this.http.post<Computador>(`${this.baseURL}computador/cadastrar`,computador);
  }

  remover(id:string):Observable<string>{
    return this.http.get<string>(`${this.baseURL}computador/remover/${id}`);
  };

}
