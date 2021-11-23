import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario } from 'src/app/models/funcionario';
import { PontoFuncionario } from 'src/app/models/ponto-funcionario';
import { PontoFuncionarioTable } from 'src/app/models/ponto-funcionario-table';
import { FuncionarioService } from 'src/app/services/funcionario.service';

@Component({
  selector: 'app-registros-all',
  templateUrl: './registros-all.component.html',
  styleUrls: ['./registros-all.component.css']
})
export class RegistrosAllComponent implements OnInit {

    funcionario!: Funcionario;
    pontos!: MatTableDataSource<PontoFuncionarioTable>;
    registroPontos: number = 1;
    stringlinha: String = "";
    displayedColumns: string[] = ['data','ENTRADA_1', 'SAIDA_1', 'ENTRADA_2', 'SAIDA_2','totalHorasDia'];
    constructor(private service: FuncionarioService, private rota: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.rota.params.subscribe((params) => {
            this.service.buscarId(params.id).subscribe(funcionario => {
                this.funcionario = funcionario;

                this.pontos = new MatTableDataSource<PontoFuncionarioTable>(/* add aqui a função para transformar
                    os pontos em pontosTabela => toPontoTable(funcionario.pontos) */);
                    /*
                    Calcular no back e trazer para cá é uma possibilidade, verificar o uso de funções especificas
                    verificar CSS da tabela de pontos, para que gere no inicio alo após as informações
                    Falar com professor sobre o campo de atualização de registros

                    */
                //console.log(this.funcionario);
                    this.registroPontos += 1;//vai add a quantidade de pontos do size de array de pontos
                    this.stringlinha = `[rowspan]="${this.registroPontos}"`
            });
        });
    }

}
