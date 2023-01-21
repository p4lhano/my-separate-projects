package Models;

import java.util.ArrayList;

public class Marca {
	public Marca() {
		setModeloveiculo(new ArrayList<ModeloVeiculo>());
	}
	
	private String nome;
		public String getNome(){
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		//private ModeloVeiculo modelos;
		private ArrayList<ModeloVeiculo> modelos ;
		public ArrayList<ModeloVeiculo> getModelos() {
			return modelos;
		}
	
		public void setModeloveiculo(ArrayList<ModeloVeiculo> modelos) {
			this.modelos = modelos;
		}
		
		public void addModeloVeiculo(ModeloVeiculo veiculo) {
			modelos.add(veiculo);
		}

		@Override
		public String toString() {
			return "Marca:" + nome + "\nModelos:" + modelos + "\n------";
		}
		
		
}
