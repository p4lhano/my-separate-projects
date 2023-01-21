package Views;

import java.util.ArrayList;
import java.util.Scanner;

import Controlles.VagaController;
import Models.VagaEstacionamento;

public class VagaViews {
	private static Scanner sc = new Scanner(System.in);
	private static VagaEstacionamento vaga;
	
	public static void cadastroVaga() {
		//System.out.println("\n".repeat(15));
		vaga = new VagaEstacionamento();
		System.out.println("\n\t###CADASTRO DE VAGA###\n");
		System.out.println("Informe a localização da vaga:");
		vaga.setLocal(sc.nextLine());
		System.out.println(vaga);
		if(VagaController.cadastrar(vaga)) {
			System.out.println("Vaga Cadastratada!");
		} else {
			System.out.println("Já existe vaga para este local!");
		}
		
	}
	
	public static void renderizar() {
		ArrayList<VagaEstacionamento> estacionamento = VagaController.getEstacionamento();
		if(estacionamento.size()>0) {
			for(VagaEstacionamento vaga : estacionamento) {
				System.out.println(vaga);
			}
		} else {
			System.out.println("Nenhuma vaga cadastrada!");
		}
	}
	
}
