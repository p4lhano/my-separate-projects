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
        public async Task<IActionResult> CadastrarFuncionarioAsync([FromBody] Funcionario funcionario){
            await _context.Funcionarios.AddAsync(funcionario).ConfigureAwait(false);
            _context.SaveChanges();
            return Created("",funcionario);
        }

        // GET /funcionario/list
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListarAsync() => Ok(await _context.Funcionarios.ToListAsync().ConfigureAwait(false));

        // GET /funcionario/findbyid/id
        [HttpGet]
        [Route("findbyid/{id}")]
        public async Task<IActionResult> FindByIdAsync([FromRoute] int id){
            Funcionario funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(false);
            if(funcionario != null) return Ok(funcionario);
            return NotFound();
        }
        /*
        //GET /funcionario/findbynome/id
        [HttpGet]
        [Route("findbynome/{nome}")]
        public async Task<IActionResult> FindByNomeAsync([FromRoute] int nome){
            Funcionario funcionario = await _context.Funcionarios.Where<>;
            return NotFound();
        }
        */
        // DELETE /funcionario/deleteid/id
        [HttpDelete]
        [Route("deleteid/{id}")]
        public async Task<IActionResult> DeleteByIdAsync([FromRoute] int id){
            Funcionario funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(true);
            if (funcionario == null) return NotFound();
            _context.Funcionarios.Remove(funcionario);
            _context.SaveChanges();
            return Ok();
        }

        // DELETE /funcionario/deletename/id
        [HttpDelete]
        [Route("deletename/{name}")]
        public async Task<IActionResult> DeleteByNameAsync([FromRoute] string name){
            Funcionario funcionario =  await _context.Funcionarios.FirstOrDefaultAsync(
                x => x.Nome == name
                ).ConfigureAwait(false);
            _context.Funcionarios.Remove(funcionario);
            _context.SaveChanges();
            return Ok();
        }
    }
}