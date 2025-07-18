package fluxo;

import java.util.Scanner;

public class ExerciciosEstruturaControle {
	public static void main(String[] args) {
		//Questão 1
		Scanner valor = new Scanner(System.in);
		
		int resposta = valor.nextInt();
		
		if(resposta>=0 && resposta<=10) {
			if(resposta%2==0) {
				System.out.println("Par");
			}
		}
		
		valor.close();
	}

}
