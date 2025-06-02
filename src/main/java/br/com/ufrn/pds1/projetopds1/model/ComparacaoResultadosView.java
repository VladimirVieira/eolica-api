package br.com.ufrn.pds1.projetopds1.model;

public class ComparacaoResultadosView {
    private DadosLocalComparativo local1;
    private DadosLocalComparativo local2;

    public ComparacaoResultadosView(DadosLocalComparativo local1, DadosLocalComparativo local2) {
        this.local1 = local1;
        this.local2 = local2;
    }

    // Getters
    public DadosLocalComparativo getLocal1() {
        return local1;
    }

    public DadosLocalComparativo getLocal2() {
        return local2;
    }
}