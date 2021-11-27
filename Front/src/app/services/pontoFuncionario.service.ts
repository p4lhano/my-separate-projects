import { FolhaPagamento } from './../models/folha-pagento';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from '../models/funcionario';
import { PontoFuncionario } from '../models/ponto-funcionario';
import { PontoFuncionarioTable } from '../models/ponto-funcionario-table';

@Injectable({
  providedIn: 'root'
})
export class PontoFuncionarioService {
    private URL_BASE: string = "http://localhost:5000";

    constructor(private http: HttpClient) { }

    registrarPonto(id: number): Observable<PontoFuncionario>{
        return this.http.get<PontoFuncionario>(`${this.URL_BASE}/registro/now/${ id }`);
    }

    detalhes(id: number): Observable<Funcionario>{
        return this.http.get<Funcionario>(`${this.URL_BASE}/registro/detalhes/${ id }`);
    }

    folhaPonto(id: number, mes: String, ano: String): Observable<FolhaPagamento>{
        return this.http.get<FolhaPagamento>(`${this.URL_BASE}/funcionario/folha/${ id }/${ mes }/${ ano }`);
    }

}
