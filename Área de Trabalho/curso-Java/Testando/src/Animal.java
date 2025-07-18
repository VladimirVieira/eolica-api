
public class Animal {
	boolean pelos;
	int idade;
	String cor;
	static String nome;
	Animal(boolean pelos, int idade, String cor){
		this.pelos = pelos;
		this.idade = idade;
		this.cor = cor;
	}
	
	void mostrarCaracteristicas() {
		System.out.println("Possui pelos:" + this.pelos);
		System.out.println("O animal possui:" + this.idade);
		System.out.println("O animal possui cor:" + this.cor);
	}
	
	static void inserirNome(String gato) {
		nome = gato;
	}
	
	static void verificarNome() {
		if(nome!=null) {
			System.out.println("O nome do animal é:"+nome);
		}
		
	}
}
