import java.util.Scanner;

public class DataTeste {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Data d1 = new Data(17, 9,2025);
		Data d2 = new Data();
		
		d1.dia = 17;
		d1.mes = 9;
		d1.ano = 2025;
		d1.teste-=1;
		System.out.println(d1.teste);
		d2.teste+=2;
		System.out.println(d2.teste);
		
		d1.imprimirData();
		
		d2.imprimirData();
		
		
		scanner.close();
	}

}
