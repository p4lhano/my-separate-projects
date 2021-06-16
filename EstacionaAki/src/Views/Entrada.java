package Views;

import java.util.Scanner;

import Controlles.MotoristaController;
import Controlles.VagaController;
import Controlles.VeiculoController;
import Models.Motorista;
import Models.VagaEstacionamento;
import Models.Veiculo;

public class Entrada {
	
	
	public static void darEntrada(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-- EstacionaAki | Chega de Veiculo --\n");
		Boolean repita = false;
		Veiculo carro;
		Motorista motorista;
		VagaEstacionamento vaga;
		
		
			System.out.println("Informe o CPF do Motorista:");
			motorista = MotoristaController.buscarCpf(sc.nextLine());
			if (motorista != null) {
				System.out.println("Encontrado: " + motorista.getNome());
				System.out.println("Informe o Placa do Veículo que chegou:");
				carro = VeiculoController.buscar(sc.nextLine());
				if (carro != null) {
					//vaga = VagaController.buscar(carro);
					//if (vaga == null) {
						
					
						do {
							System.out.println("Informe onde irá estacionar o veiculo:");
							vaga = VagaController.buscar(sc.nextLine());
						
							if (vaga == null) {
								repita = true;
								System.out.println("\nVaga não encontrada\nProcesso cancelado..............");
							} else if(vaga.getStatus()=="Ocupada") {
								System.out.println("\nVaga vaga ocupada");
								repita = true;
							} else {
								System.out.println(vaga);
								repita = false;
								System.out.println("\n\n\tDando Entrada...........\n\n");
								VagaController.darEntrada(motorista, carro, vaga);
								System.out.println(vaga);
							}
						} while (repita);// ta cagadinho esse repita aqui, corrigir depois
					//} else {
					//	System.out.println("Veiculo estacionado já em:\n" + vaga + "\n");
					//}
				} else {
					repita = true;
					System.out.println("\nCarro não encontrado\nProcesso cancelado..............");
				}
			} else {
				repita = true;
				System.out.println("\nMotorista não encontrado\nProcesso cancelado..............");
			}
		
	}
	
	
}
