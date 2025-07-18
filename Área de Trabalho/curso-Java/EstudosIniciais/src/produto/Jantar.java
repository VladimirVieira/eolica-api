package produto;

public class Jantar {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Vladimir", 61);
		Comida c1 = new Comida("Feijão", 0.0250);
		
		p1.imprimirPeso();
		p1.comidaIngerir(c1.nome, c1.peso);
		p1.imprimirPeso();
	}

}
