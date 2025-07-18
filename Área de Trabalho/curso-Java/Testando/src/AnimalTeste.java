import java.util.Scanner;
import java.util.Arrays;

public class AnimalTeste {
	public static void main(String[] args) {
		Animal pet = new Animal(true,7,"Preto");
		double[] a = new double[6];
		double[] notas = new double[5];
		//System.out.println(pet.cor);
		double[] teste = new double[3];
		
		teste[0] = 5;
		teste[1] = 6;
		teste[2] = 9;
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		a[5] = 6;
		
		notas[0] = 1;
		notas[1] = 10;
		notas[2] = 9;
		notas[3] = 7;
		notas[4] = 8;
		
		pet.mostrarCaracteristicas();
		
		Scanner scanner = new Scanner(System.in);
		Animal.verificarNome();
	
		Animal.inserirNome("Socrates");
		
		Animal.verificarNome();
		System.out.print(Arrays.toString(a));
		System.out.println(a[1]);
		System.out.println(a.length);
		
		for(double nota:notas) {
			System.out.println(nota);
		}
		System.out.println();
		for(double i:teste) {
			System.out.println(i);
		}
		scanner.close();
		
	}

}
