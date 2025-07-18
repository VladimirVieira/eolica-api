package produto;



public class Produto {
	
	String nome;
	double preco;
	static double desconto = 0.25;
	
	public Produto() {
		
	}
	
	public void ImprimirNome() {
		System.out.println("Vladimir");
	}
	
	double valorComDesconto(double valor) {
		return (valor-(valor * desconto) );
	}
	
}


