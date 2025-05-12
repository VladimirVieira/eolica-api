package br.com.ufrn.pds1.projetopds1.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ufrn.pds1.projetopds1.model.Alertas;
import br.com.ufrn.pds1.projetopds1.model.PrevisaoTempo;

@Service
public class PrevisaoTempoService {
	
	private final List<PrevisaoTempo> previsaoTempo = new ArrayList<>();

	public PrevisaoTempo armazenarDadosPrevisao(double latitude, double longitude) {
		
		
		//Definindo o intervalo de datas
		LocalDate dataHoje = LocalDate.now();
		LocalDate dataAnterior = dataHoje.minusYears(15);
		String dataAtual = dataHoje.toString();
		String dataNormalizada = dataAnterior.toString();
		
		//Extraindo dados da open-meteo
		String urlPrevisao = String.format("https://archive-api.open-meteo.com/v1/archive"
				+ "?latitude=%s"
				+ "&longitude=%s"
				+ "&start_date=%s"
				+ "&end_date=%s"
				+ "&daily=temperature_2m_max,temperature_2m_min,windspeed_10m_max"
				+ "&timezone=America/Fortaleza","-5.8", "-35.2", dataNormalizada, dataAtual);
		
		
		//Fazendo requisição HTTP
		RestTemplate restTemplatePrevisao = new RestTemplate();
		
		Map<String, Object> respPrevisao = restTemplatePrevisao.getForObject(urlPrevisao, Map.class);
		Map<String, Object> dailyPrevisao = (Map<String, Object>) respPrevisao.get("daily");
		
		//armazenando dados
		PrevisaoTempo armazemDadosPrevisao = new PrevisaoTempo();
		
		armazemDadosPrevisao.setData((List<String>) dailyPrevisao.get("time"));
		armazemDadosPrevisao.setLocal("Latitude:" + latitude + "Longitude:" + longitude);
		armazemDadosPrevisao.setTempMax((List<Double>) dailyPrevisao.get("temperature_2m_max"));
		armazemDadosPrevisao.setTempMin((List<Double>) dailyPrevisao.get("temperature_2m_min"));
		armazemDadosPrevisao.setVelVento10m((List<Double>) dailyPrevisao.get("windspeed_10m_max"));
		
		
		//Previsão para 7 dias para  ventos
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate coletaData = LocalDate.now(); 
		List<Double> historicoVento = (List<Double>) dailyPrevisao.get("time");
		List<Double> tempMaior = (List<Double>) dailyPrevisao.get("temperature_2m_max");
		List<Double> tempMenor = (List<Double>) dailyPrevisao.get("temperature_2m_min");
		List<Double> mediasVentPorDia = new ArrayList<>();
		List<Double> mediasTempPorDia = new ArrayList<>();
		List<Double> temMaiorPrev = new ArrayList<>();
		List<Double> temMenorPrev = new ArrayList<>();

		
		
		//manipulando dias
		for(int i = 1; i<8;i++) {
			LocalDate coletaDataCopia = coletaData.plusDays(i);
			
			Double somatorio = 0.0;
			Double somatorioTemp = 0.0;
			Double somatorioTempMax = 0.0;
			Double somatorioTempMin = 0.0;
			
			//manipulando anos
			for(int j = 1; j<15;j++) {
				LocalDate datacopia = coletaDataCopia.minusYears(j);
				String dataModificada = datacopia.format(formatter);
				
				int indiceData = historicoVento.indexOf(dataModificada);
				
				Double vent = armazemDadosPrevisao.getVelVento10m().get(indiceData);
				Double tempSup = armazemDadosPrevisao.getTempMax().get(indiceData);
				Double tempInf = armazemDadosPrevisao.getTempMin().get(indiceData);
			
	            somatorio += vent;
	            somatorioTemp += ((tempSup + tempInf)/2);
	            somatorioTempMax+=tempSup;
	            somatorioTempMin+=tempInf;
			}
			somatorio/=15;
			somatorioTemp/=15;
			somatorioTempMax/=15;
			somatorioTempMin/=15;
			
			
			temMaiorPrev.add(somatorioTempMax);
			temMenorPrev.add(somatorioTempMin);
			mediasVentPorDia.add(somatorio);
			mediasTempPorDia.add(somatorioTemp);
			
		}
		
		//armazenando os dados da listaVentPorDia, tempPorDia
		armazemDadosPrevisao.setPrevisaoVento(mediasVentPorDia);
		armazemDadosPrevisao.setPrevisaoTemperatura(mediasTempPorDia);
		armazemDadosPrevisao.setTempMaxPrevisao(temMaiorPrev);
		armazemDadosPrevisao.setTempMinPrevisao(temMenorPrev);
		
		previsaoTempo.add(armazemDadosPrevisao);
		
		return armazemDadosPrevisao;
		
	}
	
	//******************************************Previsão do tempo***************************************************************

	public List<Alertas> verificarAlertas(PrevisaoTempo infoPrev) {
		List<Alertas> info = new ArrayList<>();

		List<Double> tempMaxPrevisao = infoPrev.getTempMaxPrevisao();

		for (int i = 0; i < tempMaxPrevisao.size(); i++) {
			Double temperatura = tempMaxPrevisao.get(i);

			if (temperatura != null && temperatura >= 35) {
				info.add(new Alertas("Calor Extremo", "Temperatura muito alta prevista: "));
			} else {
				info.add(new Alertas("Normal", "Normal"));
			}
		}

		return info;
	}
	
	//*****************************************Emissao de alertas**************************************************************
}
