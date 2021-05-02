package Models;

import java.util.ArrayList;

public class ModeloVeiculo {
	private String nome;
		public String getNome(){
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	private ArrayList<Veiculo> veiculosComEssa;
		public ArrayList<Veiculo> getVeiculosComEssa() {
			return veiculosComEssa;
		}
	
		public void setVeiculosComEssa(ArrayList<Veiculo> veiculosComEssa) {
			this.veiculosComEssa = veiculosComEssa;
		}
	
	
}
