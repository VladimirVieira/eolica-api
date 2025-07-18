import java.util.Scanner;

public class Desafio2 {

		public static void main(String[] args) {
			double a = Math.pow(6 * (3+2),2)/(3*2.0);
			double b = Math.pow(((1-5)*(2-7))/2, 2);
			double c = Math.pow(a-b,3);
			double d = c/Math.pow(10, 3);
			System.out.println(d);
			String e = "3";
			int teste = Integer.parseInt(e);
			System.out.println(teste);
			String nome = "Vladimir";
			System.out.println(nome.concat("!!!"));
			System.out.println(nome.equals("Vladimir"));
			int v = 5;
			int f = v>=5? 1 : 0;
			System.out.println(f);
			Scanner scanner = new Scanner(System.in);
			String teste2 = scanner.next();
			System.out.println(teste2);
			scanner.close();
		}
}
