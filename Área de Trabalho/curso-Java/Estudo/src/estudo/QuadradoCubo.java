package estudo;

import java.util.Scanner;

public class QuadradoCubo {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		
//		int entrada = scanner.nextInt();
//		int val = 1;
//		for(int i = 0;i<entrada;i++) {
//			System.out.println(val + " " + Math.pow(val, 2) + " " + Math.pow(val, 3));
//			val++;
//		}
//		
//		scanner.close();
		
		 Scanner scanner = new Scanner(System.in);
         
         int entrada = scanner.nextInt();
         int val = 1;
         
         for (int i = 0;i<entrada;i++){
             System.out.println(val+" "+((int)(Math.pow(val,2)))+ " "+ ((int)Math.pow(val,3)));
             System.out.println(val+" "+((int)(Math.pow(val,2)+1))+ " "+(int) (Math.pow(val,3)+1));
             val++;
         }
        
         scanner.close();
	}

}
