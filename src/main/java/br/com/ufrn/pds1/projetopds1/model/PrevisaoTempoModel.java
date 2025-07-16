package br.com.ufrn.pds1.projetopds1.model;

import java.util.List;

public class PrevisaoTempoModel {
	private List<String> data;
	private String local;
	private List<Double> fator1; //valor maximo ou unico
	private List<Double> fator2; //fator mínimo
	private List<Double> fator3; //media
	private List<Double> fator4; 
	private List<Double> previsaoFator1; //previsaovento
	private List<Double> previsaoFator2; //previsaoTemperatura
	private List<Double> fatorMaxPrevisao;
	private List<Double> fatorMinPrevisao;
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
	public List<Double> getFator3() {
		return fator3;
	}
	public void setFator3(List<Double> fator3) {
		this.fator3 = fator3;
	}
	public List<Double> getFator4() {
		return fator4;
	}
	public void setFator4(List<Double> fator4) {
		this.fator4 = fator4;
	}
	public List<Double> getPrevisaoFator1() {
		return previsaoFator1;
	}
	public void setPrevisaoFator1(List<Double> previsaoFator1) {
		this.previsaoFator1 = previsaoFator1;
	}
	public List<Double> getPrevisaoFator2() {
		return previsaoFator2;
	}
	public void setPrevisaoFator2(List<Double> previsaoFator2) {
		this.previsaoFator2 = previsaoFator2;
	}
	public List<Double> getFatorMaxPrevisao() {
		return fatorMaxPrevisao;
	}
	public void setFatorMaxPrevisao(List<Double> fatorMaxPrevisao) {
		this.fatorMaxPrevisao = fatorMaxPrevisao;
	}
	public List<Double> getFatorMinPrevisao() {
		return fatorMinPrevisao;
	}
	public void setFatorMinPrevisao(List<Double> fatorMinPrevisao) {
		this.fatorMinPrevisao = fatorMinPrevisao;
	}
	
	
}
