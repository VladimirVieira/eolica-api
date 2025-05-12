package br.com.ufrn.pds1.projetopds1.model;

import java.util.List;


//Camada de acesso aos dados
public class DadosDiariosHistorico {
	private List<String> data;
	private String local;
	private List<Double> tempMax;
	private List<Double> tempMin;
	private List<Double> tempMedia;
	private List<Double> velVento10m;
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
	public List<Double> getTempMax() {
		return tempMax;
	}
	public void setTempMax(List<Double> tempMax) {
		this.tempMax = tempMax;
	}
	public List<Double> getTempMin() {
		return tempMin;
	}
	public void setTempMin(List<Double> tempMin) {
		this.tempMin = tempMin;
	}
	public List<Double> getTempMedia() {
		return tempMedia;
	}
	public void setTempMedia(List<Double> tempMedia) {
		this.tempMedia = tempMedia;
	}
	public List<Double> getVelVento10m() {
		return velVento10m;
	}
	public void setVelVento10m(List<Double> velVento10m) {
		this.velVento10m = velVento10m;
	}
	
	
	
}
