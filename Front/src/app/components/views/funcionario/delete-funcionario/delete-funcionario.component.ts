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
    constructor(private service: FuncionarioService, private rota: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.rota.params.subscribe((params) => {
            this.service.delete(params.id).subscribe();
            this.router.navigate(["funcionario/all"]);
        });
    }

}
