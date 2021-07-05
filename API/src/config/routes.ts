import { Router } from "express";
import {ComputadorController} from "../controllers/ComputadorController";

const router = Router();
const computador = new ComputadorController();

router.post("/computador/cadastrar", computador.cadastrar);
router.get("/computador/listar", computador.listar);

export {router};