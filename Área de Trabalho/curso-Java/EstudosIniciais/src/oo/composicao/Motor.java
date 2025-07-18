package oo.composicao;

public class Motor {
	double fatorInjecao = 1;
	boolean ligado = false;
	Carro carro;
	
	Motor(Carro carro){
		this.carro = carro;
	}
	
	
	int giros() {
		if(!ligado) {
			return 0;
		}else {
			return (int) Math.round(fatorInjecao * 3000);
		}
	}

}
