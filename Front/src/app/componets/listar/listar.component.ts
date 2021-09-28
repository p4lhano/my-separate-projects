import { Component, OnInit } from '@angular/core';
import { Filme } from 'src/app/models/filme';
import { FilmeService } from 'src/app/service/filme.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  public filmes : Filme[] = [];
  constructor(private service : FilmeService) { }

  ngOnInit(): void {
    /*this.service.listar().subscribe(filmes => {
      this.filmes = filmes;
      console.log(filmes);
      
      });
    */

      this.service.listar().subscribe(filme => {
        this.filmes = filme;
        console.log(filme);
      });
    
  }

}
