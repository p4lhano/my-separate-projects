package Models;

public class Veiculo {
	
	private String placa;
		public String getPlaca() {
			return placa;
		}
	
		public void setPlaca(String placa) {
			this.placa = placa;
		}
	
	
	

	private String cor;
		public String getCor() {
			return cor;
		}
	
		public void setCor(String cor) {
			this.cor = cor;
		}
		
		
		
	private ModeloVeiculo modelo;
	public ModeloVeiculo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloVeiculo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Placa: " + placa + " | " + cor + "\nmodelo:" + modelo;
	}

	
}
