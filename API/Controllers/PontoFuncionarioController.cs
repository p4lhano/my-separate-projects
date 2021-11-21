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
    [Route("registro")]
    public class PontoFuncionarioController : ControllerBase
    {
        private readonly DataContext _context;
        public PontoFuncionarioController(DataContext context)
        {
            _context = context;
        }
        //" GET: /registro/now/id"
        [HttpGet]
        [Route("now/{id}")]
        public async Task<IActionResult> RegistrarPontoAsync([FromRoute] int id){
            PontoFuncionario pontoFuncionario = new();
            pontoFuncionario.Funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(false);
            Console.WriteLine($"Novo ponto para {pontoFuncionario.Funcionario}");
            _context.PontosFuncionarios.Add(pontoFuncionario);

            await _context.SaveChangesAsync();
            return Created("",pontoFuncionario);
        /*
            PontoFuncionario pontoFuncionario = new();
            pontoFuncionario.FuncionarioId = id;
            await _context.PontosFuncionarios.AddAsync(pontoFuncionario).ConfigureAwait(false);

            _context.SaveChanges();
            return Created("",pontoFuncionario);
        */
            // await _context.Funcionarios.AddAsync(funcionario).ConfigureAwait(false);
            // _context.SaveChanges();
            // return Created("",funcionario);
        }
        //" POST: /funcionario/update"
        // [HttpPut]
        // [Route("update")]
        // public async Task<IActionResult> AlterarFuncionario([FromBody] Funcionario funcionario){
        //     _context.Funcionarios.Update(funcionario);
        //     await _context.SaveChangesAsync().ConfigureAwait(false);
        //     return Ok();
        // }
        // GET /registro/list
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListarAsync() => Ok(await _context.PontosFuncionarios.ToListAsync().ConfigureAwait(false));

        // GET /registro/list/id
        [HttpGet]
        [Route("list/{idfuncionario}")]
        public async Task<IActionResult> ListarPontoFuncionarioAsync([FromRoute] int idfuncionario) => Ok(await _context
            .PontosFuncionarios
            .Where(pontosPercorre => pontosPercorre.FuncionarioId == idfuncionario)
            .ToListAsync()
        );

        // GET /funcionario/findbyid/id
        // [HttpGet]
        // [Route("findbyid/{id}")]
        // public async Task<IActionResult> FindByIdAsync([FromRoute] int id){
        //     Funcionario funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(false);
        //     if(funcionario != null) return Ok(funcionario);
        //     return NotFound();
        // }
        // DELETE /registro/deleteid/id
        [HttpDelete]
        [Route("deleteid/{id}")]
        public async Task<IActionResult> DeleteByIdAsync([FromRoute] int id){
            Console.WriteLine(id);
            PontoFuncionario pontoFuncionario = await _context.PontosFuncionarios.FindAsync(id).ConfigureAwait(true);
            if (pontoFuncionario == null) return NotFound();
            _context.PontosFuncionarios.Remove(pontoFuncionario);
            await _context.SaveChangesAsync().ConfigureAwait(false);
            return Ok();
        }
    }
}