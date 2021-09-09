using Microsoft.EntityFrameworkCore;
using API.Models;

namespace API.Data
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
        }

        //lista de classes que deverão se tornar tabelas no banco
        public DbSet<Funcionario> Funcionarios { get; set; }
    }
}