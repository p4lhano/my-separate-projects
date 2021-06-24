import mongoose from "mongoose";

mongoose.connect(
    "mongodb+srv://Adm:adm@topicosespeciais.eemwj.mongodb.net/TopicosEspeciais?retryWrites=true&w=majority",
    {useNewUrlParser: true, useUnifiedTopology: true}
).then(() => {
    console.log("Aplicação conectada ao DataBase_MongoDB");
}).
catch((erro) => {
    console.log(`Erro ao conecnetar: ${erro}`)
});

export{mongoose};