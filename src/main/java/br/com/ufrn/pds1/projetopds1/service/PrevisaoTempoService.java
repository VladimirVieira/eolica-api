package br.com.ufrn.pds1.projetopds1.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ufrn.pds1.projetopds1.exception.ComunicacaoApiException;
import br.com.ufrn.pds1.projetopds1.exception.DadosInvalidosException;
import br.com.ufrn.pds1.projetopds1.model.Alertas;
import br.com.ufrn.pds1.projetopds1.model.PrevisaoTempo;

@Service
public class PrevisaoTempoService {
	@Autowired
    private ComunicacaoComApiExternacao apiExterna;
	
	//*********************************************************************************************************************
	//Definindo o intervalo de datas 
	public ArrayList<String> obterData() {
		
				LocalDate dataHoje = LocalDate.now();
				LocalDate data15AnosAtras = dataHoje.minusYears(15);
				String dataAtual = dataHoje.toString();
				String dataNormalizada = data15AnosAtras.toString();
				ArrayList<String> data = new ArrayList<String>();
				data.add(dataAtual);
				data.add(dataNormalizada);
				
		return data; 
	}
	
	//**********************************************************************************************************************
	//Constroi a URL
	public String obterUrl(double latitude, double longitude, String dataNormalizada, String dataAtual) {
		
		return  String.format("https://archive-api.open-meteo.com/v1/archive"
				+ "?latitude=%s"
				+ "&longitude=%s"
				+ "&start_date=%s"
				+ "&end_date=%s"
				+ "&daily=temperature_2m_max,temperature_2m_min,windspeed_10m_max"
				+ "&timezone=America/Fortaleza",latitude, longitude, dataNormalizada, dataAtual);
	}
	
	//***********************************************************************************************************************
	//Extraindo dados da open-meteo
	public Map<String, Object>obterDadosApi(String url){
		
		try {
			return apiExterna.extrairDadosApi(url);
		}catch (Exception e) {
			throw new ComunicacaoApiException("Erro ao realizar a comunicacao com a API",e);
		}
			
		
	}

	//************************************************************************************************************************
	public PrevisaoTempo instanciarPrevisaoDoTempo(double latitude, double longitude, Map<String, Object> dailyPrevisao) {
		//armazenando dados
		if (dailyPrevisao == null) {
			throw new DadosInvalidosException("Apresenta dados inválidos");
		}
		
		PrevisaoTempo armazemDadosPrevisao = new PrevisaoTempo();
				
		armazemDadosPrevisao.setData((List<String>) dailyPrevisao.get("time"));
		armazemDadosPrevisao.setLocal("Latitude:" + latitude + "Longitude:" + longitude);
		armazemDadosPrevisao.setTempMax((List<Double>) dailyPrevisao.get("temperature_2m_max"));
		armazemDadosPrevisao.setTempMin((List<Double>) dailyPrevisao.get("temperature_2m_min"));
		armazemDadosPrevisao.setVelVento10m((List<Double>) dailyPrevisao.get("windspeed_10m_max"));
			
		return armazemDadosPrevisao;
	}
	
	//************************************************************************************************************************
	//Previsão de vento para 7 dias 
	public  Map<String, List<Double>> processarDados(PrevisaoTempo armazemDadosPrevisao, Map<String, Object> dailyPrevisao) {
		
				if (dailyPrevisao == null) {
					throw new DadosInvalidosException("Apresenta dados inválidos");
				}
		
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate coletaData = LocalDate.now(); 
				
				List<String> historicoVento = (List<String>) dailyPrevisao.get("time");
				List<Double> tempMaior = (List<Double>) dailyPrevisao.get("temperature_2m_max");
				List<Double> tempMenor = (List<Double>) dailyPrevisao.get("temperature_2m_min");
				
				List<Double> mediasVentPorDia = new ArrayList<>();
				List<Double> mediasTempPorDia = new ArrayList<>();
				List<Double> tempMaiorPrev = new ArrayList<>();
				List<Double> tempMenorPrev = new ArrayList<>();
				

				//manipulando dias
				for(int i = 1; i<8;i++) {
					LocalDate coletaDataCopia = coletaData.plusDays(i);
	
					Double somatorioVento = 0.0;
					Double somatorioTemp = 0.0;
					Double somatorioTempMax = 0.0;
					Double somatorioTempMin = 0.0;
					
					//manipulando anos
					for(int j = 1; j<=15;j++) {
						LocalDate datacopia = coletaDataCopia.minusYears(j);
						String dataModificada = datacopia.format(formatter);
						
					int indiceData = historicoVento.indexOf(dataModificada);
				        
			            Double vento = armazemDadosPrevisao.getVelVento10m().get(indiceData);
						Double tempSup = armazemDadosPrevisao.getTempMax().get(indiceData);
						Double tempInf = armazemDadosPrevisao.getTempMin().get(indiceData);
					
			            somatorioVento += vento;
			            somatorioTemp += ((tempSup + tempInf)/2);
			            somatorioTempMax+=tempSup;
			            somatorioTempMin+=tempInf;
					}
					mediasVentPorDia.add((somatorioVento/15));	
					tempMaiorPrev.add(somatorioTempMax/15);
					tempMenorPrev.add(somatorioTempMin/15);
					mediasTempPorDia.add(somatorioTemp/15);
				}
				Map<String, List<Double>> resultado = new HashMap<>();
			    resultado.put("temperaturaMaior", tempMaiorPrev);
			    resultado.put("temperaturaMenor", tempMenorPrev);
			    resultado.put("mediasTemperatura", mediasTempPorDia);
			    resultado.put("vento", mediasVentPorDia);

			    return resultado;
	}
	
