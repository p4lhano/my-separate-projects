package Views;

import java.util.ArrayList;

import Controlles.FaturamentoController;
import Controlles.Utilidades;
import Models.ItemFaturamento;

public class FaturamentoViews {

	public static void renderizar(ArrayList<ItemFaturamento> faturas){
		if(faturas.size()>0) {
			int i = 0;
			double sum = 0.0;
			for(ItemFaturamento fat : faturas) {
				sum =+ fat.getValor();
				i++;
				System.out.println("item"+i+ ">>>" + fat);
			}
			System.out.println("\nFaturamento total:" + sum);
		} else {
			System.out.println("Nenhuma fatura gerada!");
		}
	}
	
	public static void renderizarPorCompetencia() {
		System.out.println("Informe o mes:");
		int mes = Utilidades.lerInteiro(12);
		System.out.println("Informe o ano:");
		int ano = Utilidades.lerInteiro(2021);
		
		FaturamentoViews.renderizar(FaturamentoController.verFatMes(mes, ano));
	}
}
