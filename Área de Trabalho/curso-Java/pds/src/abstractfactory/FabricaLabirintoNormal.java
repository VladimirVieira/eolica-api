package abstractfactory;

//Fábrica de labirinto normal
class FabricaLabirintoNormal implements FabricaLabirinto {
 public Sala criarSala() {
     return new SalaNormal();
 }
 public Parede criarParede() {
     return new ParedeNormal();
 }
}
