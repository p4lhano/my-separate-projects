package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controlles.MarcaController;
import Models.Marca;

public class MarcaViews {
	private static Scanner sc = new Scanner(System.in);
	private static Marca marca;
	
	public static void cadastroMarca() {
		//System.out.println("\n".repeat(15));
		marca = new Marca();
		System.out.println("\n\t###CADASTRO DE Marca###\n");
		System.out.println("Informe o nome da Marca:");
		marca.setNome(sc.nextLine());
		//System.out.println(marca);
		if(MarcaController.cadastrar(marca)) {
			System.out.println("Marca Cadastratada!");
		} else {
			System.out.println("Marca já existe!");
		}
		
	}
	
	public static void viewCadastradas() {
		ArrayList<Marca> marcas = MarcaController.getMarcas();
		if(marcas.size()>0) {
			for(Marca marca : marcas) {
				System.out.println(marca);
			}
		} else {
			System.out.println("Nenhuma marca cadastrada!");
		}
	}
}
