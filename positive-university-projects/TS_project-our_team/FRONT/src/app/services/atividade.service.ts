import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Atividade } from "../models/Atividade";
import { Funcionario } from "../models/Funcionario";

@Injectable({
    providedIn: 'root'
})

export class AtividadeService {

    private baseURL= "http://localhost:3000/";

    constructor(private http: HttpClient) { }

    atividadeListar(): Observable<Atividade[]>{
        return this.http.get<Atividade[]>(`${this.baseURL}atividade/listar/`);
    }
    atividadeCadastar(atividade: Atividade): Observable<Atividade>{
        return this.http.post<Atividade>(`${this.baseURL}atividade/cadastrar`, atividade);
    }

    funcionarioListar(): Observable<Funcionario[]>{
        return this.http.get<Funcionario[]>(`${this.baseURL}funcionario/listar`);
    }

    funcionarioCadastar(funcionario: Funcionario): Observable<Funcionario>{
        return this.http.post<Funcionario>(`${this.baseURL}cadastrar/funcionario`, funcionario);
    }
    
}