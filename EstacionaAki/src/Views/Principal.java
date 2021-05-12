package Views;

import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		System.out.print("Hellow word");
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n-- EstacionaAki --\n");
			System.out.println("1 - Cadastrar vaga");
			System.out.println("2 - Cadastrar marca");
			System.out.println("3 - Cadastrar modelo");
			System.out.println("4 - Cadastrar motorista");
			System.out.println("5 - Dar entrada em veiculo");
			System.out.println("0 - Sair\n");
			System.out.println("Digite a opção desejada: ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				VagaCadastrar.cadastroVaga();
				break;
			case 2:
				MarcaCadastrar.cadastroMarca();
				break;
			case 3:
				ModeloCadastro.cadastroModelo();
				break;
			case 5:
				ModeloCadastro.cadastroModelo();
				break;
			case 0:
				System.out.println("\nSaindo...");
				break;
			default:
				System.out.println("\nOpção inválida!");
				break;
			}			
		} while (opcao != 0);
		sc.close();
	}

}
