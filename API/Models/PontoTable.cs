using System;

namespace API.Models
{
    public class PontoTable
    {
        public DateTime Data { get; set; }
        public DateTime ENTRADA_1 { get; set; }
        public DateTime ENTRADA_2 { get; set; }
        public DateTime SAIDA_1 { get; set; }
        public DateTime SAIDA_2 { get; set; }
        public Double TotalHorasDia { get; set; }
    }
}