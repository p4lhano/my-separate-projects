import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Filme } from 'src/app/models/filme';
import { FilmeService } from 'src/app/service/filme.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

    nome!: string
    descricao!: string
    nota!: number
    diretor!: string

  constructor(private service: FilmeService,private router: Router) { }

  ngOnInit(): void {
  }

  create():void{
    //console.log(this.nome);
    let filme: Filme = {
      nome : this.nome,
      descricao : this.descricao,
      nota:this.nota,
      diretor:this.diretor
    };
    this.service.cadastrar(filme).subscribe(filme => {
        console.log(filme);
        this.router.navigate([""]);
    });
}

}
