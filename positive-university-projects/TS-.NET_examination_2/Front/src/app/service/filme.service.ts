import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filme} from "../models/filme";


@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  private URL_BASE: string = "http://localhost:5000";

  constructor(private http: HttpClient) { }
  
  public listar(): Observable<Filme[]> {
    return this.http.get<Filme[]>(`${this.URL_BASE}/filme/list`);
  }

  public cadastrar(filme: Filme): Observable<Filme>{
    return this.http.post<Filme>(`${this.URL_BASE}/filme/create`, filme);
}
}
