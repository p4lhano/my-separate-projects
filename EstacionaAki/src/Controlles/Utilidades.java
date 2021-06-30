package Controlles;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Models.Marca;
import Models.ModeloVeiculo;
import Models.Motorista;
import Models.VagaEstacionamento;
import Models.Veiculo;

public class Utilidades {
	private static Scanner sc = new Scanner(System.in);
	
	public static int lerInteiro() {
		boolean erro = false,erro2;
		int num=0;
		do{
			erro2= false;
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
					System.out.println("\nErro: ");
					System.out.println(e);
				} 
			} while (erro);
			if (num<1 ) {
				System.out.println("\nMenor numero permitido é o 1");
				System.out.println("Tente novamente");
				erro2= true;
			}
		} while (erro2);
		return num;
	}
	
	public static int lerInteiro(int max) {
		boolean erro = false,erro2;
		int num=0;
		do{
			erro2= false;
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
					System.out.println("\nErro: ");
					System.out.println(e);
				} 
			} while (erro);
			if (num<1 || num > max) {
				System.out.println("\nMenor numero permitido é o 1 e o maior é "+ max);
				System.out.println("Tente novamente");
				erro2= true;
			}
		} while (erro2);
		return num;
	}
	
	public static double lerDouble() {
		boolean erro;
		double num=0.0;
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


	public static void cadastroPadrao() {
		Scanner sc = new Scanner(System.in);
		VagaEstacionamento vaga = new VagaEstacionamento();
		vaga.setLocal("l2");
		System.out.println(vaga);
		if(VagaController.cadastrar(vaga)) {
			System.out.println("Vaga ok!");
		} else {
			System.out.println("Já existe vaga para este local!");
		}
		
		Marca marca = new Marca();
		marca.setNome("volvo");
		if(MarcaController.cadastrar(marca)) {
			System.out.println("Marca ok");
		} else {
			System.out.println("Marca já existe!");
		}
		
		ModeloVeiculo modVeiculo = new ModeloVeiculo();
		modVeiculo.setNome("c3");
		if(ModeVeiculoContr.cadastrar(modVeiculo, "volvo")) {
			System.out.println("Concluido!");
		} else {
			System.out.println("Erro! Modelo já existente");
		}
		
		Motorista motorista = new Motorista();
		motorista.setNome("Vitor Palhano");
		motorista.setCpf("129");
		motorista.setTelefone("419963356");
		if(MotoristaController.cadastrar(motorista)) {
			System.out.println("Motorista Cadastratado!");
		} else {
			System.out.println("+  Motorista já existe neste CPF!  +");
		}
		

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("AAA1111");
		veiculo.setCor("Branco");
		veiculo.setModelo(MarcaController.buscarModelo("c3"));
		if(VeiculoController.cadastrar(veiculo)) {
			System.out.println("Veiculo ok!");
		} else {
			System.out.println("Veiculo existente");
		}		
	}
	
}
