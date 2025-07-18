package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
	public static void main(String[] args) {
		Queue<String> fila = new LinkedList<String>();
		
		fila.add("Maria");
		fila.add("João");
		fila.add("Pedro"); //adiciona elmentos
		
		System.out.println(fila.peek());//retorna o primeiro elemento
		System.out.println(fila.element());//retorna o primeiro elemento
		
		fila.size();//tamanho da fila
		fila.clear();//limpa a fila
		fila.isEmpty(); //verifica a fila vazia
		fila.poll(); //remove um elemento
	}
}
