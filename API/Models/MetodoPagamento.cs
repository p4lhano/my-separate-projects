using System;
using System.Text.Json.Serialization;

namespace API.Models
{
    public class MetodoPagamento
    {
        public int Id { get; set; }
        [JsonIgnore]
        public Usuario User { get; set; }
        public int UsuarioId { get; set; }
        public string Nome { get; set; }
        public string NumeroCartao { get; set; }
        public MeioPagamento MeioPagamentoEscolhido { get; set; }
        // public List<Produto> Produtos { get; set; }

        public enum MeioPagamento { CREDITO, DEBITO, VALE_CARD }
    }
}