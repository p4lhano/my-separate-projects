using System;

namespace API.Models
{
    public class FolhaPagamento
    {
        public int Id { get; set; }
        public TimeSpan TotalHorasMes { get; set; }
        public double ValorPagar { get; set; }

        public FolhaPagamento() => ValorPagar = 0.0;
    }
}