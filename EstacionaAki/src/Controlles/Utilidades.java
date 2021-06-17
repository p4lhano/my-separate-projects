package Controlles;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {
	public static int lerInteiro() {
		Scanner sc = new Scanner(System.in);
		boolean erro = false;
		int num=0;
		do{
			try{
				num = Integer.parseInt(sc.next());
				erro = false;
			}catch(NumberFormatException eNum){
				erro = true;
				System.out.println("Apenas numeros\nErro:");
				System.out.println(eNum);
			}catch(NoSuchElementException encer) {
				System.out.println("ATENÇÃO ENCERRAMENTO BRUSCO DO SISTEMA:"+ encer);
				erro = false;
				return 0;
			} catch(Exception e) {
				erro = true;
				System.out.println("\nErro:");
				System.out.println(e);
			}
		} while (erro);
		return num;
	}
	
	public static Double lerDouble() {
		Scanner sc = new Scanner(System.in);
		boolean erro;
		Double num=0.0;
		do{
			try{
				num = Double.parseDouble(sc.next());
				erro = false;
			}catch(NumberFormatException eNum){
				erro = true;
				System.out.println("Apenas numeros\nErro:");
				System.out.println(eNum);
			}catch(NoSuchElementException encer) {
				System.out.println("ATENÇÃO ENCERRAMENTO BRUSCO DO SISTEMA:"+ encer);
				erro = false;
				return 0.0;
			}catch(Exception e) {
				erro = true;
				System.out.println("\nErro:");
				System.out.println(e);
			}
		} while (erro);
		return num;
	}
}
