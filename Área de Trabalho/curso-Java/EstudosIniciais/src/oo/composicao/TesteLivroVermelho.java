package oo.composicao;

public class TesteLivroVermelho {
	public static void main(String[] args) {
		LivroVermelho representante = new LivroVermelho();
		representante.animal.add(new Animal(0, "cobra"));
		representante.animal.add(new Animal(4, "Anuros"));
		representante.imprimirLista();
	}
}
