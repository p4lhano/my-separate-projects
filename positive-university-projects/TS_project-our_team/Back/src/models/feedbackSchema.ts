import { model, Schema } from "mongoose";
import funcSchema from "./funcSchema";

const feedbackSchema = new Schema(
    {
        funcionario: {
            type: Schema.Types.ObjectId,
            ref: funcSchema
        }, msg: {
            type: String,
            require: true
        }
    },
    {
        timestamps: true
    }
);

export default model("feedback", feedbackSchema);