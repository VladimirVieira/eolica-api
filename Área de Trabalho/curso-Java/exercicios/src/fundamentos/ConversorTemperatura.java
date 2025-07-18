package fundamentos;

public class ConversorTemperatura {
	public static void main(String[] args) {
		double f = 105;
		final double contante = 5/9.0; //tem de colocar 9.0, para dar um número real
		System.out.println("resultado:"+contante*(f-32)+"°C");
		//segura alt e aperta pra cima e pra baixo que move a linha
	}

}
