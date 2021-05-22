package Views;

import java.util.Scanner;
import Controlles.MotoristaController;
import Models.Motorista;

public class Entrada {
	
	
	public static void darEntrada(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-- EstacionaAki | Chega de Veiculo --\n");
		String placa;
		Motorista motorista;
		
		System.out.println("Informe o CPF do Motorista:");
		motorista = MotoristaController.buscarCpf(sc.nextLine());
		if (motorista != null) {
			System.out.println(motorista.getNome());
			
			/*Fazer o aqui um cadasto e finalizar*/
			
			
			
		} else {
			System.out.println("\nMotorista não encontrado\n");
		}
		
	}
	
	
}
