import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario } from 'src/app/models/funcionario';
import { PontoFuncionarioTable } from 'src/app/models/ponto-funcionario-table';
import { PontoFuncionarioService } from 'src/app/services/pontoFuncionario.service';

@Component({
  selector: 'app-registros-all',
  templateUrl: './registros-all.component.html',
  styleUrls: ['./registros-all.component.css']
})
export class RegistrosAllComponent implements OnInit {

    funcionario!: Funcionario;
    pontos!: MatTableDataSource<PontoFuncionarioTable>;
    registroPontos: number = 1;
    displayedColumns: string[] = ['data','ENTRADA_1', 'SAIDA_1', 'ENTRADA_2', 'SAIDA_2','totalTrabalhado'];
    constructor(private service: PontoFuncionarioService, private rota: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.rota.params.subscribe((params) => {
            this.service.detalhes(params.id).subscribe(funcionario => {
                this.funcionario = funcionario;
                this.pontos = new MatTableDataSource<PontoFuncionarioTable>(funcionario.pontosT);
                this.registroPontos += funcionario.pontosT?.length || 0;//vai add a quantidade de pontos do size de array de pontos
            });
        });
    }

}
