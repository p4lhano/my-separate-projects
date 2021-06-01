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
	
	public static void darEntrada(Motorista motorista, Veiculo veiculo, VagaEstacionamento vaga) {
		vaga.setVeiculoVaga(veiculo);
		vaga.setMotorista(motorista);
		vaga.setStatus("Ocupada"); 
		vaga.setEntrada(new Date());
		
		
		//return /*Verificar um possivel retorno de uma informação como hash, id, ticket para retirada...*/;
	}
	
	public static ItemFaturamento saida(Veiculo veiculo) {
		for(VagaEstacionamento vagaExiste : estacionamento) {
			if(vagaExiste.getVeiculoVaga().getPlaca().equals(veiculo.getPlaca())) {
				vagaExiste.setSaida(new Date());
				ItemFaturamento fatura = FaturamentoController.calcular(vagaExiste);
				vagaExiste.setEntrada(null);
				vagaExiste.setSaida(null);
				vagaExiste.setMotorista(null);
				vagaExiste.setVeiculoVaga(null);
				vagaExiste.setStatus("Vazia");
				return fatura;
			}
		}
		return null;
	}
	
	public static ItemFaturamento saida(String local) {
		for(VagaEstacionamento vagaExiste : estacionamento) {
			if(vagaExiste.getLocal().equals(local) && vagaExiste.getStatus() == "Ocupado") {
				ItemFaturamento fatura = FaturamentoController.calcular(vagaExiste);
				vagaExiste.setEntrada(null);
				vagaExiste.setSaida(null);
				vagaExiste.setMotorista(null);
				vagaExiste.setVeiculoVaga(null);
				vagaExiste.setStatus("Vazia");
				return fatura;
			}
		}
		
		
		return null;
		}
	
}
