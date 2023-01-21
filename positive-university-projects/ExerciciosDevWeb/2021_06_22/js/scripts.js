var nota = prompt("Digite a nota do aluno: ");
var faltas = prompt("Digite a quantidade de faltas: ");

var media = 6;
var faltasMax = 15;

if(nota >= media && faltas <= faltasMax){
        document.write("O ALUNO FOI APROVADO....");
    } else{
        document.write("O ALUNO FOI REPROVADO :....(");
    }