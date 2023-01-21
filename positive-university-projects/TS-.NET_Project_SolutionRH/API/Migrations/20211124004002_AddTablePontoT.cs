using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class AddTablePontoT : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "PontosFolha",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Data = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Entrada_1 = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Entrada_2 = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Saida_1 = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Saida_2 = table.Column<DateTime>(type: "datetime2", nullable: false),
                    TotalHorasDia = table.Column<double>(type: "float", nullable: false),
                    FuncionarioId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PontosFolha", x => x.Id);
                    table.ForeignKey(
                        name: "FK_PontosFolha_Funcionarios_FuncionarioId",
                        column: x => x.FuncionarioId,
                        principalTable: "Funcionarios",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_PontosFolha_FuncionarioId",
                table: "PontosFolha",
                column: "FuncionarioId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "PontosFolha");
        }
    }
}
