package fluxo;

import java.util.Scanner;

public class IndeterminadoWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String valor = "";
		
		while(!valor.equalsIgnoreCase("Sair")) {
			System.out.println("Você diz:");
			valor = scanner.nextLine();
			
		}
		System.out.println("FIM");
		scanner.close();
	}

}
