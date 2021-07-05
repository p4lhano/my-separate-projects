import { model, Schema } from "mongoose";

const ComputadorSchema = new Schema(
    {
        dono: {
            type: String,
            require: [false, "O campo nome é obrigatório!"]
        },
        placamae: {
            type: String,
            require: [false, "O campo CRM é obrigatório!"]
        },
        processador: {
            type: String,
            require: [false, "O campo CRM é obrigatório!"]
        },
        memoria: {
            type: Number,
            require: [false, "O campo CRM é obrigatório!"]
        },
        armazenamento: {
            type: String,
            require: [false, "O campo CRM é obrigatório!"]
        },
        fonte: {
            type: String,
            require: [false, "O campo CRM é obrigatório!"]
        }
    },
    {
        timestamps: true
    }
);

export default model("computador", ComputadorSchema);
