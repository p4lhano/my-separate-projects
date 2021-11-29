using System;
using System.Linq;
using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API.Controllers
{
    [ApiController]
    [Route("api/meiopagamento")]
    public class MetodoPagamentoController : ControllerBase
    {
        private readonly DataContext _context;
        public MetodoPagamentoController(DataContext context)
        {
            _context = context;
        }

        //POST: api/meiopagamento/create
        [HttpPost]
        [Route("create")]
        public IActionResult Create([FromBody] MetodoPagamento metPagamento)
        {
            metPagamento.User = _context.Usuarios.Find(metPagamento.UsuarioId);
            _context.MetodosPagamentos.Add(metPagamento);
            _context.SaveChanges();
            return Created("", metPagamento);
        }

        //GET: api/meiopagamento/list
        [HttpGet]
        [Route("list")]
        public IActionResult List() =>
            Ok(_context.MetodosPagamentos
            .ToList());

        //GET: api/produto/getbyid/1
        [HttpGet]
        [Route("getbyid/{id}")]
        public IActionResult GetById([FromRoute] int id)
        {
            Produto produto = _context.Produtos.Find(id);
            if (produto == null)
            {
                return NotFound();
            }
            return Ok(produto);
        }

        //DELETE: /api/produto/delete/bolacha
        [HttpDelete]
        [Route("delete/{name}")]
        public IActionResult Delete([FromRoute] string name)
        {
            //Expressão lambda
            //Buscar um objeto na tabela de produtos com base no nome
            Produto produto = _context.Produtos.FirstOrDefault(produto => produto.Nome == name);

            if (produto == null)
            {
                return NotFound();
            }
            _context.Produtos.Remove(produto);
            _context.SaveChanges();
            return Ok(_context.Produtos.ToList());
        }

        //PUT: api/produto/update
        [HttpPut]
        [Route("update")]
        public IActionResult Update([FromBody] Produto produto)
        {
            _context.Produtos.Update(produto);
            _context.SaveChanges();
            return Ok(produto);
        }
    }
}