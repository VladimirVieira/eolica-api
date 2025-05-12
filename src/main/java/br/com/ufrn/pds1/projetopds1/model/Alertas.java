package br.com.ufrn.pds1.projetopds1.model;



public class Alertas {
	private String informacoesDia;
	private String classificacaoAlerta;
	
	public Alertas(String informacoesDia, String classificacaoAlerta) {
		this.informacoesDia = informacoesDia;
		this.classificacaoAlerta = classificacaoAlerta;
	}

	public String getInformacoesDia() {
		return informacoesDia;
	}

	public void setInformacoesDia(String informacoesDia) {
		this.informacoesDia = informacoesDia;
	}

	public String getClassificacaoAlerta() {
		return classificacaoAlerta;
	}

	public void setClassificacaoAlerta(String classificacaoAlerta) {
		this.classificacaoAlerta = classificacaoAlerta;
	}
	
	
	
	
	

	
	
}
