using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace API.Controllers
{
    [ApiController]
    [Route("filme")]
    public class FilmeController : ControllerBase
    {
        private readonly DataContext _context;
        public FilmeController(DataContext context)
        {
            _context = context;
        }
        //" POST: /filme/create"
        [HttpPost]
        [Route("create")]
        public async Task<IActionResult> CadastrarFilmeAsync([FromBody] Filme filme){
            await _context.Filmes.AddAsync(filme).ConfigureAwait(false);
            _context.SaveChanges();
            return Created("",filme);
        }
        // GET /filme/list
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListarAsync() => Ok(await _context.Filmes.ToListAsync().ConfigureAwait(false));
    }
}