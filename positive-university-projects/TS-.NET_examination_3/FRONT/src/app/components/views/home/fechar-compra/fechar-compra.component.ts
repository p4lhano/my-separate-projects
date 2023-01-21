import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MetodoPagamento } from 'src/app/models/metodoPagamento';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-fechar-compra',
  templateUrl: './fechar-compra.component.html',
  styleUrls: ['./fechar-compra.component.css']
})
export class FecharCompraComponent implements OnInit {
    carrinhoId!: String;
    nomeCliente!: String;
    meioPagamentoId!:Number;
    meiosPagamento!: MetodoPagamento[];
  constructor(private service: ItemService,
    private router: Router) { }

  ngOnInit(): void {

    let carrinhoId = localStorage.getItem("carrinhoId")! || "";
    this.carrinhoId = carrinhoId;
    this.service.metodosPagamento().subscribe(mets => {
        this.meiosPagamento = mets;
    });

  }

  finalizar():void{
    console.log("Pediu para finalizar");
    this.service.finalizarVenda(this.carrinhoId,this.nomeCliente,this.meioPagamentoId).subscribe(response => {
        console.log(response);
        this.router.navigate([""]);
    });
  }

}
