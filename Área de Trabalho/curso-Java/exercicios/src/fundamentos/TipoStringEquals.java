package fundamentos;

import java.util.Scanner;

public class TipoStringEquals {
	public static void main(String[] args) {
		System.out.println("2" == "2"); //não é ideal deixar dessa forma
		
		String s1 = new String("2");
		System.out.println("2".equals(s1)); //forma ideal
		
		Scanner entrada = new Scanner(System.in);
		
		String s2 = entrada.next(); // next remove espaços, já o nextLine não
		System.out.println("2" == s2.trim());
		System.out.println("2".equals(s2.trim()));
		
		
	}

}
