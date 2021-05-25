package Controlles;

import Models.Marca;
import Models.ModeloVeiculo;


public class ModeVeiculoContr {

	public static boolean cadastrar(ModeloVeiculo modeloNovo, String marca) {
		
		//O identificador unico será o nome
		System.out.println(marca);
		Marca marcaModelo = MarcaController.buscar(marca);
		System.out.println(marcaModelo);
		if (marcaModelo != null) {
			System.out.println(marcaModelo.getModelos().size());
			for (ModeloVeiculo modeloExiste : marcaModelo.getModelos()) {
				if (modeloExiste.getNome().equals(modeloNovo.getNome())) {
					return false;
				}
			}
		}
			
			marcaModelo.addModeloVeiculo(modeloNovo);
		
		return true;
	}
	
	
	
	
}
