package Views;

import java.util.Scanner;

import Controlles.MarcaController;
import Controlles.ModeVeiculoContr;
import Models.ModeloVeiculo;

public class ModeloViews {
	private static Scanner sc = new Scanner(System.in);
	private static ModeloVeiculo modVeiculo;
	
	public static void cadastroModelo() {
		//System.out.println("\n".repeat(15));
		modVeiculo = new ModeloVeiculo();
		System.out.println("\n\t###CADASTRO DE MODELO DE VEICULO###\n");
		
		System.out.println("Informe o nome da Marca:");
		String nomeMarca = sc.nextLine();
		
		System.out.println("Informe o nome do Modelo:");
		modVeiculo.setNome(sc.nextLine());
		
		//System.out.println(marca);
		if(ModeVeiculoContr.cadastrar(modVeiculo, nomeMarca)) {
			System.out.println("Concluido!");
		} else {
			System.out.println("Erro! Modelo já existente");
			System.out.println(MarcaController.buscar(nomeMarca));
		}
		
	}
}
