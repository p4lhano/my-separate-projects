import { Funcionario } from "./funcionario";

export interface PontoFuncionario {
    id: number;
    dataRegistroPonto: Date;
    funcionario?: Funcionario;
    funcionarioId: number;
    tipoPonto: tipoPonto
}

enum tipoPonto{ ENTRADA_1, SAIDA_1, ENTRADA_2, SAIDA_2 }
