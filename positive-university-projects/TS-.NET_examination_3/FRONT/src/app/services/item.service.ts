import { ItemVenda } from "src/app/models/item-venda";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { MetodoPagamento } from "../models/metodoPagamento";
import { Venda } from "../models/venda";

@Injectable({
    providedIn: "root",
})
export class ItemService {
    private baseUrl = "http://localhost:5000/api/item";

    constructor(private http: HttpClient) {}

    create(item: ItemVenda): Observable<ItemVenda> {
        return this.http.post<ItemVenda>(`${this.baseUrl}/create`, item);
    }

    getByCartId(carrinhoId: string): Observable<ItemVenda[]> {
        return this.http.get<ItemVenda[]>(
            `${this.baseUrl}/getbycartid/${carrinhoId}`
        );
    }

    metodosPagamento():Observable<MetodoPagamento[]> {
        return this.http.get<MetodoPagamento[]>(`http://localhost:5000/api/meiopagamento/list`);
    }
    finalizarVenda(cardId: String,cliente:String,idMetPag:Number):Observable<Venda>{
        let url = `http://localhost:5000/api/venda/create/${cardId}/${cliente}/${idMetPag}`;
        console.log("requisitando: " + url);
        return this.http.get<Venda>(url);
    }
}
