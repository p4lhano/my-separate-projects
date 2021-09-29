import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Setor } from 'src/app/models/setor';
import { SetorService } from 'src/app/services/setor.service';

@Component({
    selector: 'app-listar-setor',
    templateUrl: './listar-setor.component.html',
    styleUrls: ['./listar-setor.component.css']
})
export class ListarSetorComponent implements OnInit {

    public setores! : MatTableDataSource<Setor>;
    displayedColumns: string[] = ['setorId','nomeSetor','funcionarios', 'deletar'];
    constructor(private service : SetorService, private router: Router) { }

    ngOnInit(): void {
        this.service.listar().subscribe(setores => {
            console.log(setores);
            this.setores = new MatTableDataSource<Setor>(setores);
            });
    }

    deletar(id: number):void{
        this.service.deletar(id).subscribe();
        this.router.navigate(["setor/deletar"]);
    }

}
