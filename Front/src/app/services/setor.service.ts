import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Setor } from '../models/setor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SetorService {

    private URL_BASE: string = "http://localhost:5000";

    constructor(private http: HttpClient) { }

    listar(): Observable<Setor[]> {
        return this.http.get<Setor[]>(`${this.URL_BASE}/setor/list`);
    }
    cadastrar(setor: Setor): Observable<Setor>{
        return this.http.post<Setor>(`${this.URL_BASE}/setor/create`, setor);
    }

    buscarId(id:number): Observable<Setor> {
        return this.http.get<Setor>(`${this.URL_BASE}/setor/findbyid/${ id }`);
    }

    update(setor: Setor): Observable<Setor> {
        return this.http.put<Setor>(`${this.URL_BASE}/setor/update`, setor);
    }

    delete(id: number): Observable<Setor>{
        return this.http.delete<Setor>(`${this.URL_BASE}/setor/deleteid/${id}`);
    }
}
