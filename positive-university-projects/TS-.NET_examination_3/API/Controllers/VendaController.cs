using System;
using System.Collections.Generic;
using System.Linq;
using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API.Controllers
{
    [ApiController]
    [Route("api/venda")]
    public class VendaController : ControllerBase
    {
        private readonly DataContext _context;
        public VendaController(DataContext context)
        {
            _context = context;
        }

        //GET: api/venda/list
        //ALTERAR O MÉTODO PARA MOSTRAR TODOS OS DADOS DA VENDA E OS DADOS RELACIONADOS
         [HttpGet]
        [Route("list")]
        public IActionResult List() =>
            Ok(_context.Vendas
            .Include(v => v.Itens)
            .ThenInclude(i => i.Produto.Categoria)
            .ToList());

        [HttpGet]
        [Route("create/{cartId}/{cliente}/{idMetPag}")]
        public IActionResult Create([FromRoute] string cartId,string cliente, int idMetPag)
        {
            Console.WriteLine("Chegou aqui");
            Venda venda = new();
            venda.Cliente = cliente;
            venda.IdMetodoPagamento = idMetPag;
            venda.Itens = _context.ItensVenda.Where(i => i.CarrinhoId == cartId).ToList();
            _context.Vendas.Add(venda);
            _context.ItensVenda.UpdateRange(venda.Itens);

            _context.SaveChanges();

            return Created("", venda);
        }
    }
}