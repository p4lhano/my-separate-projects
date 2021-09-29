import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Funcionario } from 'src/app/models/funcionario';
import { Setor } from 'src/app/models/setor';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { SetorService } from 'src/app/services/setor.service';

@Component({
  selector: 'app-cadastrar-funcionario',
  templateUrl: './cadastrar-funcionario.component.html',
  styleUrls: ['./cadastrar-funcionario.component.css']
})
export class CadastrarFuncionarioComponent implements OnInit {

    id!: number ;
    nome!: string ;
    cpf!: string ;
    setorId:number | undefined;
    isSetores!: Setor[];
    action!: string;

  constructor(
      private service: FuncionarioService,
      private serviceSetor : SetorService,
      private router: Router,
      private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.action = "Cadastrar Novo";
    this.serviceSetor.listar().subscribe(setores => {
    console.log(setores);
    this.isSetores = setores;
    });

    this.route.params.subscribe((params) => {
        this.action = "Editar";
        this.id = params.id;
        this.service.buscarId(this.id).subscribe((funcionario) => {
            this.nome = funcionario.nome;
            this.cpf = funcionario.cpf;
            this.setorId = funcionario.setorId;
        });
    });

  }

  create():void{
      //console.log(this.nome);
      let funcionario: Funcionario = {
        nome : this.nome,
        cpf : this.cpf,
        setorId : this.setorId
      };
      this.service.cadastrar(funcionario).subscribe(funcionario => {
          console.log(funcionario);
          this.router.navigate([""]);
      });
  }

  alterar():void {

      let funcionario: Funcionario = {
          id: this.id,
          cpf: this.cpf,
          nome: this.nome,
          setorId: this.setorId
      };

      this.service.update(funcionario).subscribe((funcionario) => {
          console.log(funcionario);
          this.router.navigate([""]);
      });
  }
}
