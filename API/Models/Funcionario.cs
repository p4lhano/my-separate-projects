using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace API.Models
{
    public class Funcionario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public DateTime CriadoEm { get; set; }
        public DateTime AtualizadoEm { get; set; }
        public List<PontoFuncionario> Pontos { get; set; }

        [JsonIgnore]
        public Setor Setor { get; set; }
        public int SetorId {get; set;}

        public override string ToString() => $"Nome: {Nome}; CPF: {Cpf};Criado em {CriadoEm}; Atualizado em: {AtualizadoEm}";
    }
}