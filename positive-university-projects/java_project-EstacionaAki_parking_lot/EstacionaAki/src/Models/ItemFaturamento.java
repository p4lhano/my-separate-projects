package Models;
import java.text.DateFormat;
import java.util.Locale;

public class ItemFaturamento extends AcaoVeiculo {
	
	private double periodo;
	private double valor;
	private DateFormat sdf;
	
	public double getPeriodo() {
		return periodo;
	}
	public void setPeriodo(double periodo) {
		this.periodo = periodo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
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
