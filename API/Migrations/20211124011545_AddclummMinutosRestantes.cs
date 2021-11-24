using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class AddclummMinutosRestantes : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "MinutosRestantes",
                table: "PontosFolha",
                type: "int",
                nullable: false,
                defaultValue: 0);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "MinutosRestantes",
                table: "PontosFolha");
        }
    }
}
