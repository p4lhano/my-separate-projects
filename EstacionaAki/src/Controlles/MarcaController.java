package Controlles;

import java.util.ArrayList;

import Models.Marca;

public class MarcaController {
	
private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	
	
	
	public static boolean cadastrar(Marca marcaNova) {
		//O identificador unico será o nome
		for(Marca marcaExiste : marcas) {
			if(marcaExiste.getNome().equals(marcaNova.getNome())) {
				return false;
			}
		}
		marcas.add(marcaNova);
		return true;
	}
	
	
}
