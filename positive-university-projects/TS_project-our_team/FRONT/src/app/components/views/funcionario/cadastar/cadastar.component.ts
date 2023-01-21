import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/models/Funcionario';
import { AtividadeService } from 'src/app/services/atividade.service';

@Component({
  selector: 'app-cadastar',
  templateUrl: './cadastar.component.html',
  styleUrls: ['./cadastar.component.css']
})
export class CadastarFuncionarioComponent implements OnInit {

  nome!: string;
  dataNascimento!: string;
  cpf!: string;
  salario!: string;
  setor!: string;
  cargo!: string;
  status!: string;

  constructor(private service: AtividadeService, private router: Router, private snack: MatSnackBar) {}

  ngOnInit(): void {

  }

  cadastrar(): void{
    let funcionario = new Funcionario();
    funcionario.nome = this.nome;
    funcionario.dataNascimento = new Date(this.dataNascimento);
    funcionario.cpf = this.cpf;
    funcionario.salario = this.salario;
    funcionario.setor = this.setor;
    funcionario.cargo = this.cargo;
    funcionario.status = this.status;
    this.service.funcionarioCadastar(funcionario).subscribe( funcionario => {
      this.snack.open("Funcionario cadastrado com sucesso", "Funcionario", {
        duration: 3000,
        horizontalPosition: "left",
        verticalPosition: "top",
      }) ;
      this.router.navigate([""]);
    })

  }

}
