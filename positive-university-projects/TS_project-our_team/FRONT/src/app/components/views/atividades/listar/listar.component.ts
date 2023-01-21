import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Atividade } from 'src/app/models/Atividade';
import { AtividadeService } from 'src/app/services/atividade.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarAtividadeComponent implements OnInit {
  atividades!: MatTableDataSource<Atividade>;
  atividadeColumns: string[] = ['titulo', 'iniciadaEm', 'dataFinal'];



  constructor(private service: AtividadeService) { }

  ngOnInit(): void {
    this.service.atividadeListar().subscribe((atividades) => {
      this.atividades = new MatTableDataSource<Atividade>(atividades);
    })
  }

}
