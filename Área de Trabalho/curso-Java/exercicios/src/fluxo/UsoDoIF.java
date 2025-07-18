package fluxo;

import java.util.Scanner;

public class UsoDoIF {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite um numero:");
		double valor = scanner.nextDouble();
		if(valor>0) {
			System.out.println("Valor positivo");
		}else {
			System.out.println("negativo");
		}
		
		scanner.close();
		
	}

}
