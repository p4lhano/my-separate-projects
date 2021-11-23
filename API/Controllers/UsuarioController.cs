using API.Data;
using API.Models;
using Microsoft.AspNetCore.Mvc;
using API.Services;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;

namespace API.Controllers
{
    [ApiController]
    [Route("usuario")]
    public class UsuarioController : ControllerBase
    {
        private readonly DataContext _context;
        public UsuarioController(DataContext context)
        {
            _context = context;
        }
        //POST: /usuario/create
        [HttpPost]
        [Route("create")]
        public async Task<IActionResult> Create([FromBody] Usuario usuario) {
            usuario.Login = usuario.Login.ToLower();
            if( _context.Usuarios.FirstOrDefault(x => x.Login == usuario.Login) != null ) return BadRequest( new { message = "Usuario cadastrado" } );
            _context.Usuarios.Add(usuario);
            await _context.SaveChangesAsync();
            usuario.Senha = "";
            return Created("", usuario);
        }

        // GET: /usuario/login
        [HttpGet]
        [Route("login")]
        public IActionResult Login([FromBody] Usuario usuario)
        {
            usuario = _context.Usuarios.FirstOrDefault(u =>
                usuario.Login == u.Login &&
                usuario.Senha == u.Senha
            );
            if(usuario == null) return NotFound(new {message = "Usuario e/Ou Senha invalidos"});
            usuario.Token = TokenServices.CriadorToken(usuario);
            usuario.Senha = "";
            return Ok(usuario);
        }
        // GET: /usuario/sem
        [HttpGet]
        [Route("sem")]
        [AllowAnonymous]
        public IActionResult Sem() {
            return Ok(new {message = "Sem aconte"});
        }
        // GET: /usuario/com
        [HttpGet]
        [Route("com")]
        [Authorize]
        public IActionResult Com() {
            Usuario usuario = _context.Usuarios.FirstOrDefault(u => u.Login == User.Identity.Name);
            return Ok(new {message = "Autorizado"});
        }
        // GET: /usuario/permissao
        [HttpGet]
        [Route("permissao")]
        [Authorize (Roles = "adm")]
        public IActionResult ComPermissao() {
            Usuario usuario = _context.Usuarios.FirstOrDefault(u => u.Login == User.Identity.Name);
            return Ok(new {message = "Autorizado com permissao " + usuario.Login});
        }
    }
}