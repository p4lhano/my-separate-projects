export class Funcionario {
    _id?: string;    
    status!: string;
    nome!: string;
    cpf!: string;
    cargo!: string;
    salario!: string;
    setor?: string;
    dataNascimento?: Date;
    createdAt?: Date;
    updatedAt?: Date;
}