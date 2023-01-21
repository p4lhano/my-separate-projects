package Controlles;
import java.util.ArrayList;
import java.util.Date;

import Models.ItemFaturamento;
//import
import Models.Motorista;
import Models.VagaEstacionamento;
import Models.Veiculo;

public class VagaController {
	
	private static ArrayList<VagaEstacionamento> estacionamento = new ArrayList<VagaEstacionamento>();
	
	public static ArrayList<VagaEstacionamento> getEstacionamento() {
		return estacionamento;
	}

	public static boolean cadastrar(VagaEstacionamento vagaNova) {
		for(VagaEstacionamento vagaExiste : estacionamento) {
			if(vagaExiste.getLocal().equals(vagaNova.getLocal())) {
				return false;
			}
		}
		estacionamento.add(vagaNova);
		return true;
	}
	
	public static VagaEstacionamento buscar(String local) {
		for(VagaEstacionamento isVaga : estacionamento) {
			if(isVaga.getLocal().equals(local)) {
				return isVaga;
			}
		}
		return null;
	}
	
	public static VagaEstacionamento buscar(Veiculo veiculo) {
		for(VagaEstacionamento isVaga : estacionamento) {
			if(isVaga.getVeiculo().getPlaca().equals(veiculo.getPlaca())) {
				return isVaga;
			}
		}
		return null;
	}
	
	public static void darEntrada(Motorista motorista, Veiculo veiculo, VagaEstacionamento vaga) {
		vaga.setVeiculo(veiculo);
		vaga.setMotorista(motorista);
		vaga.setStatus(true); 
		vaga.setEntrada(new Date());
	}
	
	public static ItemFaturamento saida(Veiculo veiculo) {
		for(VagaEstacionamento vagaExiste : estacionamento) {
			if(vagaExiste.getVeiculo().getPlaca().equals(veiculo.getPlaca())) {
				vagaExiste.setSaida(new Date());
				ItemFaturamento fatura = FaturamentoController.calcular(vagaExiste);
				vagaExiste.setEntrada(null);
				vagaExiste.setSaida(null);
				vagaExiste.setMotorista(null);
				vagaExiste.setVeiculo(null);
				vagaExiste.setStatus(false);
				return fatura;
			}
		}
		return null;
	}
	
	public static ItemFaturamento saida(String local) {
		VagaEstacionamento vaga = VagaController.buscar(local);
		System.out.println(local + "\n####\n" + vaga);
		if (vaga != null) {
			if (vaga.getStatus()) {
				vaga.setSaida(new Date());
				ItemFaturamento fatura = FaturamentoController.calcular(vaga);
				vaga.setEntrada(null);
				vaga.setSaida(null);
				vaga.setMotorista(null);
				vaga.setVeiculo(null);
				vaga.setStatus(false);
				return fatura;
			}
		}
		return null;
		}
	
	public static int vagasDisponiveis() {
		if (estacionamento.size() > 0) {
			int disponiveis = 0;
			for(VagaEstacionamento vaga : estacionamento) {
				if (!vaga.getStatus()) {
					disponiveis ++;
				}
			}
			return disponiveis;
		}
		return 0;
	}
}
