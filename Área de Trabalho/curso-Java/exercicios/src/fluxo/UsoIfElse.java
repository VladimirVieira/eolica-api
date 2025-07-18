package fluxo;

import javax.swing.JOptionPane;

public class UsoIfElse {
	public static void main(String[] args) {
		String valor = JOptionPane.showInputDialog("Informe o número desejado:");
		
		int valor_analisado = Integer.parseInt(valor);
		
		if(valor_analisado%2==0) {
			System.out.println("É par");
		}else {
			System.out.println("É impar");
		}
	}

}
