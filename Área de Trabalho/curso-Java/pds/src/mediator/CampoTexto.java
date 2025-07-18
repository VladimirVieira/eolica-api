package mediator;

class CampoTexto extends Componente {
    public CampoTexto(Mediador mediador) {
        super(mediador);
    }

    public void atualizarTexto(String texto) {
        System.out.println("CampoTexto: exibindo '" + texto + "'");
    }

    @Override
    public void acao() {
        System.out.println("CampoTexto: clicado");
    }
}

