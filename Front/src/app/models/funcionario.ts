import { PontoFuncionario } from "./ponto-funcionario";
import { PontoFuncionarioTable } from "./ponto-funcionario-table";

export interface Funcionario {
    id?: number;
    nome: string;
    cpf: string;
    valorHora:number;
    criadoEm?: Date;
    atualizadoEm?: Date;
    pontos?: PontoFuncionario[];
    pontosT?: PontoFuncionarioTable[];
    setorId?: number;
}
