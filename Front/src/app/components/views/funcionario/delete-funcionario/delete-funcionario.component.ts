import { Component, OnInit } from '@angular/core';
import {  Router, ActivatedRoute } from '@angular/router';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
  selector: 'app-delete-funcionario',
  templateUrl: './delete-funcionario.component.html',
  styleUrls: ['./delete-funcionario.component.css']
})
export class DeleteFuncionarioComponent implements OnInit {

    id!:number;
  constructor(private service: FuncionarioService, private router: Router, private rota: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(`O id: ainda não determinado chegou no componente`);
    this.rota.params.subscribe((params) => {
        console.log(`O id:${params.id} ainda não determinado chegou no componente para deletar`);
        this.id = params.id;
        this.service.delete(this.id);
        this.router.navigate([""]);
    });
  }

}
