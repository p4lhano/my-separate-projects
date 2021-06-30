package Controlles;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import Models.ItemFaturamento;
import Models.VagaEstacionamento;

public class FaturamentoController {
	public static double taxaHr= 1.0;
	private static ArrayList<ItemFaturamento> faturas = new ArrayList<ItemFaturamento>();
	
	public static ArrayList<ItemFaturamento> getFaturas() {
		return faturas;
	}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<ItemFaturamento> verFatMes(int mes, int ano){
		ArrayList<ItemFaturamento> faturasMes = new ArrayList<ItemFaturamento>(), faturasAtual = getFaturas();
			for(ItemFaturamento fat: faturasAtual) {
				if(ano == fat.getEntrada().getYear() && mes == fat.getEntrada().getMonth()) {
					faturasMes.add(fat);
				}
			}
		return faturasMes;
	}
	
	
	public static ItemFaturamento calcular(VagaEstacionamento vaga) {
		ItemFaturamento item = new ItemFaturamento();
		long tempo = vaga.getSaida().getTime() - vaga.getEntrada().getTime();
		System.out.println("Tempo long: "+tempo);
		tempo = TimeUnit.HOURS.convert(tempo, TimeUnit.MILLISECONDS);
		double periodo = (double) tempo;
		System.out.println("periodo Double: "+ periodo);
		item.setEntrada(vaga.getEntrada());
		item.setSaida(vaga.getSaida());
		item.setPeriodo(periodo);
		item.setLocal(vaga.getLocal());
		item.setMotorista(vaga.getMotorista());
		item.setVeiculo(vaga.getVeiculo());;
		item.setValor(periodo * taxaHr);
		faturas.add(item);
		return item;
	}
	
	public static void definirTaxa(double taxa) {
		taxaHr = taxa;
	}
}
