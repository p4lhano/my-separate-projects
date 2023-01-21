import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Atividade } from 'src/app/models/Atividade';
import { Funcionario } from 'src/app/models/Funcionario';
import { AtividadeService } from 'src/app/services/atividade.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastarAtividadeComponent  implements OnInit {
  funcionarios!: MatTableDataSource<Funcionario>;

  titulo!: string;
  iniciadaEm!: string;
  dataFinal!: string;
  criador!: string;

  colunasFuncionario = ["nome", "cpf", "status"/*, "adicionar"*/];
  _if!: string;
  nome!: string;
  cpf!: string;
  status!: string;
  funcionariosAdicionados = new MatTableDataSource<Funcionario>();


  constructor(private service: AtividadeService, private router: Router, private snack: MatSnackBar) { }

  ngOnInit(): void {
    this.service.funcionarioListar().subscribe((funcionarios) => {
      this.funcionarios = new MatTableDataSource<Funcionario>(funcionarios);
    })
  }

  cadastrar(){
    let atividade = new Atividade();
    atividade.titulo = this.titulo;
    atividade.iniciadaEm = new Date( this.iniciadaEm );
    atividade.dataFinal = new Date( this.dataFinal );
    atividade.criador = this.criador;
    atividade.funcionario = this.funcionariosAdicionados.data;
    this.service.atividadeCadastar(atividade).subscribe(atividade => {
      this.snack.open("Atividade cadastradas", "Atividade", {
        duration: 3000,
        horizontalPosition: "left",
        verticalPosition: "top",
      }) ;
      this.router.navigate([""]);
    })
  }

  adicionar(id: string, nome: string, cpf: string, status:string): void{
    let funcionario = new Funcionario();
    funcionario.nome = nome;
    funcionario.cpf = cpf;
    funcionario.status = status;
    this.funcionariosAdicionados.data.push(funcionario);
    this.funcionariosAdicionados._updateChangeSubscription();
  }

}