	//***************************************************************************************************************************
	public PrevisaoTempo armazenarDadosPrevisao(double latitude, double longitude) {
		
		if (Double.isNaN(latitude) || Double.isNaN(longitude)) {
		    throw new DadosInvalidosException("os valores de Latitude ou longitude não são numéricos.");
		} else if(latitude<-90 || latitude>90) {
			throw new DadosInvalidosException("Os dados de latitude são inválidos, pois o intervalo válido compreende:[-90,90].");
		} else if(longitude<-180 || longitude>180) {
			throw new DadosInvalidosException("Os dados de longitude são inválidos, pois o intervalo válido compreende:[-180,180].");
		}
		
		List<String> data = obterData();
		String dataAtual = data.get(0);
		String dataNormalizada = data.get(1);
		String url = obterUrl(latitude, longitude, dataNormalizada, dataAtual);
		Map<String, Object> dailyPrevisao = obterDadosApi(url);
		PrevisaoTempo armazemDadosPrevisao = instanciarPrevisaoDoTempo(latitude, longitude, dailyPrevisao);
		Map<String, List<Double>> resultado = processarDados(armazemDadosPrevisao, dailyPrevisao); 
		

		armazemDadosPrevisao.setPrevisaoVento(resultado.get("vento"));
		armazemDadosPrevisao.setTempMaxPrevisao(resultado.get("temperaturaMaior"));
		armazemDadosPrevisao.setTempMinPrevisao(resultado.get("temperaturaMenor"));
		armazemDadosPrevisao.setPrevisaoTemperatura(resultado.get("mediasTemperatura"));
		
		return armazemDadosPrevisao;
		
	}
	
	//******************************************Previsão do tempo***************************************************************

	public List<Alertas> verificarAlertas(PrevisaoTempo infoPrev) {
		
		List<Alertas> informacao = new ArrayList<>();
		List<Double> tempMaxPrevisao = infoPrev.getTempMaxPrevisao();
		List<Double> tempMinPrevisao = infoPrev.getTempMinPrevisao();
		List<Double> ventos = infoPrev.getPrevisaoVento();

		for (int i = 0; i < tempMaxPrevisao.size(); i++) {
			
			Double temperaturaMax = tempMaxPrevisao.get(i);
			Double temperaturaMin = tempMinPrevisao.get(i);
			Double velVento = ventos.get(i);
			
			if(temperaturaMax >= 38 && velVento<19) {
				informacao.add(new Alertas((i+1)+"° dia", "Temperatura muito alta prevista e ventos fraco"));
			}else if(temperaturaMax > 31 && velVento<39) {
				informacao.add(new Alertas((i+1)+"° dia", "Temperatura elevada e vento moderado"));
			}else if(temperaturaMax < 12 && velVento>39) {
				informacao.add(new Alertas((i+1)+"° dia", "Temperatura baixa e vento forte"));
			}else if(temperaturaMax > 13 && velVento>20) {
				informacao.add(new Alertas((i+1)+"° dia", "Temperatura dentro da normalidade e vento forte"));
			}else {
				informacao.add(new Alertas((i+1)+"° dia", "Temperatura dentro da normalidade e vento moderado"));
			}
				
		}

		return informacao;
	}
	
	//*****************************************Emissao de alertas**************************************************************
}
