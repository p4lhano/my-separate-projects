import { Component, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { Produto } from "src/app/models/produto";
import { ProdutoService } from "src/app/services/produto.service";

@Component({
    selector: "app-listar-produto",
    templateUrl: "./listar-produto.component.html",
    styleUrls: ["./listar-produto.component.css"],
})
export class ListarProdutoComponent implements OnInit {
    produtos: Produto[] = [];
    matT!: MatTableDataSource<Produto>;
    colunasExibidas: String[] = [
        "id",
        "nome",
        "descricao",
        "preco",
        "quantidade",
        "categoria",
    ];

    constructor(private service: ProdutoService) {}

    ngOnInit(): void {
        this.service.list().subscribe((produtos) => {
            console.log(produtos)
            this.produtos = produtos;
            this.matT = new MatTableDataSource<Produto>( produtos );
        });
    }
}
