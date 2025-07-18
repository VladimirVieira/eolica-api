package controle;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe a média:");
		double media = entrada.nextDouble();
		
		if(media>=7.0 && media<=10) {
			System.out.println("Aprovado");
		}
		
		if(media>=5.0 && media<=6.9) {
			System.out.println("Recuperacao");
		}
		entrada.close();
	}

}
