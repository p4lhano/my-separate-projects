package Models;

import java.util.ArrayList;

public class Marca {
	private String nome;
		public String getNome(){
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	private ArrayList<ModeloVeiculo> modelos;
		public ArrayList<ModeloVeiculo> getmodelos() {
			return modelos;
		}
	
		public void setModeloveiculo(ArrayList<ModeloVeiculo> modelos) {
			this.modelos = modelos;
		}
}
