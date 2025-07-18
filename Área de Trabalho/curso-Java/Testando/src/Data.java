
public class Data {
	int dia;
	int mes;
	int ano;
	static int teste = 10;
	
	Data(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}
	
	Data(){
		dia = 1;
		mes = 1;
		ano = 1970;
	}
	
	void imprimirData() {
		System.out.println(dia+"/"+ mes +"/"+ano);
	}
}
