package mediator;

class MediadorFonte implements Mediador {
    private Lista lista;
    private CampoTexto campo;
    private Botao botao;

    public MediadorFonte() {
        lista = new Lista(this);
        campo = new CampoTexto(this);
        botao = new Botao(this);
    }

    public void iniciar() {
        lista.acao();   // simula seleção
        botao.acao();   // simula clique no botão
    }

    public void notificar(Componente componente, String evento) {
        if (componente instanceof Lista && evento.equals("selecionado")) {
            campo.atualizarTexto("Fonte Arial");
        } else if (componente instanceof Botao && evento.equals("confirmar")) {
            System.out.println("Mediador: Ação confirmada com a fonte.");
        }
    }
}

