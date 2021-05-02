package Models;



public class VagaEstacionamento {
	private String local;
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
		
	private String status;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	private String entrada;
		public String getEntrada() {
			return entrada;
		}
		public void setEntrada(String entrada) {
			this.entrada = entrada;
		}
		
	private String saida;
		public String getSaida() {
			return saida;
		}
		public void setSaida(String saida) {
		this.saida = saida;
	}
	
	private Veiculo veiculoVaga;
		public Veiculo getVeiculoVaga() {
			return veiculoVaga;
		}
		public void setVeiculoVaga(Veiculo veiculoVaga) {
			this.veiculoVaga = veiculoVaga;
		}
	
}
