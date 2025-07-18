import java.util.Scanner;
import java.util.Arrays;
public class DesafioNotas {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int quant_notas = scanner.nextInt();
		
		double[] notas = new double[quant_notas];
		
		for(int i=0;i<notas.length;i++) {
			System.out.println("Nota "+i+":");
			double nota=scanner.nextDouble();
			notas[i]+=nota;
		}
		double somatorio=0;
		for(double i:notas) {
			somatorio+=i;
		}
		
		System.out.println("Média das notas:"+(somatorio/notas.length));
		System.out.println(Arrays.toString(notas));
		scanner.close();
	}

}
