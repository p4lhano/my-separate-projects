using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class TableUsuarios : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder) => migrationBuilder.CreateTable(
            name: "Usuarios",
            columns: table => new
            {
                Id = table.Column<int>(type: "int", nullable: false)
                    .Annotation("SqlServer:Identity", "1, 1"),
                Login = table.Column<string>(type: "nvarchar(max)", nullable: true),
                Senha = table.Column<string>(type: "nvarchar(max)", nullable: true),
                Permissao = table.Column<string>(type: "nvarchar(max)", nullable: true),
                Token = table.Column<string>(type: "nvarchar(max)", nullable: true)
            },
            constraints: table => table.PrimaryKey("PK_Usuarios", x => x.Id));

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Usuarios");
        }
    }
}
