package Views;

import java.util.Scanner;

import Controlles.FaturamentoController;
import Controlles.Utilidades;
import Controlles.VagaController;


public class Principal {

	public static void main(String[] args) {
		System.out.println("Informe a taxa que deverá ser cobrada por Hora Estacionada:");
		FaturamentoController.definirTaxa(Utilidades.lerDouble());
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n\t##################\n\t## EstacionaAki ##\n\t##################");
			System.out.println("Vagas disponiveis: "+ VagaController.vagasDisponiveis() + "\t\tVagas cadastradas: " + VagaController.getEstacionamento().size());
			System.out.println("\n1 - Cadastros");
			System.out.println("2 - Visualizar...");
			System.out.println("3 - Entrada veiculo");
			System.out.println("4 - Saida veiculo");
			System.out.println("0 - Encerrar\n");
			System.out.println("Digite a opção desejada: ");
			opcao = Utilidades.lerInteiro();
			switch (opcao) {
				case 1:
					System.out.println("\n-- EstacionaAki | Cadastro --\n");
					System.out.println("1 - Cadastrar vaga");
					System.out.println("2 - Cadastrar marca");
					System.out.println("3 - Cadastrar modelo");
					System.out.println("4 - Cadastrar motorista");
					System.out.println("5 - Cadastrar Veiculo");
					System.out.println("Digite a opção desejada: ");
					opcao = sc.nextInt();
					sc.nextLine();
					switch (opcao) {
					case 1:
						VagaViews.cadastroVaga();
						break;
					case 2:
						MarcaViews.cadastroMarca();
						break;
					case 3:
						ModeloViews.cadastroModelo();
						break;
					case 4:
						MotoristaViews.cadastroMotorista();
						break;
					case 5:
						VeiculosViews.cadastrar();
						break;
					}
					break;
				case 2:
					System.out.println("\n-- EstacionaAki | Visualizar Cadastros --\n");
					System.out.println("1 - Vagas");
					System.out.println("2 - Marcas");
					System.out.println("3 - Motoristas");
					System.out.println("4 - Veiculos");
					System.out.println("5 - Todos os faturamentos");
					System.out.println("Digite a opção desejada: ");
					opcao = sc.nextInt();
					sc.nextLine();
					switch (opcao) {
					case 1:
						VagaViews.renderizar();
						break;
					case 2:
						MarcaViews.viewCadastradas();
						break;
					case 3:
						MotoristaViews.renderizar();
						break;
					case 4:
						VeiculosViews.renderizar();
						break;
					case 5:
						FaturamentoViews.renderizar();
						break;
					}
					break;
				case 3:
					Entrada.darEntrada();
					break;
				case 4:
					Saida.sair();
					break;
				case 5:
					Utilidades.cadastroPadrao();
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
