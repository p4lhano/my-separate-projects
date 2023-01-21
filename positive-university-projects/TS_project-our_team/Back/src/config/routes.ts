import { request, Router } from "express";
import { feedbackController } from "../controllers/feedbackController";
import {funcController} from "../controllers/funcController";
import { AtividadeController } from "../controllers/AtividadeController";

const router = Router();
const funcionario = new funcController();
const feedback = new feedbackController();
const atividade = new AtividadeController();

router.get("/funcionario/listar",funcionario.listar);
router.post("/cadastrar/funcionario",funcionario.cadastrar);
router.get("/buscar/funcionario/id/:id", funcionario.buscaId);
router.get("/buscar/funcionario/:nome", funcionario.buscaNome);
router.put("/funcionario/alterar",funcionario.alterar);
router.delete("/funcionario/remover/:id",funcionario.remover);
router.get("/feedback/add", feedback.cadastrar);

router.post("/atividade/cadastrar", atividade.cadastrar);
router.get("/atividade/procurarPorTitulo/:titulo", atividade.procurarAtividadePorTitulo);
router.get("/atividade/procurarPorCriador/:criador", atividade.procurarAtividadePorCriador);
router.put("/atividade/alterar", atividade.alterar);
router.delete("/atividade/deletar/:titulo", atividade.deletar);
router.put("/atividade/cadastrarFuncionario", atividade.cadastrarFuncionario);
router.get("/atividade/listar", atividade.listar);

export {router};