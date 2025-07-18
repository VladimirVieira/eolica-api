package estudo;

import java.util.Scanner;

public class TesteDeString {
	

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int valor = scanner.nextInt();
			String nome = scanner.next();
			int converte = Integer.parseInt(nome);
			
			System.out.println(valor);
			System.out.println(converte);
			scanner.close();
		}

}
