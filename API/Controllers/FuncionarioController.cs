using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;

namespace API.Controllers
{
    [ApiController]
    [Route("funcionario")]
    public class FuncionarioController : ControllerBase
    {
        private readonly DataContext _context;
        public FuncionarioController(DataContext context)
        {
            _context = context;
        }
        //" POST: /funcionario/create"
        [HttpPost]
        [Route("create")]
        public Funcionario CadastrarFuncionario(Funcionario funcionario){
            _context.Funcionarios.Add(funcionario);
            _context.SaveChanges();
            return funcionario;
        }

        // GET /funcionario/list
        [HttpGet]
        [Route("list")]
        public List<Funcionario> Listar(){
            return _context.Funcionarios.ToList();
        }
    }
}