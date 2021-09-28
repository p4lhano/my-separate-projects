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
    [Route("setor")]
    public class SetorController : ControllerBase
    {
        private readonly DataContext _context;
        public SetorController(DataContext context)
        {
            _context = context;
        }
        //" POST: /setor/create"
        [HttpPost]
        [Route("create")]
        public async Task<IActionResult> CadastrarSetorAsync([FromBody] Setor newSetor){
            await _context.Setores.AddAsync(newSetor).ConfigureAwait(false);
            _context.SaveChanges();
            return Created("",newSetor);
        }
        //" POST: /setor/update"
        [HttpPut]
        [Route("update")]
        public async Task<IActionResult> AlterarSetorAsync([FromBody] Setor setor){
            _context.Setores.Update(setor);
            await _context.SaveChangesAsync().ConfigureAwait(false);
            return Ok();
        }
        // GET /setor/list
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListarAsync()
        {
            var response = await _context.Setores
                .Include(u => u.Funcionarios)
                .ToListAsync()
                .ConfigureAwait(false);
            return Ok(response);
        }

        // GET /setor/findbyid/id
        [HttpGet]
        [Route("findbyid/{id}")]
        public async Task<IActionResult> FindByIdAsync([FromRoute] int id){
            Setor setor = await _context.Setores.FindAsync(id).ConfigureAwait(false);
            if(setor != null) return Ok(setor);
            return NotFound();
        }
        /*
        //GET /setor/findbynome/id
        [HttpGet]
        [Route("findbynome/{nome}")]
        public async Task<IActionResult> FindByNomeAsync([FromRoute] int nome){
            setor setor = await _context.Setores.Where<>;
            return NotFound();
        }
        */
        // DELETE /setor/deleteid/id
        [HttpDelete]
        [Route("deleteid/{id}")]
        public async Task<IActionResult> DeleteByIdAsync([FromRoute] int id){
            Setor setor = await _context.Setores.FindAsync(id).ConfigureAwait(true);
            if (setor == null) return NotFound();
            _context.Setores.Remove(setor);
            await _context.SaveChangesAsync().ConfigureAwait(false);
            return Ok();
        }
    }
}