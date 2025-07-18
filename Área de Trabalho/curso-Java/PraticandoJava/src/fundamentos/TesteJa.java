package fundamentos;
import javax.swing.JOptionPane;
public class TesteJa {
	public static void main(String[] args) {
		String teste = JOptionPane.showInputDialog("Digite um inteiro aqui:");
		int valor = Integer.parseInt(teste);
		System.out.println(valor);
		System.out.printf("%s","Vladimir");
	}
}
