import express from "express";
import cors from "cors";
import {mongoose} from "./config/database";
import {router} from "./config/routes";

console.clear();

const app = express();
const database = mongoose;

app.use(cors());
app.use(express.json());
app.use(router);

app.listen(3000, () => {
    console.log("O servidor está rodando...") ;
 });