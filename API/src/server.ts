import express from "express";
import {mongoose} from "./config/database";
import {router} from "./config/routes";

console.clear();

const app = express();
const database = mongoose;

app.use(express.json())
app.use(router);

app.listen(1234, () => {
    console.log("O servidor está rodando...") ;
 });