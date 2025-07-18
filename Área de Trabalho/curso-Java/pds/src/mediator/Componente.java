package mediator;

abstract class Componente {
    protected Mediador mediador;

    public Componente(Mediador mediador) {
        this.mediador = mediador;
    }

    public abstract void acao();
}

