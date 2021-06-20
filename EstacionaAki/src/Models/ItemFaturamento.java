package Models;

public class ItemFaturamento extends AcaoVeiculo {
	private Double periodo;
	private Double valor;
	
	public Double getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Double periodo) {
		this.periodo = periodo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Item | Estacionou em:" + getLocal()+
				"\nPlaca:"+ getVeiculo().getPlaca()+
				"\nValor cobrado:"+getValor()+
				"\nMotorista:"+getMotorista().getNome()+
				"\nTempo:"+getPeriodo()+"\tEntrada:"+ getEntrada()+"\tSaida:"+getSaida();
	}
	
}
