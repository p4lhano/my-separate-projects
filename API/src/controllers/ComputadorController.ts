import {Request, Response} from "express";
import ComputadorSchema from "../models/ComputadorSchema";

class ComputadorController{

    async listar(request: Request, response: Response) {
        try {
          const computers = await ComputadorSchema.find();
          /*
          response.status(200).json({
            data: computers,
            error: false,
            msg: "Lista de medicos",
          });
          */
          response.status(200).json(computers);
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

    async remover(request: Request, response: Response){
      try {
          //console.log(request.params);
          const removeIs = request.params.id;
          //console.log({_id: removeIs});
          //console.log(removeIs);
          const RESPONSE_DB = await ComputadorSchema.deleteOne({_id: removeIs});
          //console.log(RESPONSE_DB);
          response.json(RESPONSE_DB.deletedCount);//Retorna o JSON somente dos registro deletados
      } catch (error) {
          response.status(400).json({
              data: error,
              error: true,
              msg: "Não foi possível completar a ação"
          });
      }
  }
}

export {ComputadorController};