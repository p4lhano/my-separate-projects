import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PontoFuncionario } from '../models/ponto-funcionario';

@Injectable({
  providedIn: 'root'
})
export class PontoFuncionarioService {
    private URL_BASE: string = "http://localhost:5000";

    constructor(private http: HttpClient) { }

    registrarPonto(id: number): Observable<PontoFuncionario>{
        return this.http.get<PontoFuncionario>(`${this.URL_BASE}/registro/now/${ id }`);
    }

}
