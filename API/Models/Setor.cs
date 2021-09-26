using System.Collections.Generic;

namespace API.Models
{
    public class Setor
    {
        //adicionar atributor/propriedades "prop"
        public int SetorId { get; set; }
        public string NomeSetor { get; set; }
        public List<Funcionario> Funcionarios { get; set; }
    }
}