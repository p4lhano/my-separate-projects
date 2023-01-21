using System;
using System.Text.Json.Serialization;

namespace API.Models
{
    public class PontoFuncionario
    {
        public int Id { get; set; }
        public DateTime DataRegistroPonto { get; set; }
        [JsonIgnore]
        public Funcionario Funcionario { get; set; }
        public int FuncionarioId { get; set; }
        public TipoPonto TipoPontoRegistro { get; set; }

        public PontoFuncionario()
        {
        DataRegistroPonto = DateTime.Now;
        //add logica para verificar o tipo de ponto verificar se será necessário crialo em funcão a parte
        }

        public enum TipoPonto { ENTRADA_1, SAIDA_1, ENTRADA_2, SAIDA_2 }
    }
}