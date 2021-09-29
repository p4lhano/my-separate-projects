import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

    nome!: string ;
    cpf!: string ;
    setorId!:number;
    isSetores!: Setor[];

    constructor(private service: FuncionarioService,private serviceSetor : SetorService,private router: Router) { }

    ngOnInit(): void {
        this.serviceSetor.listar().subscribe(setores => {
        console.log(setores);
        this.isSetores = setores;
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
}
