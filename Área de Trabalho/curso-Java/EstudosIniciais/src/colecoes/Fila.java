package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
	public static void main(String[] args) {
		Queue<String> fila = new LinkedList<>();
		
		//Offer e add -> adicionam elementos na fila
		//diferença é o comportamento quando a fila tá cheia
		fila.add("Ana");
		fila.offer("Bia");
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		//Peek e element -> obter o próximo elemento
		//Quando a fila está vazia
		
		System.out.println(fila.peek()); //se a fila tiver vazia retorna false
		System.out.println(fila.peek());
		System.out.println(fila.element());//se a fila tiver vazia retorna exceção
		System.out.println(fila.element());
		
		//fila.size();
		//fila.clear();
		//fila.isEmpty();
		
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());//remove o primeiro elemento
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
	}
}
