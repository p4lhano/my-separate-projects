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
            funcionario.CriadoEm = DateTime.Now;
            funcionario.AtualizadoEm = funcionario.CriadoEm;
            await _context.Funcionarios.AddAsync(funcionario).ConfigureAwait(false);
            _context.SaveChanges();
            return Created("",funcionario);
        }
        //" POST: /funcionario/update"
        [HttpPut]
        [Route("update")]
        public async Task<IActionResult> AlterarFuncionario([FromBody] Funcionario funcionario){
            Funcionario funcionarioOld = await _context.Funcionarios.FindAsync(funcionario.Id).ConfigureAwait(true);
            funcionario.AtualizadoEm = DateTime.Now;
            funcionario.CriadoEm = funcionarioOld.CriadoEm;
            Console.WriteLine("Funcionario antigo "+funcionarioOld);
            Console.WriteLine("Funcionario new "+funcionario);
            _context.Funcionarios.Update(funcionario);
            await _context.SaveChangesAsync().ConfigureAwait(false);
            return Ok();
        }
        // GET /funcionario/list
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListarAsync() => Ok(await _context
            .Funcionarios
            .Include(f => f.Pontos)
            .Include(s => s.Setor)
            .ToListAsync()
            .ConfigureAwait(false));

        // GET /funcionario/findbyid/id
        [HttpGet]
        [Route("findbyid/{id}")]
        public async Task<IActionResult> FindByIdAsync([FromRoute] int id){
            Funcionario funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(true);
            if(funcionario != null)
            {
                funcionario.Pontos = await _context
                    .PontosFuncionarios
                    .Where(pontosPercorre => pontosPercorre.FuncionarioId == id)
                    .ToListAsync();
                return Ok(funcionario);
            }

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
            Console.WriteLine(id);
            Funcionario funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(true);
            if (funcionario == null) return NotFound();
            _context.Funcionarios.Remove(funcionario);
            await _context.SaveChangesAsync().ConfigureAwait(false);
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
            await _context.SaveChangesAsync().ConfigureAwait(false);
            return Ok();
        }
    }
}