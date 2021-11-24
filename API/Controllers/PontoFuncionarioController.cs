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
                    return BadRequest(new {message = "Maximo de pontos atingidos"});
            }
            pontoFuncionario.Funcionario = await _context.Funcionarios.FindAsync(id).ConfigureAwait(false);
            //Console.WriteLine($"Novo ponto para {pontoFuncionario.Funcionario}");
            _context.PontosFuncionarios.Add(pontoFuncionario);

            await _context.SaveChangesAsync();
            return Created("",pontoFuncionario);
        }
        //" GET: /registro/detalhes/id"
        [HttpGet]
        [Route("detalhes/{id}")]
        public async Task<IActionResult> TesteAsync([FromRoute] int id){
            Console.WriteLine("ID chegou: "+ id);
            Funcionario funcionario = await _context.Funcionarios.FindAsync(id);
            List<PontoFuncionario> listaPontoFuncionario = await _context.PontosFuncionarios.
                Where(pontosPercorre => pontosPercorre.FuncionarioId == id ).ToListAsync();
            funcionario.PontosT = ToPontoTable(listaPontoFuncionario);
            Console.WriteLine("Chegou aqui e esta retornando");
            return Ok(funcionario);
        }
        private static List<PontoTableFolha> ToPontoTable(List<PontoFuncionario> listaP) {
            List<PontoTableFolha> listPontoTable = new();
            List<DateTime> diasPonto = new();
            foreach(PontoFuncionario pontoU in listaP){
                DateTime diaEssePonto = new(pontoU.DataRegistroPonto.Year,
                    pontoU.DataRegistroPonto.Month,
                    pontoU.DataRegistroPonto.Day);
                diasPonto.Exists(x => x == diaEssePonto );
                if(!diasPonto.Exists(x => x == diaEssePonto )) diasPonto.Add(diaEssePonto);
            }
            foreach( DateTime d in diasPonto ){
                PontoTableFolha registroLinhaFinalTabela = new();
                registroLinhaFinalTabela.Data = d;
                foreach(PontoFuncionario p in listaP.FindAll(x => x.DataRegistroPonto >= d && x.DataRegistroPonto < d.AddDays(1))){
                    switch(p.TipoPontoRegistro){
                        case PontoFuncionario.TipoPonto.ENTRADA_1:
                            registroLinhaFinalTabela.Entrada_1 = p.DataRegistroPonto;
                            break;
                        case PontoFuncionario.TipoPonto.SAIDA_1:
                            registroLinhaFinalTabela.Saida_1 = p.DataRegistroPonto;
                            break;
                        case PontoFuncionario.TipoPonto.ENTRADA_2:
                            registroLinhaFinalTabela.Entrada_2 = p.DataRegistroPonto;
                            break;
                        case PontoFuncionario.TipoPonto.SAIDA_2:
                            registroLinhaFinalTabela.Saida_2 = p.DataRegistroPonto;
                            break;
                    }
                }
                //Calcula o total de horas no dia
                registroLinhaFinalTabela.TotalHorasDia = 0.0;
                Double periodo1 = registroLinhaFinalTabela.Saida_1.Subtract(registroLinhaFinalTabela.Entrada_1).TotalSeconds ;
                Double periodo2 = registroLinhaFinalTabela.Saida_2.Subtract(registroLinhaFinalTabela.Entrada_2).TotalSeconds ;
                registroLinhaFinalTabela.TotalHorasDia = ( periodo1 + periodo2 )/3600;
                Double n =(double) Math.Truncate(registroLinhaFinalTabela.TotalHorasDia);
                registroLinhaFinalTabela.MinutosRestantes = (int) (registroLinhaFinalTabela.TotalHorasDia - n) * 60 ;
                //registroLinhaFinalTabela.MinutosRestantes = 30 ;

                Console.WriteLine("Minutos restantes"+ registroLinhaFinalTabela.MinutosRestantes);
                Console.WriteLine(registroLinhaFinalTabela.ToString());
                listPontoTable.Add(registroLinhaFinalTabela);
            }
            /*
            data // ENTRADA_1 // SAIDA_1 // ENTRADA_2 // SAIDA_2 // totalHorasdia

            */
            Console.WriteLine(listPontoTable);
            return listPontoTable;
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