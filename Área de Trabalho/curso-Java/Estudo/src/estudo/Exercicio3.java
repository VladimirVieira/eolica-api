package estudo;

import java.util.Scanner;

public class Exercicio3 {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        
	        int N = scanner.nextInt();
	        scanner.nextLine(); // Consumir a quebra de linha pendente após o nextInt()


	        for(int i = 0;i<N;i++){
	            String valor = scanner.nextLine();  
	            String[] entrada = valor.split(" ");  

	            int x = Integer.parseInt(entrada[0]);
	            int y = Integer.parseInt(entrada[1]);
	            
	            int somatorio = 0;
	            int cont = 0;
	            

	            while (cont<y) {
	                if (x % 2 != 0) {
	                    somatorio += x;
	                    cont++;
	                }
	                x++;
	            }

	            System.out.println(somatorio);
	            
	        }
        
	}

}
