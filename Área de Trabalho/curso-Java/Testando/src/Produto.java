
public class Produto {
	String nome;
	double preco;
	static double desconto = 25;
	
	Produto(String nomeAtual){
		nome = nomeAtual;
	}
	
	double calcularDesconto(double preco) {
		return preco - (preco * (desconto/100));
	}
}
