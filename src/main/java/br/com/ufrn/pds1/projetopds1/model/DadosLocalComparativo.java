package br.com.ufrn.pds1.projetopds1.model;

public class DadosLocalComparativo {
    private String identificador; // Ex: "Local 1 (Lat: -5.8, Lon: -35.2)"
    private Double mediaVentoTrimestre1;
    private Double mediaVentoTrimestre2;
    private Double mediaVentoTrimestre3;
    private Double mediaVentoTrimestre4;

    public DadosLocalComparativo(String identificador, Double mediaVentoTrimestre1, Double mediaVentoTrimestre2, Double mediaVentoTrimestre3, Double mediaVentoTrimestre4) {
        this.identificador = identificador;
        this.mediaVentoTrimestre1 = mediaVentoTrimestre1;
        this.mediaVentoTrimestre2 = mediaVentoTrimestre2;
        this.mediaVentoTrimestre3 = mediaVentoTrimestre3;
        this.mediaVentoTrimestre4 = mediaVentoTrimestre4;
    }

    // Getters
    public String getIdentificador() {
        return identificador;
    }

    public Double getMediaVentoTrimestre1() {
        return mediaVentoTrimestre1;
    }

    public Double getMediaVentoTrimestre2() {
        return mediaVentoTrimestre2;
    }

    public Double getMediaVentoTrimestre3() {
        return mediaVentoTrimestre3;
    }

    public Double getMediaVentoTrimestre4() {
        return mediaVentoTrimestre4;
    }
}