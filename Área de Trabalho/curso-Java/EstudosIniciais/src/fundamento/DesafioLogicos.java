package fundamento;

public class DesafioLogicos {
	public static void main(String[] args) {
		//Trabalho na terça (V ou F)
		//Trabalho na quinta (V ou F)
		
		boolean trabalho1 = false;
		boolean trabalho2 = false;
		
		boolean comprouTV50 = trabalho1 && trabalho2;
		boolean comprouSorvete = trabalho1 || trabalho2;
		
		//operador unário
		boolean maisSaudavel = !comprouSorvete;
		System.out.println("Comrpu TV \"? " + comprouTV50);
		
		
		System.out.println("Mais saudavel?" + !comprouSorvete);
	}

}
