package fundamentos;

import java.util.Scanner;

public class Desafio2 {
	public static void main(String[] args) {
		int i = 0;
		
		double somatorio = 0;
		
		Scanner scanner = new Scanner(System.in);
		int cont = 0;
		
		
		while (i!=-1) {
			String valor = scanner.next();
			
			i = Integer.parseInt(valor);
			
			if (i>=0 && i<=10) {
				somatorio+=i;
				cont++;
			}
		}
		
		System.out.println("Resultado:"+(somatorio/cont));
		
		scanner.close();
	}
}
