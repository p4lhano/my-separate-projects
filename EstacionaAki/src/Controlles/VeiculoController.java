package Controlles;

import java.util.ArrayList;
import Models.Veiculo;

public class VeiculoController {
	private static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	
	public static boolean cadastrar(Veiculo novoVeiulo) {
		for(Veiculo isVeiculo : veiculos) {
			if(isVeiculo.getPlaca().equals(novoVeiulo.getPlaca())) {
				return false;
			}
		}
		veiculos.add(novoVeiulo);
		return true;
	}
	
	public static Veiculo buscar(String placa) {
		for (Veiculo isVeiculo : veiculos) {
			if(isVeiculo.getPlaca().equals(placa)) {
				return isVeiculo;
			}
		}
		return null;
	}
	
	
	
	
	
	
}
