using System;
using System.Collections.Generic;

namespace API.Models
{
    public class Usuario
    {
        public Usuario() => CriadoEm = DateTime.Now;
        public int UsuarioId { get; set; }
        public List<MetodoPagamento> MeiosPagamento { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string Permissao { get; set; }
        public string Token { get; set; }
        public DateTime CriadoEm { get; set; }
    }
}