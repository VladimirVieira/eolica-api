package mundo;

import java.awt.Window.Type;
import java.sql.Date;
import java.util.Scanner;

public class Ola {
	//teste
	
	/**
	 * @author vladimirvieira
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		long i = 11;
		short o = 1;
		byte u = 0;
		double b = 15.05;
		double c = 21;
		boolean d = true;
		char e = 'b';
		final int CONSTANTE = 12;
		Date dados = new Date(i);
		System.out.println(dados);
		String nome = "Vladimir Vieira";
		System.out.println(nome.toUpperCase());
		nome = nome.replace('V', 'T').toLowerCase().concat("YYYYY");
		System.out.println(nome);
		
		Scanner teste = new Scanner(System.in);
		int valor = teste.nextInt();
		System.out.println(valor);
		
		System.out.println("Olá mundo");
		System.out.println(8/8);
		System.out.println(4^(1/2));
		System.out.println(4%3);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(i);
		System.out.println(o);
		System.out.println(u);
		System.out.println(CONSTANTE);
//		System.out.println(teste);
		System.out.println("Vladimir".equals("Vladimir"));
		double f = 58;
		System.out.println((f-32)*(5.0/9));
		System.out.println("Vladimir Viera".charAt(2));
		System.out.println("Vladimir Vieira".startsWith("Vlad"));
		System.out.println("Vladimir Vieira".length());
		
		
		var nome1 = "Vladimir";
		
	}

}
