package Controlles;

import java.util.ArrayList;

import Models.Marca;
import Models.ModeloVeiculo;

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
	
	public static Marca buscar(String nome) {
		for (Marca essaMarca : marcas) {
			if(essaMarca.getNome().equals(nome)) {
				return essaMarca;
			}
		}
		return null;
	}
	
	public static ModeloVeiculo buscarModelo(String nome) {
		for (Marca essaMarca : marcas) {
			for (ModeloVeiculo modelo : essaMarca.getModelos()) {
				if (modelo.getNome().equals(nome)) {
					return modelo;
				}
			}
		}
		return null;
	}
	
	}
