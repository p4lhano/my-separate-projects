package Controlles;

import java.util.Scanner;

public class Utilidades {
	public static int lerInteiro() {
		Scanner sc = new Scanner(System.in);
		boolean erro;
		int num=0;
		do{
			try{
				num = Integer.parseInt(sc.next());
				erro = false;
			}catch(Exception e){
				erro = true;
				System.out.println("Apenas numeros\nErro:");
				System.out.println(e);
			}
		} while (erro);
		return num;
	}
}
