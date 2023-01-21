import java.util.Scanner;

public class PrincipalTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean erro;
		int num=0;
		do{
			try{
				System.out.println("Digite um numero");
				num = Integer.parseInt(sc.next());
				erro = false;
			}catch(Exception e){
				erro = true;
				
				System.out.println("Apenas numeros\nErro:");
				System.out.println(e);
			}
		} while (erro);
		
		System.out.println(num);

	}

}
