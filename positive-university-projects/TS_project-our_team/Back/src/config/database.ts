import mongoose from "mongoose";

mongoose.connect(
    "mongodb+srv://cesaradm:adm123@clustertopicosavancados.phciw.mongodb.net/QuintaNoite?retryWrites=true&w=majority",
    {useNewUrlParser: true, useUnifiedTopology: true}
).then(() => {
    console.log("Aplicação conectada ao DataBase_MongoDB");
}).
catch((erro) => {
    console.log(`Erro ao conecnetar: ${erro}`)
});

export{mongoose};