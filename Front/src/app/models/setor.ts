import { Funcionario } from "./funcionario";

export interface Setor {
    setorId?:number;
    nomeSetor:string;
    funcionarios?: Funcionario[];

}
