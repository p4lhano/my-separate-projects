package Views;

import java.util.ArrayList;

import Controlles.FaturamentoController;
import Models.ItemFaturamento;

public class FaturamentoViews {

	public static void renderizar(){
		ArrayList<ItemFaturamento> faturas = FaturamentoController.getFaturas();
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
	
}
