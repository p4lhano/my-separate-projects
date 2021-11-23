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
            DateTime hoje = DateTime.Today;
            int totalPontosFuncionarioHoje = await _context.PontosFuncionarios.
                Where(pontosPercorre => pontosPercorre.FuncionarioId == id &&
                    pontosPercorre.DataRegistroPonto > hoje &&
                    pontosPercorre.DataRegistroPonto < hoje.AddDays(1)).
                Select(x => x.Id).
                CountAsync();
            PontoFuncionario pontoFuncionario = new();
            switch (totalPontosFuncionarioHoje){
                case 0:
                    pontoFuncionario.TipoPontoRegistro = PontoFuncionario.TipoPonto.ENTRADA_1;
                    break;
                case 1:
                    pontoFuncionario.TipoPontoRegistro = PontoFuncionario.TipoPonto.SAIDA_1;
                    break;
                case 2:
                    pontoFuncionario.TipoPontoRegistro = PontoFuncionario.TipoPonto.ENTRADA_2;
                    break;
                case 3:
                    pontoFuncionario.TipoPontoRegistro = PontoFuncionario.TipoPonto.SAIDA_2;
                    break;
                default:
                    return BadRequest();
            }
            pontoFuncionario.Funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(false);
            //Console.WriteLine($"Novo ponto para {pontoFuncionario.Funcionario}");
            _context.PontosFuncionarios.Add(pontoFuncionario);

            await _context.SaveChangesAsync();
            return Created("",pontoFuncionario);
        }

        [HttpGet]
        [Route("teste/{id}")]
        public async Task<IActionResult> TesteAsync([FromRoute] int id){
            List<PontoFuncionario> listaPontoFuncionario = await _context.PontosFuncionarios.
            Where(pontosPercorre => pontosPercorre.FuncionarioId == id ).ToListAsync();

            ToPontoTable(listaPontoFuncionario);
            return Ok();
        }
        private List<PontoTable> ToPontoTable(List<PontoFuncionario> lista) {
            DateTime hoje = DateTime.Today;
            // ToListAsync();
            Console.WriteLine("Total de ponto encontrados ");

            return null;
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