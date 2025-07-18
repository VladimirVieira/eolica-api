package colecoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class ConjuntoComportado {
	public static void main(String[] args) {
		Set<String> lista = new HashSet<String>();//dessa forma só aceita o tipo String
		ArrayList<String> lista2 = new ArrayList<String>();
		lista.add("Ana");
		lista.add("Carlos");
		lista.add("Pedro");
		lista.add("Luca");
		
		lista2.add("Pedro");
		lista2.add("Tiago");
		lista2.add("João");
		
		System.out.println(lista2.get(1));//acessa pelo indice
		lista2.remove(0); //remove elemento
		for(String i: lista) {
			System.out.println(i);
		}
	}

}
