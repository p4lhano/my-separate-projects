package Controlles;

import java.util.ArrayList;

import Models.Motorista;

public class MotoristaController {
	//Colocar o motorista, verificar o relaciomento correto entre morista~vaga, ADD.
	//Se não me engano, motorista é uma lista a parte de vaga, tendo ou podendo ser cadastrado antes da entrada de qualquer veiculo,.

	private static ArrayList<Motorista> motoristas = new ArrayList<Motorista>();

	public static boolean cadastrar(Motorista novoMotorista) {
		for(Motorista motorista : motoristas) {
			if(motorista.getCpf().equals(novoMotorista.getCpf())) {
				return false;
			}
		}
		motoristas.add(novoMotorista);
		return true;
	}
	
	public static Motorista buscarCpf(String cpf) {
		for (Motorista esseMotorista : motoristas) {
			if(esseMotorista.getCpf().equals(cpf)) {
				return esseMotorista;
			}
		}
		return null;
	}


}
