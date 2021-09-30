import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Setor } from 'src/app/models/setor';
import { SetorService } from 'src/app/services/setor.service';

@Component({
  selector: 'app-cadastrar-setor',
  templateUrl: './cadastrar-setor.component.html',
  styleUrls: ['./cadastrar-setor.component.css']
})
export class CadastrarSetorComponent implements OnInit {

    setorId!: number ;
    nomeSetor!: string ;
    action!: string;

  constructor(
      private service : SetorService,
      private router: Router,
      private route: ActivatedRoute) { }

  ngOnInit(): void {
        this.route.params.subscribe((params) => {
            this.action = "Editar";
            this.setorId = params.setorId;
            this.service.buscarId(this.setorId).subscribe((setor) => {
                this.nomeSetor = setor.nomeSetor;
            });
        });
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

  alterar():void {

    let setor: Setor = {
        setorId : this.setorId,
        nomeSetor : this.nomeSetor
    };

    this.service.update(setor).subscribe((setor) => {
        console.log(setor);
        this.router.navigate([""]);
    });
  }
}