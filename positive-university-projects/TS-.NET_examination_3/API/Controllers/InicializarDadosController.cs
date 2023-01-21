using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [ApiController]
    [Route("api/inicializar")]
    public class InicializarDadosController : ControllerBase
    {
        private readonly DataContext _context;
        public InicializarDadosController(DataContext context)
        {
            _context = context;
        }

        //POST: api/inicializar/create
        [HttpPost]
        [Route("create")]
        public IActionResult Create()
        {
            _context.Categorias.AddRange(new Categoria[]
                {
                    new Categoria { CategoriaId = 1, Nome = "Panificação" }
                }
            );
            _context.Produtos.AddRange(new Produto[]
                {
                    new Produto { ProdutoId = 1, Nome = "Pão", Preco = 1, Quantidade = 12, CategoriaId = 1 },
                    new Produto { ProdutoId = 2, Nome = "Queijo", Preco = 5, Quantidade = 33, CategoriaId = 1 },
                    new Produto { ProdutoId = 3, Nome = "Chineque", Preco = 8, Quantidade = 1, CategoriaId = 1 }
                }
            );
            _context.SaveChanges();
            return Ok(new { message = "Dados inicializados com sucesso!" });
        }
    }
}