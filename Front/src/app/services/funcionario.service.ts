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

    buscarId(id:number): Observable<Funcionario> {
        return this.http.get<Funcionario>(`${this.URL_BASE}/funcionario/findbyid/${ id }`);
    }

    update(funcionario: Funcionario): Observable<Funcionario> {
        return this.http.put<Funcionario>(`${this.URL_BASE}/funcionario/update`, funcionario);
    }

    delete(id:number): any {
        console.log(`O Id : ${ id } chegou na função do serviço, fazendo a requição`);
        let url = `${this.URL_BASE}/funcionario/deleteid/${id}`;
        console.log(`Fazendo a requisição para: ${ url } `);
        let algumaCoisa = this.http.delete(url).subscribe(()=>{

        });
        console.log(`O seguinte retornou: ${ algumaCoisa } `);
        console.log(algumaCoisa);
    }
}
