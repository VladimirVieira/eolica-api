package abstractfactory;

public class Jogo {
    public static void main(String[] args) {
        // Troque entre as fábricas para ver diferentes labirintos
        FabricaLabirinto fabrica = new FabricaLabirintoEncantado();
        //FabricaLabirinto fabrica = new FabricaLabirintoNormal();

        Sala sala = fabrica.criarSala();
        Parede parede = fabrica.criarParede();

        sala.entrar();
        parede.descrever();
    }
}
