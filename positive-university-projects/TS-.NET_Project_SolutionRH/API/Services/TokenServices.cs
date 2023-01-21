using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using API.Models;
using Microsoft.IdentityModel.Tokens;

namespace API.Services
{
    public static class TokenServices
    {
        public static string CriadorToken(Usuario usuario){
            JwtSecurityTokenHandler tokenHandler = new();
            byte[] key = Encoding.ASCII.GetBytes(Settings.secrect);
            SecurityTokenDescriptor tokenDescriptor = new() {
                Expires = DateTime.UtcNow.AddHours(3),
                SigningCredentials = new SigningCredentials(
                    new SymmetricSecurityKey(key),
                    SecurityAlgorithms.HmacSha256Signature
             ),
            Subject = new ClaimsIdentity( new Claim[] {
                new Claim(ClaimTypes.Name,usuario.Login),
                new Claim(ClaimTypes.Role,usuario.Permissao)
            } )
            };
            SecurityToken token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}