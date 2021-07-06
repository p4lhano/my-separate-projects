import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComputadorService } from 'src/app/services/computador.service';
import { Computador } from 'src/models/computador';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {
  dono!: string;
  placamae!: string;
  processador!: string;
  memoria!: number;
  armazenamento!: string;
  fonte!: string;
  constructor(private service: ComputadorService, private router: Router) { }

  ngOnInit(): void {
    
  }

  cadastrar(): void{
    let computador = new Computador();
    computador.dono = this.dono;
    computador.placamae = this.placamae;
    computador.processador = this.processador;
    computador.armazenamento = this.armazenamento;
    computador.memoria = this.memoria;

    this.service.cadastrar(computador).subscribe(() => {
      this.router.navigate([""]);
    });
  }

}
