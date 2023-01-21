using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class AddCollumValorHora : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<double>(
                name: "ValorHora",
                table: "Funcionarios",
                type: "float",
                nullable: false,
                defaultValue: 0.0);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "ValorHora",
                table: "Funcionarios");
        }
    }
}
