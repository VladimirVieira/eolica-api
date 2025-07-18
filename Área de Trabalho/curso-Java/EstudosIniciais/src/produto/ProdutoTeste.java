package produto;



public class ProdutoTeste {
	static int a = 3;
	public static void main(String[] args) {
		Produto produto = new Produto();
		Produto produto2 = new Produto();
		produto.ImprimirNome();
		
		produto.preco = 100;
		produto2.preco = 150;
		
		System.out.println(produto.valorComDesconto(produto.preco));
		System.out.println(produto.valorComDesconto(produto2.preco));
		System.out.println(Produto.desconto);
		
		
		
		produto2 = produto;
		System.out.println(produto + " " + produto2);
		
		ProdutoTeste valor = new ProdutoTeste();
		System.out.println();
	}

}
