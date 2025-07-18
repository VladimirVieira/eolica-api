package fundamentos;
import java.util.Scanner;
public class Switch1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String entrada = scanner.next();
		
		switch (entrada.toLowerCase()){
		case "primeiro":
			System.out.println("Campeao");
			break;
		case "segundo":
			System.out.println("Vice campeao");
			break;
		case "terceiro":
			System.out.println("Ganhou um premio");
			break;
		default:
			System.out.println("ok");
		}
		
		scanner.close();
	}
}
