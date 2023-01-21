import { Component, OnInit, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';


@Component({
    selector: 'app-folha-ponto',
    templateUrl: './folha-ponto.component.html',
    styleUrls: ['./folha-ponto.component.css']
})
export class FolhaPontoComponent implements OnInit {

    constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

    valorPagar!: number;

    ngOnInit(): void {
        this.valorPagar = this.data.folha;
    }

}
