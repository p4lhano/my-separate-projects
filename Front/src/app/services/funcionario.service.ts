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

         let x = this.http.get<Funcionario[]>(`${this.URL_BASE}/funcionario/list`);


        return x;
    }
}
