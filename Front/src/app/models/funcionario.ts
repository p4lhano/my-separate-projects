import { PontoFuncionario } from "./ponto-funcionario";

export interface Funcionario {
    id?: number;
    nome: string;
    cpf: string;
    criadoEm?: Date;
    atualizadoEm?: Date;
    pontos?: PontoFuncionario[];
    setorId?: number;
}
