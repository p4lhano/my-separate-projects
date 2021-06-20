package Views;

import java.util.Scanner;

import Controlles.MarcaController;
import Controlles.ModeVeiculoContr;
import Controlles.VagaController;
import Controlles.VeiculoController;
import Models.VagaEstacionamento;
import Models.Veiculo;

public class VeiculosViews {
	private static Scanner sc = new Scanner(System.in);
	private static Veiculo veiculo;
	public static void cadastrar() {
		veiculo = new Veiculo();
		System.out.println("\n\t###CADASTRO DE VEICULO###\n");
		System.out.println("Informe a placa do veiculo:");
		veiculo.setPlaca(sc.nextLine());
		System.out.println("Informe a cor do veiculo:");
		veiculo.setCor(sc.nextLine());
		System.out.println("Informe o nome do modelo do veiculo:");
		veiculo.setModelo(MarcaController.buscarModelo(sc.nextLine()));
		if(VeiculoController.cadastrar(veiculo)) {
			System.out.println("Veiculo ok!");
		} else {
			System.out.println("Veiculo existente");
		}
	}
}
