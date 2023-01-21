import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Funcionario } from 'src/app/models/Funcionario';
import { AtividadeService } from 'src/app/services/atividade.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarFuncionarioComponent implements OnInit {
  funcionarios!: MatTableDataSource<Funcionario>;
  funcionarioColumns: string[] = ['nome', 'cpf', 'dataNascimento', 'cargo', 'status'];



  constructor(private service: AtividadeService) { }

  ngOnInit(): void {
    this.service.funcionarioListar().subscribe((funcionarios) => {
      this.funcionarios = new MatTableDataSource<Funcionario>(funcionarios);
    })
  }

}
