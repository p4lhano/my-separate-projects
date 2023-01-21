import {Request, Response} from "express";
import funcSchema from "../models/funcSchema";

class funcController{
    async listar(request: Request, response: Response){
        try {
            const funcionarios = await funcSchema.find();
            response.status(200).json(funcionarios);
          } catch (error) {
            response.status(400).json({
                    data: error,
                    error: true,
                    msg: "Não foi possível listar os funcionarios",
                });
            }
    }

    async cadastrar(request: Request, response: Response) {
        try {
            //console.log(request.body);
            const novoFuncionario = await funcSchema.create(request.body);
            response.status(201).json({
                data: novoFuncionario,
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

    async buscaId(request: Request, response: Response) {
        try {
            const {id} = request.params;
            //console.log({ _id: id});
            const buscaFeita = await funcSchema.findOne({ _id: id});
            //console.log(buscaFeita);
            response.json(buscaFeita);
        } catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar a ação"
            });
        }

    }

    async buscaNome(request: Request, response: Response){
        try {
            const {nome} = request.params;
            //console.log({ _nome: nome});
            const buscaFeita = await funcSchema.find({ nome: nome});
            //console.log(buscaFeita);
            response.json(buscaFeita);
        } catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar a ação"
            });
        }
    }

    async alterar(request: Request, response: Response){
        try {
            //console.log(request.body);
            const id = request.body.id;
            const alterar = request.body.alterar;
            //console.log({id: id});
            //console.log(alterar);
            //const {id} = request.body;
            //console.log({ _nome: nome});
            
            const RESPONSE_DB = await funcSchema.updateOne(
                {_id: id},
                {$set : alterar}
            );
            //console.log(RESPONSE_DB);
            response.json(RESPONSE_DB);
        } catch (error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível completar a ação"
            });
        }
    }

    async remover(request: Request, response: Response){
        try {
            console.log(request.params);
            const removeIs = request.params.id;
            //console.log({_id: removeIs});
            //console.log(removeIs);
            const RESPONSE_DB = await funcSchema.deleteOne({_id: removeIs});
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



export {funcController};