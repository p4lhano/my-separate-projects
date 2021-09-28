using System;

namespace API.Models
{
    public class Filme
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Descricao { get; set; }
        public int Nota { get; set; }
        public string Diretor { get; set; }
    }
}