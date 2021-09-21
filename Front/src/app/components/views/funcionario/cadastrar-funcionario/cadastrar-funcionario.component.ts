import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
  selector: 'app-cadastrar-funcionario',
  templateUrl: './cadastrar-funcionario.component.html',
  styleUrls: ['./cadastrar-funcionario.component.css']
})
export class CadastrarFuncionarioComponent implements OnInit {

    nome!: string ;
    cpf!: string ;

  constructor(private service: FuncionarioService,private router: Router) { }

  ngOnInit(): void {
  }
  create():void{
      //console.log(this.nome);
      let funcionario: Funcionario = {
        nome : this.nome,
        cpf : this.cpf
      };
      this.service.cadastrar(funcionario).subscribe(funcionario => {
          console.log(funcionario);
          this.router.navigate([""]);
      });
  }
}
