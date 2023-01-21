using System;

namespace API.Models
{
    public class PontoTableFolha
    {
        public int Id { get; set; }
        public DateTime Data { get; set; }
        public DateTime Entrada_1 { get; set; }
        public DateTime Entrada_2 { get; set; }
        public DateTime Saida_1 { get; set; }
        public DateTime Saida_2 { get; set; }
        public TimeSpan TotalTrabalhado { get; set; }

        public Funcionario Funcionario { get; set; }
        public int FuncionarioId { get; set; }

       // public override string ToString() => $"Data: {Data}; E1: {Entrada_1}; S1 {Saida_1};E2: {Entrada_2}; S2 {Saida_2};";
    }
}