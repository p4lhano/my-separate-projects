import { model, Schema } from "mongoose";

const FuncSchema = new Schema(
    {
        status: {
            type: String,
            require: [true, "O campo STATUS é obrigatório!"],
            enum: ["ativo", "inativo"],
            lowercase: true
        },
        nome: {
            type: String,
            require: [true, "O campo nome é obrigatório!"]
        },
        cpf: {
            type: String,
            require: [true, "O campo CPF é obrigatório!"]
        },
        cargo: {
            type: String,
            enum: ["ASSISTENTE", "ANALISTA", "SUPERVISOR","GERENTE","DIRETOR","PRESIDENTE"],
            uppercase: true
        },
        salario: {
            type: Number,
            min: [500, "Salario minimo 500 reais"],
            require: [true, "O campo salario é obrigatório!"]
        },
        setor: {
            type: String
        },
        dataNascimento:{
            type: Date
        }
    },
    {
        timestamps: true
    }
);

export default model("funcionarios", FuncSchema);
export {FuncSchema};

/*
{
        "status": "ativo",
        "nome": "Vitor",
        "cpf": "999999.9",
        "cargo": "ASSISTENTE",
        "salario": 256,
        "setor": "Banco",
        "cnh": "51651",
        "dataNascimento": "2002-04-03"
}

*/