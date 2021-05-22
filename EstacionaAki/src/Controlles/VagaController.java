package Controlles;
//import
import Models.VagaEstacionamento;
import Models.Motorista;
import java.util.ArrayList;

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
	
	public static boolean darEntrada(Motorista motorista, VagaController vaga) {
		
		
		
		
		return false;
	}
	
	
}
