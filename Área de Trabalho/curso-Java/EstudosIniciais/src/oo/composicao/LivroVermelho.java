package oo.composicao;

import java.util.ArrayList;

public class LivroVermelho {
	ArrayList<Animal> animal = new ArrayList<Animal>();
	
	void imprimirLista() {
		for(Animal exemplar:animal) {
			System.out.print(exemplar.nome + " " + exemplar.patas);
			System.out.println();
		}
	}
}
