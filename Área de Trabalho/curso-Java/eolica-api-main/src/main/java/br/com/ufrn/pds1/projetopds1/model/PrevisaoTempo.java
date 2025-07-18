package br.com.ufrn.pds1.projetopds1.model;

import java.util.List;

public class PrevisaoTempo {
	
	
	private List<String> data;
	private String local;
	private List<Double> tempMax;
	private List<Double> tempMin;
	private List<Double> tempMedia;
	private List<Double> velVento10m;
	private List<Double> previsaoVento;
	private List<Double> previsaoTemperatura;
	private List<Double> tempMaxPrevisao;
	private List<Double> tempMinPrevisao;
	
	public List<Double> getTempMaxPrevisao() {
		return tempMaxPrevisao;
	}
	public void setTempMaxPrevisao(List<Double> tempMaxPrevisao) {
		this.tempMaxPrevisao = tempMaxPrevisao;
	}
	public List<Double> getTempMinPrevisao() {
		return tempMinPrevisao;
	}
	public void setTempMinPrevisao(List<Double> tempMinPrevisao) {
		this.tempMinPrevisao = tempMinPrevisao;
	}
	public List<String> getData() {
		return data;
	}
	public List<Double> getPrevisaoVento() {
		return previsaoVento;
	}
	public void setPrevisaoVento(List<Double> previsaoVento) {
		this.previsaoVento = previsaoVento;
	}
	public List<Double> getPrevisaoTemperatura() {
		return previsaoTemperatura;
	}
	public void setPrevisaoTemperatura(List<Double> previsaoTemperatura) {
		this.previsaoTemperatura = previsaoTemperatura;
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
