import {Request, Response} from "express";
import ComputadorSchema from "../models/ComputadorSchema";

class ComputadorController{
/*
    async alterar(request: Request, response: Response){
        console.log(request.body)
        const {objeto} = request.body._id;
        ComputadorSchema.findOneAndUpdate({_id: objeto},request.body);
        
    }*/

    async listar(request: Request, response: Response) {
        try {
          const computers = await ComputadorSchema.find();
          response.status(200).json({
            data: computers,
            error: false,
            msg: "Lista de medicos",
          });
        } catch (error) {
          response.status(400).json({
            data: error,
            error: true,
            msg: "Não foi possível completar",
          });
        }
    }


    async cadastrar(request: Request, response: Response) {
        try {
            //console.log(request.body);
            const objRecebido = request.body;
            const newcomputer = await ComputadorSchema.create(objRecebido);
            //console.log(objRecebido);
            
            response.status(201).json({
                data: newcomputer,
                error: false,
                msg:"Exito ao cadastrar"
            });
        }
        catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar a ação"
            });
        }
    }
}

export {ComputadorController};