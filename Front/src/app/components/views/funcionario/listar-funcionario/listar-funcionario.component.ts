import { Component, OnInit } from '@angular/core';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
  selector: 'app-listar-funcionario',
  templateUrl: './listar-funcionario.component.html',
  styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

    public funcionarios : Funcionario[] = [];
    constructor(private service : FuncionarioService) {};

  ngOnInit(): void {
    this.service.listar().subscribe(funcionarios => {
        this.funcionarios = funcionarios;
        //console.log(funcionarios);
    });
  }

}
