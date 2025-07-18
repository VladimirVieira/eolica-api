package com.exemplo.inmetapi.model;

public class DadosMeteorologicos {
    private String local;
    private String temperatura;
    private String velocidadeVento;

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getTemperatura() { return temperatura; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }

    public String getVelocidadeVento() { return velocidadeVento; }
    public void setVelocidadeVento(String velocidadeVento) { this.velocidadeVento = velocidadeVento; }
}