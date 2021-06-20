package Models;

import java.util.ArrayList;

public class ModeloVeiculo {
	
	private String nome;
		public void setNome(String nome) {
		this.nome = nome;
	}


		public String getNome(){
			return nome;
		}
		
	
		@Override
		public String toString() {
			return "\n\t" + nome;
		}
}
