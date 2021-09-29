import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Setor } from 'src/app/models/setor';
import { SetorService } from 'src/app/services/setor.service';

@Component({
  selector: 'app-cadastrar-setor',
  templateUrl: './cadastrar-setor.component.html',
  styleUrls: ['./cadastrar-setor.component.css']
})
export class CadastrarSetorComponent implements OnInit {

    nomeSetor!: string ;
  constructor(private service : SetorService,private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    let setor: Setor = {
        nomeSetor : this.nomeSetor
    };
    this.service.cadastrar(setor).subscribe(setor => {
        console.log(setor);
        this.router.navigate(["setor/all"]);
    });
  }

}
