package mediator;

class Lista extends Componente {
    public Lista(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void acao() {
        System.out.println("Lista: Fonte 'Arial' selecionada");
        mediador.notificar(this, "selecionado");
    }
}
