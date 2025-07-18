package fundamentos;
import java.util.Scanner;
public class DiasSemana {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String dia = scanner.next()	;
		
		if (dia.equals("Segunda")) {
			System.out.println(2);
		}else if(dia.equals("Terça")) {
			System.out.println(3);
		}else if(dia.equals("Quarta")) {
			System.out.println(4);
		}else if(dia.equals("Quinta")) {
			System.out.println(5);
		}else if(dia.equals("Sexta")) {
			System.out.println(6);
		}else if(dia.equals("Sabado")) {
			System.out.println(7);
		}else {
			System.out.println(1);
		}
		
		System.out.println(dia.equalsIgnoreCase("SEGUnda"));
		
		int i = 0;
		do {
			System.out.println("Vladimir");
			i++;
		}while(i<5);
		
		scanner.close();
	
		
	}

}
