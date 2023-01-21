import {Request, Response} from "express";
import feedbackSchema from "../models/feedbackSchema";


class feedbackController{
    async cadastrar(request: Request, response: Response) {
        try {
            //console.log(request.body);
            const feedbackRes = await feedbackSchema.create(request.body);
            response.status(201).json({
                data: feedbackRes,
                error: false,
                msg:"Exito ao cadastrar"
            });
        }
        catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar"
            });
        }
    }
}






export {feedbackController};