package Models;


public class VagaEstacionamento extends AcaoVeiculo {
	public VagaEstacionamento() {
		setStatus(false);
	}
	
	private boolean status;
		public boolean getStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return "VAGA | Local: " + getLocal() + "; Status: " + getStatus() + "; Ocupante: " + getVeiculo();
		}
	
}
