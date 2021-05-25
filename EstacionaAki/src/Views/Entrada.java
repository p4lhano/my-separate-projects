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
				System.out.println("Informe onde irá estacionar o veiculo:");
				vaga = VagaController.buscar(sc.nextLine());
				if (vaga == null) {
					System.out.println("\nVaga não encontrada\nDeseja realizar o cadastro?");
				} else if(vaga.getStatus()=="Ocupada") {
					System.out.println("\nVaga vaga ocupada");
				} else {
					System.out.println("\n\n\tDando Entrada...........\n\n");
					VagaController.darEntrada(motorista, carro, vaga);
				}
				
			} else {
				System.out.println("\nCarro não encontrado\nDeseja realizar o cadastro?");
			}
		} else {
			System.out.println("\nMotorista não encontrado\nDeseja realizar o cadastro?");
		}
		
	}
	
	
}
