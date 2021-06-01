package Models;

import java.util.Date;

public class ItemFaturamento {
	private Date entrada;
	private Date saida;
	private Double periodo;
	private Double valor;
	private Motorista motorista;
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
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
	
	
}
