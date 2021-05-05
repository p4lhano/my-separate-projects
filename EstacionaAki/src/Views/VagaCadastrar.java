package Views;

import java.util.Scanner;
import Models.VagaEstacionamento;

public class VagaCadastrar {
	private static Scanner sc = new Scanner(System.in);
	private static VagaEstacionamento vaga;
	
	public static void cadastroVaga() {
		System.out.println("\n".repeat(15));
		vaga = new VagaEstacionamento();
		System.out.println("\n\t###CADASTRO DE VAGA###\n");
		System.out.println("Informe a localização da vaga:");
		vaga.setLocal(sc.nextLine());
		System.out.println(vaga);
	}
	
	
	
}
