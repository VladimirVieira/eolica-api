package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	public static void main(String[] args) {
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O pequeno principe");
		livros.add("Don Quixote");
		livros.push("O hobbit");
		
		System.out.println(livros.peek());//verifica primeiro elemento
		System.out.println(livros.element());//primeiro elemento
		
		System.out.println(livros.poll());//remove o primeiro elemento
		
		livros.size();//tamanho da pilha
		livros.clear();//limpa a pilha
		livros.contains();//verifica elemento
	}
}
