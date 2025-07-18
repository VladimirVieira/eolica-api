package fundamentos;

import javax.swing.JOptionPane;

public class IFelse {
	public static void main(String[] args) {
		String valor = JOptionPane.showInputDialog("Digite um valor inteiro:");
		int valor2 = Integer.parseInt(valor);
		
		if (valor2>5) {
			System.out.println("Aprovado");
		}else {
			System.out.println("Recuperação");
		}
		 
	}

}
