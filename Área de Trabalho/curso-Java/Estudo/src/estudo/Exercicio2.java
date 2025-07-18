package estudo;

import java.util.Scanner;

public class Exercicio2 {
	 public static void main(String[] args){
		 
	        /**
	         * Escreva a sua solução aqui
	         * Code your solution here
	         * Escriba su solución aquí
	         */
	         Scanner scanner = new Scanner(System.in);
	         int idade=0;
	         int somatorio=0;
	         int cont=0;
	         while (true){
	             idade = scanner.nextInt();
	             if(idade<0) {
	            	 break;
	             }
	             somatorio+=idade;
	             cont++;
	         }
	         System.out.print(somatorio/((double)(cont)));
	         scanner.close();
	 
	    }

}
