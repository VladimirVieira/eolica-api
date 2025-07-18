package fundamento;

public class TipoString {
	public static void main(String[] args) {
		System.out.println("olá pessoal".charAt(2));
		
		String s = "Boa tarde";
		System.out.println(s.concat("!!!"));
		System.out.println(s + "!!!");
		System.out.println(s.startsWith("Boa"));
		System.out.println(s.toLowerCase().startsWith("boa"));
		System.out.println(s.toUpperCase().endsWith("TARDE"));
		System.out.println(s.length());
		System.out.println(s.toLowerCase().equals("boa tarde"));
		System.out.println(s.equalsIgnoreCase("boa tarde"));
		
		var nome = "Pedro";
		var sobrenome = "Santos";
		var idade = 33;
	//ar salario = 12345.987;
		
		System.out.println("Nome:" + nome + "\nSobrenome:" + sobrenome + "\n idade:" + idade);
		System.out.printf("O senhor %s %s tem a seguinte idade:%d", nome, sobrenome, idade);
		System.out.println("Frase qualquer".contains("qual"));
		System.out.println("Frase qualquer".indexOf("qual"));
		System.out.println("Frase qualquer".substring(6));
		System.out.println("Frase qualquer".substring(6, 10));
		System.out.println(s);
	}
}
