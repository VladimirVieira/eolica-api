package produto;

public class DesafioData {
	int dia;
	int mes;
	int ano;
	
	DesafioData(){
		dia = 1;
		mes = 1;
		ano = 1970;
	}
	
	DesafioData(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}
	
	void diferencaAno(DesafioData a, DesafioData b) {
		System.out.println(b.ano - a.ano);
	}
	
	String dataFormatada() {
		return (String.format("%d / %d / %d", dia, mes, ano));
	}

}
