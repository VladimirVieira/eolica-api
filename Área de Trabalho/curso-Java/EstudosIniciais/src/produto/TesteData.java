package produto;

public class TesteData {
	public static void main(String[] args) {
		DesafioData data = new DesafioData();
		
		var data2 = new DesafioData();
		data.ano = 2024;
		data.mes = 1;
		data.dia = 31;
		
		data2.ano = 2023;
		data2.mes = 10;
		data2.dia = 7;
		
		var valor = Math.pow(3, 2);
		System.out.printf("data: %d / %d / %d", data.ano, data.mes, data.dia);
		System.out.println();
		System.out.printf("data2 : %d / %d / %d", data2.ano, data2.mes, data2.dia);
		System.out.println();
		System.out.println();
		var imprimir = data.dataFormatada();	
		System.out.println(imprimir + " data formatada");
		
		var data3 = new DesafioData(5, 10, 1980);
		System.out.println(data3.dataFormatada());
		System.out.println(valor);
		
	}

}
