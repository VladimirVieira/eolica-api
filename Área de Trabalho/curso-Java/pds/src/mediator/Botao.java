package mediator;

class Botao extends Componente {
    public Botao(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void acao() {
        System.out.println("Botão: pressionado");
        mediador.notificar(this, "confirmar");
    }
}
