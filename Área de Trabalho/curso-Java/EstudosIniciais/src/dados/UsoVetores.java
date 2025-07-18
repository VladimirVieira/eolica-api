package dados;

import java.util.Arrays;

public class UsoVetores {
	public static void main(String[] args) {
		double[] a = new double[5];
		double[] notasAluno = {8.9, 9, 8.4, 10};
		a[0] = 20;
		a[1] = 15;
		a[2] = 23;
		a[3] = 29;
		System.out.println(Arrays.toString(a));
		System.out.println(a[1]);
		System.out.println(a[4]);
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println(Arrays.toString(notasAluno));
		System.out.println("Uso do foreach");
		for (double d : notasAluno) {
			System.out.print(d + " ");
			
		}
	}
}
