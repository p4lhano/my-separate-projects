import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ToolbarComponent } from 'src/app/components/templete/toolbar/toolbar.component';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-listar-funcionario',
    templateUrl: './listar-funcionario.component.html',
    styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

    public funcionarios : Funcionario[] = [];
    public funcionarios2! : MatTableDataSource<Funcionario>;
    displayedColumns: string[] = ['id','nome','cpf','criadoEm', 'runs'];
    constructor(private service : FuncionarioService, private router: Router) {};
    displayedColumns: string[] = ['id','nome','cpf','criadoEm', 'deletar'];

    ngOnInit(): void {

        this.service.listar().subscribe(funcionarios => {
        console.log(funcionarios);
        this.funcionarios = funcionarios;
        this.funcionarios2 = new MatTableDataSource<Funcionario>(funcionarios);
        });
    }

    deletar(id: number):void{
        this.service.deletar(id).subscribe();
        this.router.navigate(["funcionario/deletar"]);
    }

}
