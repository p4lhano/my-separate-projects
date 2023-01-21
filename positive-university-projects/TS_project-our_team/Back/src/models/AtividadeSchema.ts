import { model, Schema } from "mongoose";
import funcSchema, { FuncSchema } from "./funcSchema";

const AtividadeSchema = new Schema(
  {
    titulo: {
      type: String,
      required: [true, "O campo titulo é obrigatorio"]
    },
    dataFinal: {
        type: Date
    },
    criador: {
      type: String,
      required: [true, "O campo criador é obrigatorio"]
    },
    
    funcionario: [{
      type: Schema.Types.ObjectId,
      ref: funcSchema
    }],

    iniciadaEm: {
        type: Date
    },
    descricao:{
        type: String
    }
  },
  {
    timestamps: true
  }

)

export default model("atividades", AtividadeSchema);