package Controlles;

import Models.Marca;
import Models.ModeloVeiculo;


public class ModeVeiculoContr {

	public static boolean cadastrar(ModeloVeiculo modeloNovo, String marca) {
		
		//O identificador unico será o nome
		Marca marcaModelo = MarcaController.buscar(marca);
		
		if (marcaModelo != null) {
			//Verificar se deveria ser instaciado um novo ArraysList de modelos nos controllers
			for (ModeloVeiculo modeloExiste : marcaModelo.getModelos()) {
				if (modeloExiste.getNome().equals(modeloNovo.getNome())) {
					return false;
				}
			}
			marcaModelo.addModeloVeiculo(modeloNovo);;
		}
		
		
/*
		for(ModeloVeiculo marcaExiste : marcas) {
			if(marcaExiste.getNome().equals(modeloNovo.getNome())) {
				return false;
			}
		}
		marcas.add(marcaNova);
		return true;
*/		
		
		return false;
	}
	
	
	
	
}
