import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { PontoFuncionarioService } from 'src/app/services/pontoFuncionario.service';

@Component({
  selector: 'app-listar-funcionario-home',
  templateUrl: './listar-funcionario-home.component.html',
  styleUrls: ['./listar-funcionario-home.component.css']
})
export class ListarFuncionarioHomeComponent implements OnInit {

    id!:number;
    message! : String ;
    public funcionarios : Funcionario[] = [];
    constructor(
        private service : FuncionarioService,
        private servicePonto:PontoFuncionarioService,
        private router: Router,
        private _snack: MatSnackBar) {};

    ngOnInit(): void {
        this.service.listar().subscribe(funcionarios => {
        this.funcionarios = funcionarios;
        });
    }
    registrarPonto(funcionario:Funcionario){
        this.servicePonto.registrarPonto(funcionario.id!).subscribe(ponto =>{
            let mgsString  = "Erro ao registrar";
            if ( ponto.dataRegistroPonto != null ) {
                mgsString = "Ponto em: " + ponto.dataRegistroPonto;
            }
            this._snack.open(
                mgsString ,
                "OK",{
                    duration:3000,
                    horizontalPosition: "right",
                    verticalPosition: "bottom"
                });
        });
        this.router.navigate([""]);
    }


}
