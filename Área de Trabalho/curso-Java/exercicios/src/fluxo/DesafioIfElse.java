package fluxo;

import java.util.Scanner;

public class DesafioIfElse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do dia da semana:");
		String diaSemana = scanner.nextLine();
		
		if(diaSemana.contentEquals("Domingo")){
			System.out.println("1");
		}else if(diaSemana.contentEquals("Segunda")){
			System.out.println("2");
		}else if(diaSemana.contentEquals("Terça")){
			System.out.println("3");
		}else if(diaSemana.contentEquals("Quarta")){
			System.out.println("4");
		}else if(diaSemana.contentEquals("Quinta")){
			System.out.println("5");
		}else if(diaSemana.contentEquals("Sexta")){
			System.out.println("6");
		}else{
			System.out.println("7");
		}
		
		scanner.close();
	}

}
