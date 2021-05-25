package Models;

import java.util.Date;

public class VagaEstacionamento {
	public VagaEstacionamento() {
		setStatus("Vazia");
	}
	
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
		
	private Date entrada;
		public Date getEntrada() {
			return entrada;
		}
		public void setEntrada(Date entrada) {
			this.entrada = entrada;
		}
		
	private Date saida;
		public Date getSaida() {
			return saida;
		}
		public void setSaida(Date saida) {
		this.saida = saida;
	}
	
	private Veiculo veiculoVaga;
		public Veiculo getVeiculoVaga() {
			return veiculoVaga;
		}
		public void setVeiculoVaga(Veiculo veiculoVaga) {
			this.veiculoVaga = veiculoVaga;
		}
	private Motorista motorista;
		
	
		public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
		@Override
		public String toString() {
			return "VAGA | Local: " + getLocal() + "; Status: " + getStatus() + "; Ocupante: " + getVeiculoVaga();
		}
	
}
