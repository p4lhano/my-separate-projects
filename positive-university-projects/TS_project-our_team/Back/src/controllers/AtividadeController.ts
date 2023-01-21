import { Request, Response } from "express";
import AtividadeSchema from "../models/AtividadeSchema";
import FuncSchema from "../models/funcSchema";

class AtividadeController{

    async cadastrar(request: Request, response: Response) {
        try {
            const { titulo } = request.body;
            console.log(titulo);
            const atividade = await AtividadeSchema.findOne({ titulo: titulo});
            if(atividade == null){
                const novaAtividade = await AtividadeSchema.create(request.body);
                response.status(201).json({
                data: novaAtividade,
                error: false,
                msg: "Atividade cadastrado com sucesso!"
                });
            }else{
                response.status(400).json({
                    data: atividade,
                    error: false,
                    msg: "Já exite uma atividade com esse nome!"
                });
            }
        } catch(error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível cadastrar a atividade"
            });
        }
    }

    async procurarAtividadePorTitulo(request: Request, response: Response) {
        try{
            const { titulo } = request.params;
            const atividade = await AtividadeSchema.findOne({ titulo: titulo});
            if(atividade != null){
                response.status(200).json({
                    data: atividade,
                    error: false,
                    msg: "Atividade encontrada!"
                });
            } else {
                response.status(404).json({
                    data: atividade,
                    error: false,
                    msg: "Atividade não encontrado!"
                });
            }
        } catch(error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Nome invalido"
            });
        }
    }

    async procurarAtividadePorCriador(request: Request, response: Response) {
        try{
            const { criador } = request.params;
            const atividade = await AtividadeSchema.find();
            if(atividade != null){   
                let atividades;
                for (let i = 0; i < atividade.length; i++) {
                    const element = atividade[i];
                    console.log(element);
                    if(element.criador == criador){
                        atividades += element;
                    }
                }
                response.status(200).json({
                    data: atividades,
                    error: false,
                    msg: "Atividade encontrada!"
                });
            } else {
                response.status(404).json({
                    data: atividade,
                    error: false,
                    msg: "Atividade não encontrado!"
                });
            }
        } catch(error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Nome invalido"
            });
        }
    }

    async alterar(request: Request, response: Response) {
        try {
            const { titulo } = request.body;
            const atividade = await AtividadeSchema.findOneAndUpdate({ titulo: titulo}, request.body);
            if(atividade != null){
                response.status(200).json({
                data: atividade,
                error: false,
                msg: "Atividade alterada com sucesso!"
                });
            }else{
                response.status(404).json({
                    data: atividade,
                    error: false,
                    msg: "Atividade não cadastrado"
                });
            }
        } catch (error) {
          response.status(400).json({
            data: error,
            error: true,
            msg: "Não foi possível alterar a atividade"
          });
        }
    }

    async deletar(request: Request, response: Response) {
        try{
            const { titulo } = request.params;
            const atividade = await AtividadeSchema.findOneAndDelete({ titulo: titulo});
            if(atividade != null){
                response.status(200).json({
                    data: atividade,
                    error: false,
                    msg: "A atividade foi deletada com sucesso!"
                });
            } else {
                response.status(404).json({
                    data: atividade,
                    error: false,
                    msg: "Não há nenhuma ativiadae cadastrado com esse titulo!"
                });
            }
        } catch(error){
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível deletar a atividade"
            });
        }
    }
    
    async cadastrarFuncionario(request: Request, response: Response){
        try {
            const { titulo, cpf, descricao, inciadaEm} = request.body;
            const funcionario = await FuncSchema.findOne({ cpf: cpf});
            if(funcionario != null){
                const atividade = await AtividadeSchema.findOneAndUpdate({ titulo: titulo}, {funcionario: funcionario, descricao: descricao, inciadaEm: inciadaEm});
                response.status(200).json({
                    data: atividade,
                    error: false,
                    msg: "Funcionario cadastrado na ativdade com sucesso!"
                });
            }else{
                response.status(400).json({
                    data: funcionario,
                    error: false,
                    msg: "Não foi possivel achar o funcionario!"
                });
            }
        } catch(error) {
            response.status(400).json({
                data: error,
                error: true,
                msg: "Não foi possível alterar a atividade"
            });
        }
    }

    async listar(request: Request, response: Response){
        try {
            const atividades = await AtividadeSchema.find();
            response.status(200).json(atividades);
          } catch (error) {
            response.status(400).json({
                    data: error,
                    error: true,
                    msg: "Não foi possível listar as atividades",
                });
            }
    }
}

export { AtividadeController };