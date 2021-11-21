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

    // toPontoTable(pontos: PontoFuncionario[]): PontoFuncionarioTable[] {
    //     let pontoFuncionarioTable : PontoFuncionarioTableList[] =new Array(2)   ;
    //     pontoFuncionarioTable.push({data: new Date,
    //         ENTRADA_1: new Date,
    //         SAIDA_1: new Date,
    //         ENTRADA_2: new Date,
    //         SAIDA_2: new Date});
    //     return pontoFuncionarioTable;
    // }
    toPontoTable(pontos: PontoFuncionario[])  {

    }

}
