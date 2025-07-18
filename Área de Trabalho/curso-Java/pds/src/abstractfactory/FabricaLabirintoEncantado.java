package abstractfactory;

//Fábrica de labirinto encantado
class FabricaLabirintoEncantado implements FabricaLabirinto {
 public Sala criarSala() {
     return new SalaEncantada();
 }
 public Parede criarParede() {
     return new ParedeMagica();
 }
}
