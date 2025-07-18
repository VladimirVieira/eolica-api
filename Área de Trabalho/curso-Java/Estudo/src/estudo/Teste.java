package estudo;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		int val1 = 0;
        int val2 = 1;
        int aux = 0;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = 0;
        
        while(n<N){
            if(n==0){
                System.out.print(val1);
            }else if(n==1){
                System.out.print(val2);
            }else{
                aux = val2;
                val2 = aux+val1;
                val1 = aux;
                System.out.print(val2);
            }
            
            if(n+1!=N){
                System.out.print(" ");
            }
            
            n++;
           
        }
       scanner.close();
	}

}
