import { TimeSpan } from "./timeSpan";

export interface PontoFuncionarioTable {
    data: Date;
    entrada_1: Date;
    saida_1: Date;
    entrada_2: Date;
    saida_2: Date;
    totalTrabalhado: TimeSpan;
}
