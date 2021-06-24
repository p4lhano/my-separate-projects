import {Request, Response} from "express";
import MedicoSchema from "../models/MedicoSchema";

class MedicoController{

    async alterar(request: Request, response: Response){
        console.log(request.body)
        const {objeto} = request.body._id;
        MedicoSchema.findOneAndUpdate({_id: objeto},request.body);
        
    }

    async listar(request: Request, response: Response) {
        try {
          const medicos = await MedicoSchema.find();
          response.status(200).json({
            data: medicos,
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

    async buscarCrm(request: Request, response: Response){
        try {
            
            const {crm} = request.params;
            console.log({ _crm: crm});
            const buscaFeita = await MedicoSchema.findOne({ crm: crm});
            console.log(buscaFeita);
            response.json(buscaFeita);
        } catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar a ação"
            });
        }
    }

    async cadastrarMedico(request: Request, response: Response) {
        try {
            const objRecebido = request.body;
            const novoMedico = await MedicoSchema.create(objRecebido);
            console.log(objRecebido);
            console.log(objRecebido);
            
            response.status(201).json({
                data: novoMedico,
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

export {MedicoController};