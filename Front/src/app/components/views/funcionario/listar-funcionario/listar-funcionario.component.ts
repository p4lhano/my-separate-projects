import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ToolbarComponent } from 'src/app/components/templete/toolbar/toolbar.component';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
    selector: 'app-listar-funcionario',
    templateUrl: './listar-funcionario.component.html',
    styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

    public funcionarios : Funcionario[] = [];
    public funcionarios2! : MatTableDataSource<Funcionario>;
    constructor(private service : FuncionarioService) {};
    displayedColumns: string[] = ['id','nome','cpf','criadoEm','runs'];

    ngOnInit(): void {

        this.service.listar().subscribe(funcionarios => {
        console.log(funcionarios);
        this.funcionarios = funcionarios;
        this.funcionarios2 = new MatTableDataSource<Funcionario>(funcionarios);
        });
    }

}
