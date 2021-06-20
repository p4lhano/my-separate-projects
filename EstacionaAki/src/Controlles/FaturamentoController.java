package Controlles;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Models.ItemFaturamento;
import Models.VagaEstacionamento;

public class FaturamentoController {
	public static Double taxaHr= 1.0;
	private static ArrayList<ItemFaturamento> faturas = new ArrayList<ItemFaturamento>();
	
	public static ArrayList<ItemFaturamento> getFaturas() {
		return faturas;
	}

	public static ItemFaturamento calcular(VagaEstacionamento vaga) {
		ItemFaturamento item = new ItemFaturamento();
		long tempo = vaga.getSaida().getTime() - vaga.getEntrada().getTime();
		tempo = TimeUnit.HOURS.convert(tempo, TimeUnit.MILLISECONDS);
		Double periodo = (double) tempo;
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
	
	public static void definirTaxa(Double taxa) {
		taxaHr = taxa;
	}
}
