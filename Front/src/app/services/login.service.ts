import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from '../models/funcionario';
import { Login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
    private URL_BASE: string = "http://localhost:5000";

    constructor(private http: HttpClient) { }

    realizarLogin(login: Login): Observable<Login>{
        return this.http.post<Login>(`${this.URL_BASE}/usuario/login`, login)
    }
}
