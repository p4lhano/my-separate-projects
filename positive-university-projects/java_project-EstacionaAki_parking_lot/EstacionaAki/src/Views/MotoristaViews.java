package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controlles.MarcaController;
import Controlles.MotoristaController;
import Models.Marca;
import Models.Motorista;

public class MotoristaViews {
	private static Scanner sc = new Scanner(System.in);
	private static Motorista motorista;
	
	public static void cadastroMotorista() {
		motorista = new Motorista();
		System.out.println("\n\t###CADASTRO DE MOTORISTA###\n");
		System.out.println("Informe o nome:");
		motorista.setNome(sc.nextLine());
		System.out.println("Informe o CPF:");
		motorista.setCpf(sc.nextLine());
		System.out.println("Informe o telefone:");
		motorista.setTelefone(sc.nextLine());
		
		if(MotoristaController.cadastrar(motorista)) {
			System.out.println("Motorista Cadastratado!");
		} else {
			System.out.println("++++++++++++++++++++++++++++++++++++");
			System.out.println("+  Motorista j� existe neste CPF!  +");
			System.out.println("++++++++++++++++++++++++++++++++++++");
		}
		
	}

	public static void renderizar() {
		ArrayList<Motorista> motoristas = MotoristaController.getMotoristas();
		if(motoristas.size()>0) {
			for(Motorista motorista : motoristas) {
				System.out.println(motorista);
			}
		} else {
			System.out.println("Nenhum motorista cadastrado!");
		}
	}
}
