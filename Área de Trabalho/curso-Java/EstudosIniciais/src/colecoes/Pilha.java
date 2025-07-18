package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	public static void main(String[] args) {
		Deque<String> livros = new ArrayDeque<String>();
		
		//métodos para adicionar
		livros.add("O pequeno príncipe"); //retorna valor booleano quando adicionar
		livros.push("Don quixote");
		livros.push("O Hobbit");
		
		//retornará o Hobbit pois foi o último elemento inserido na pilha
		System.out.println(livros.peek()); //se tiver sem elemento retorna null
		System.out.println(livros.element()); //se tiver sem elemento retorna exceção
		
		//começa do top da pilha a varredura de cada elemento até a base da pilha
		for(String livro: livros) {
			System.out.println(livro);
		}
		
		//métodos de remoção da pilha
		System.out.println(livros.poll());
		System.out.println(livros.pop());
		//System.out.println(livros.remove()); retorna exceção
		
		//livros.size(); //método para obter o tamanho
		//livros.clear(); //método para limpar
		//livros.contains(livros)
		//livros.isEmpty();
	}

}
