package Models;
import java.text.DateFormat;
import java.util.Locale;

public class ItemFaturamento extends AcaoVeiculo {
	
	private Double periodo;
	private Double valor;
	private DateFormat sdf;
	
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
		Locale.setDefault(new Locale("pt","Brazil"));
		return "Item | Estacionou em:" + getLocal()+
				"\nPlaca:"+ getVeiculo().getPlaca()+
				"\nValor cobrado:"+getValor()+
				"\nMotorista:"+getMotorista().getNome()+
				"\nTempo:"+getPeriodo()+"\tEntrada:"+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(getEntrada())
										+"\tSaida:"+  DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(getSaida());
	}
	
}
