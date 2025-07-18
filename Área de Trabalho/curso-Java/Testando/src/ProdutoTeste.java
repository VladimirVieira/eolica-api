import java.util.Scanner;

public class ProdutoTeste {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Produto p1 = new Produto("Vieira");
		
		Produto p2 = new Produto("Nascimento");
		
		Produto p3 = new Produto("Carioteca");
		
		//System.out.println(p1.desconto);
		
		p1.nome = "Vladimir";
		p2.nome = "Vieira";
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		
		p1.preco = 29;
		p3.preco =50;
		
		double res = p1.calcularDesconto(p1.preco);
		double res3 = p3.calcularDesconto(p3.preco);
		System.out.println(res);
		System.out.println(res3);
		entrada.close();
	}

}
