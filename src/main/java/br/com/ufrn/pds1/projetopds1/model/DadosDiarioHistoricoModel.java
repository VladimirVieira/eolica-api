package br.com.ufrn.pds1.projetopds1.model;

import java.util.List;

public class DadosDiarioHistoricoModel {
	private List<String> data;
	private String local;
	private List<Double> fator1;
	private List<Double> fator2;
	private List<Double> fatorMedia;
	private List<Double> fator3;
	private Double primeiroTrimestre;
	private Double segundoTrimestre;
	private Double terceiroTrimestre;
	private Double quartoSemestre;
	
	
	public Double getPrimeiroTrimestre() {
		return primeiroTrimestre;
	}
	public void setPrimeiroTrimestre(Double primeiroTrimestre) {
		this.primeiroTrimestre = primeiroTrimestre;
	}
	public Double getSegundoTrimestre() {
		return segundoTrimestre;
	}
	public void setSegundoTrimestre(Double segundoTrimestre) {
		this.segundoTrimestre = segundoTrimestre;
	}
	public Double getTerceiroTrimestre() {
		return terceiroTrimestre;
	}
	public void setTerceiroTrimestre(Double terceiroTrimestre) {
		this.terceiroTrimestre = terceiroTrimestre;
	}
	public Double getQuartoSemestre() {
		return quartoSemestre;
	}
	public void setQuartoSemestre(Double quartoSemestre) {
		this.quartoSemestre = quartoSemestre;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public List<Double> getFator1() {
		return fator1;
	}
	public void setFator1(List<Double> fator1) {
		this.fator1 = fator1;
	}
	public List<Double> getFator2() {
		return fator2;
	}
	public void setFator2(List<Double> fator2) {
		this.fator2 = fator2;
	}
	public List<Double> getFatorMedia() {
		return fatorMedia;
	}
	public void setFatorMedia(List<Double> fatorMedia) {
		this.fatorMedia = fatorMedia;
	}
	public List<Double> getFator3() {
		return fator3;
	}
	public void setFator3(List<Double> fator3) {
		this.fator3 = fator3;
	}
	
}
