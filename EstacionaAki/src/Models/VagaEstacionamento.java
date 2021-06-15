package Models;


public class VagaEstacionamento extends AcaoVeiculo {
	public VagaEstacionamento() {
		setStatus("Vazia");
	}
	
	private String status;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return "VAGA | Local: " + getLocal() + "; Status: " + getStatus() + "; Ocupante: " + getVeiculo();
		}
	
}
