import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double[][] notas = new double[3][3];
		double nota=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				nota = scanner.nextDouble();
				notas[i][j]= nota;
			}
		}
		
		System.out.println(Arrays.toString(notas));
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(notas[i][j]);
			}
		}
		System.out.println(Arrays.toString(notas));
		
		for(double[] notasAluno:notas) {
			System.out.println(Arrays.toString(notasAluno));
		}
		scanner.close();
	}
	

}
