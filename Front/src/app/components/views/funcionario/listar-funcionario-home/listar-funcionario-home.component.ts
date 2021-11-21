import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
  selector: 'app-listar-funcionario-home',
  templateUrl: './listar-funcionario-home.component.html',
  styleUrls: ['./listar-funcionario-home.component.css']
})
export class ListarFuncionarioHomeComponent implements OnInit {

    public funcionarios : Funcionario[] = [];
    constructor(private service : FuncionarioService) {};

    ngOnInit(): void {

        this.service.listar().subscribe(funcionarios => {
        this.funcionarios = funcionarios;
        });
    }

}
