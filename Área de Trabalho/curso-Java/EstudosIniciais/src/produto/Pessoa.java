package produto;

public class Pessoa {
	String nome = null;
	double peso;
	
	Pessoa(String nome, double peso){
		this.nome = nome;
		this.peso = peso;
	}
	
	public void comidaIngerir(String nome, double peso) {
		this.peso+=peso; 
	}
	
	public void imprimirPeso() {
		System.out.println("Seu peso é:" + this.peso);
	}
}
