import { Funcionario } from "./Funcionario"

export class Atividade {
    _id?: string;
    titulo!: string;
    dataFinal!: Date;
    criador!: string;
    funcionario?: Funcionario[];
    iniciadaEm?: Date;
    descricao?: string
    createdAt?: Date;
    updatedAt?: Date;
}