import { Router } from "express";
import {MedicoController} from "../controllers/MedicoController";

const router = Router();
const medico = new MedicoController();

router.post("/medico/cadastrar", medico.cadastrarMedico);
router.get("/medico/listar", medico.listar);
router.get("/medico/buscar/:crm", medico.buscarCrm);
router.post("/medico/alterar", medico.alterar);






export {router};