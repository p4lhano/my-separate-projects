package Views;

import java.util.Scanner;

import Controlles.MarcaController;
import Models.Marca;

public class MarcaCadastrar {
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
}
