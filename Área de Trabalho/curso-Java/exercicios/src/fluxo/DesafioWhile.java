package fluxo;

import java.util.Scanner;

public class DesafioWhile {
	public static void main(String[] args) {
		Scanner nota = new Scanner(System.in);
		
		double pontuacao = 0;
		double somatorio = 0;
		int cont = 0;
		
		while(pontuacao>=0) {
			
			pontuacao = nota.nextDouble();
			if(pontuacao>=0 && pontuacao<=10) {
				somatorio += pontuacao;
				cont++;
			}
		}
		
		System.out.println("Total de notas:" + cont);
		System.out.println("Somatorio:" + somatorio);
		
		nota.close();
		
	}

}
