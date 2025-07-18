package dados;

import java.util.Scanner;

public class DesafioVetores {
	public static void main(String[] args) {
		Scanner tamanho = new Scanner(System.in);
		System.out.print("Digite quantas notas vão ser analisadas:");
		int tam = tamanho.nextInt();
		double somatorioTot = 0;
		double[] notas = new double[tam];
		
		
		for(int i = 0; i<tam; i++) {
			System.out.print("Digite nota " + i + ":");
			notas[i] = tamanho.nextDouble();
			System.out.println();
		}
		
		for(double nota: notas) {
			somatorioTot += nota;
		}
		System.out.println(somatorioTot/notas.length);
		tamanho.close();
		
	}
}
