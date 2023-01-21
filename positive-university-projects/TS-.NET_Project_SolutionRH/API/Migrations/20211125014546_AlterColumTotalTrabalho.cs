using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class AlterColumTotalTrabalho : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "MinutosRestantes",
                table: "PontosFolha");

            migrationBuilder.DropColumn(
                name: "TotalHorasDia",
                table: "PontosFolha");

            migrationBuilder.AddColumn<TimeSpan>(
                name: "TotalTrabalhado",
                table: "PontosFolha",
                type: "time",
                nullable: false,
                defaultValue: new TimeSpan(0, 0, 0, 0, 0));
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "TotalTrabalhado",
                table: "PontosFolha");

            migrationBuilder.AddColumn<int>(
                name: "MinutosRestantes",
                table: "PontosFolha",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<double>(
                name: "TotalHorasDia",
                table: "PontosFolha",
                type: "float",
                nullable: false,
                defaultValue: 0.0);
        }
    }
}
