import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deletar-funcionario',
  templateUrl: './deletar-funcionario.component.html',
  styleUrls: ['./deletar-funcionario.component.css']
})
export class DeletarFuncionarioComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  voltar(): void{
    this.router.navigate([""]);
  }

}
