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
        public DbSet<Setor> Setores { get; set; }
        public DbSet<Funcionario> Funcionarios { get; set; }
        public DbSet<PontoFuncionario> PontosFuncionarios { get; set; }

       protected override void OnModelCreating(ModelBuilder modelBuilder) {
            modelBuilder.Entity<Funcionario>()
                .HasOne(p => p.Setor)
                .WithMany(b => b.Funcionarios)
                .HasForeignKey(x => x.SetorId)
                .IsRequired();
            modelBuilder.Entity<PontoFuncionario>()
                .HasOne(p => p.Funcionario)
                .WithMany(b => b.Pontos)
                .HasForeignKey(x => x.FuncionarioId)
                .IsRequired();
        }

/*         protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
        modelBuilder.Entity<Setor>()
            .HasMany(b => b.Funcionarios)
            .WithOne();
        }
*/
/*protected override void OnModelCreating(ModelBuilder modelBuilder)
{
    modelBuilder.Entity<Setor>()
        .HasMany(b => b.Funcionarios)
        .WithOne();

    modelBuilder.Entity<Setor>()
        .Navigation(b => b.Funcionarios)
        .UsePropertyAccessMode(PropertyAccessMode.Property);
}*/
    }
}