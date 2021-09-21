import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from '../models/funcionario';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
    private URL_BASE: string = "http://localhost:5000";

    constructor(private http: HttpClient) { }

    listar(): Observable<Funcionario[]> {
        return this.http.get<Funcionario[]>(`${this.URL_BASE}/funcionario/list`);;
    }
    cadastrar(funcionario: Funcionario): Observable<Funcionario>{
        return this.http.post<Funcionario>(`${this.URL_BASE}/funcionario/create`, funcionario);
    }
}
