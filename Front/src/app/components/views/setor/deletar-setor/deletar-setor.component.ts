import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-deletar-setor',
    templateUrl: './deletar-setor.component.html',
    styleUrls: ['./deletar-setor.component.css']
})
export class DeletarSetorComponent implements OnInit {

    constructor(private router: Router) { }

    ngOnInit(): void {
    }

    voltar(): void{
        this.router.navigate([""]);
    }
}
