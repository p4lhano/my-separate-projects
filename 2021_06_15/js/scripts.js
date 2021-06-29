alert('Olá Mundo!');

var nome = prompt('Digite o seu noem completo:');
var idade = prompt('Digite sua idade:');
idade++;
document.write(`<p>Olá ' + nome + ', como vai vc? Que vc vai fazer ano que vem ${idade++} anos!</p>`);