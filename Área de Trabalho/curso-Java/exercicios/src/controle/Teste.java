package controle;

import java.math.BigDecimal;

public class Teste {
	public static void main(String[] args) {
		
		BigDecimal nota1 = new BigDecimal("10");
		BigDecimal nota2 = new BigDecimal("9");
		BigDecimal nota3 = new BigDecimal("8");
		BigDecimal res = nota1.add(nota2).add(nota3);
		System.out.println(res.divide(new BigDecimal ("3")));
		
		Integer valor = 75;
		System.out.println(valor.compareTo(75));
		
		if(valor.compareTo(75)>0) {
			System.out.println("maior");
			
		}else if(valor.compareTo(75)==0) {
			System.out.println("igual");
		}else {
			System.out.println("menor");
		}
		
	}
}
