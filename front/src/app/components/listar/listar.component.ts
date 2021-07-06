import { Component, OnInit } from '@angular/core';
import { ComputadorService } from 'src/app/services/computador.service';
import { Computador } from 'src/models/computador';
import { MatTableDataSource } from "@angular/material/table";


@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  computadores!: MatTableDataSource<Computador>;
  displayedColumns: string[] = ['id', 'dono', 'placamae', 'processador','memoria','armazenamento','fonte','criadoEm'];

  constructor(private service : ComputadorService) { }

  ngOnInit(): void {
    this.service.listar().subscribe((comput) => {
      console.log(comput);
      this.computadores = new MatTableDataSource<Computador>(comput);
    });

  }

}
