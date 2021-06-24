import { model, Schema } from "mongoose";

const MedicoSchema = new Schema(
    {
        nome: {
            type: String,
            require: [true, "O campo nome é obrigatório!"]
        },
        crm: {
            type: String,
            require: [true, "O campo CRM é obrigatório!"]
        },
        especialidade: {
            type: String,
            require: [true, "O campo CRM é obrigatório!"]
        }
    },
    {
        timestamps: true
    }
);

export default model("medico", MedicoSchema);

/*
{
        nome: {
            type: String,
            require: [true, "O campo nome é obrigatório!"]
        },
        crm: {
            type: String,
            require: [true, "O campo CRM é obrigatório!"]
        },
        especialidade: {
            type: String,
            require: [true, "O campo CRM é obrigatório!"]
        }
    }
 */