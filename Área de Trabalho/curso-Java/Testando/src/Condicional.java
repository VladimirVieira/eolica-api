import java.util.Scanner;

public class Condicional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        float valor = scanner.nextFloat();
        
        if (valor > 10) {
            System.out.println("ok");
        } else {
            System.out.println("não ok");
        }
        
        // Correção no printf, uso de %.2f para formatar o valor com duas casas decimais
        System.out.printf("meu nome é: %f\n", valor);
        
        scanner.close();
    }
}
