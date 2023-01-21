package Views;

import java.util.Scanner;

import Controlles.Utilidades;
import Controlles.VagaController;
import Controlles.VeiculoController;
import Models.ItemFaturamento;
import Models.Veiculo;

public class Saida {
	public static void sair() {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sair por Placa(1)\nSair por Local Estacionado(2)");
		op = Utilidades.lerInteiro();
		switch (op) {
		case 1:
			System.out.println("\nSair por Placa\tInforme a placa:");
			Veiculo veiculo = VeiculoController.buscar(sc.nextLine());
			if (veiculo != null) {
				System.out.println("Cobrar: R$ " + VagaController.saida(veiculo).getValor());
			} else {
				System.out.println("\nPlaca não encontrada");
			}
			break;
		case 2:
			System.out.println("\nSair por Local\tInforme o local:");
			ItemFaturamento item = VagaController.saida(sc.nextLine());
			if (item != null) {
				System.out.println("Cobrar: R$ " + item.getValor());
			} else {
				System.out.println("Erro ao buscar");
			}
			break;
		}
	}
}
