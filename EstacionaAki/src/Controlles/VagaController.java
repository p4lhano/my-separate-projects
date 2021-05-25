package Controlles;
import java.util.ArrayList;
import java.util.Date;

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
		Date data = new Date(); 
		vaga.setEntrada(data);
		
		
		//return /*Verificar um possivel retorno de uma informação como hash, id, ticket para retirada...*/;
	}
	
	
}
