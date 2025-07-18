package br.com.ufrn.eolico2.model;

public class DadosClima {
    private String data;
    private double temperatura;
    private double velocidadeVento;
    private double latitude;
    private double longitude;

    // Getters e Setters
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public double getVelocidadeVento() { return velocidadeVento; }
    public void setVelocidadeVento(double velocidadeVento) { this.velocidadeVento = velocidadeVento; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}

