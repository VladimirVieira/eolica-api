package br.com.ufrn.pds1.projetopds1.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.model.PrevisaoTempo;

@Service
public class DadosDiarioService {

//************************************************************************************************************************************	
	//Obtem o intervalo de data para emitir o histórico
	public List<String> obterIntervaloDeData() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate coletaDataAtual = LocalDate.now(); 

	    LocalDate anoPassado = LocalDate.of(coletaDataAtual.getYear() - 1, 1, 1);
	    LocalDate fimAnoPassado = LocalDate.of(coletaDataAtual.getYear() - 1, 12, 31);

	    String dataInicio = anoPassado.format(formatter);
	    String dataFim = fimAnoPassado.format(formatter);

	    List<String> intervalo = new ArrayList<>();
	    intervalo.add(dataInicio);
	    intervalo.add(dataFim);

	    return intervalo;
	}
//************************************************************************************************************************************
	//Constroi a URL
	public String montarUrl(double latitude, double longitude, String dataInicio, String dataFim) {
				
		return  String.format("https://archive-api.open-meteo.com/v1/archive"
				+ "?latitude=%s"
				+ "&longitude=%s"
				+ "&start_date=%s"
				+ "&end_date=%s"
				+ "&daily=temperature_2m_max,temperature_2m_min,windspeed_10m_max"
				+ "&timezone=America/Fortaleza",latitude, longitude, dataInicio, dataFim);
	}
	
//************************************************************************************************************************************
	
	//Extraindo dados da open-meteo
	public Map<String, Object>extrairDadosApi(String url){
			//Fazendo requisição HTTP
			RestTemplate restTemplate = new RestTemplate();
		
		
			Map<String, Object> resp = restTemplate.getForObject(url, Map.class);
			Map<String, Object> daily = (Map<String, Object>) resp.get("daily");
			return daily;
			
	}
	
//************************************************************************************************************************************
		public DadosDiariosHistorico instanciarDadosDiario(Double latitude, Double longitude,Map<String, Object> daily) {
			//armazenando dados
			
			DadosDiariosHistorico armazemDados = new DadosDiariosHistorico();
			
			armazemDados.setData((List<String>) daily.get("time"));
			armazemDados.setLocal("Latitude:" + latitude + "Longitude:" + longitude);
			armazemDados.setTempMax((List<Double>) daily.get("temperature_2m_max"));
			armazemDados.setTempMin((List<Double>) daily.get("temperature_2m_min"));
			armazemDados.setVelVento10m((List<Double>) daily.get("windspeed_10m_max"));
			
				
			return armazemDados;
		}
	
//************************************************************************************************************************************
		//Calcular Média Temperatura
		public List<Double> calcularTemperaturaMedia(List<Double> tempMaior, List<Double> tempMenor){
			List<Double> mediasPorDia = new ArrayList<>();
			
			for (int i = 0; i < tempMaior.size(); i++) {
			    double resultadoMedia = (tempMaior.get(i) + tempMenor.get(i)) / 2;
			    mediasPorDia.add(resultadoMedia);
			}
			return mediasPorDia;
		}
		
//************************************************************************************************************************************
		//Calcular velocidade média do Vento por trimestres
		public DadosDiariosHistorico calcularVelocidadeVento(List<String> datasAno, List<Double> ventos, DadosDiariosHistorico armazemDados){
			double primeiroTri = 0, segundoTri=0, terceiroTri=0, quartoTri=0;
			int cont1Tri=0, cont2Tri=0, cont3Tri=0, cont4Tri=0;
			
			
			for (int i = 0; i < datasAno.size(); i++) {
			    LocalDate data = LocalDate.parse(datasAno.get(i));
			    int mesAtual = data.getMonthValue();

			    if (mesAtual >= 1 && mesAtual <= 3) {
			        primeiroTri += ventos.get(i);
			        cont1Tri++;
			    } else if (mesAtual >= 4 && mesAtual <= 6) {
			        segundoTri += ventos.get(i);
			        cont2Tri++;
			    } else if (mesAtual >= 7 && mesAtual <= 9) {
			        terceiroTri += ventos.get(i);
			        cont3Tri++;
			    } else {
			    	quartoTri += ventos.get(i);
			        cont4Tri++;
			    }
			}
			
		
			armazemDados.setPrimeiroTrimestre(primeiroTri/cont1Tri);
			armazemDados.setSegundoTrimestre(segundoTri/cont2Tri);
			armazemDados.setTerceiroTrimestre(terceiroTri/cont3Tri);
			armazemDados.setQuartoSemestre(quartoTri/cont4Tri);
			return armazemDados;
		}
		
	
//************************************************************************************************************************************
		
		public DadosDiariosHistorico armazenarDados(double latitude, double longitude, String dataInic, String dataFin) {		
			
			List<String> dataIntervalo = obterIntervaloDeData();
			String dataInicio = dataIntervalo.get(0);
			String dataFim = dataIntervalo.get(1);
			String url = montarUrl(latitude, longitude, dataInicio, dataFim);
			Map<String, Object> daily = extrairDadosApi(url);
			DadosDiariosHistorico armazemDados = instanciarDadosDiario(latitude, longitude, daily);
			
			//obtem dados de temperatura e velocidade do vento
			List<Double> tempMaior = (List<Double>) daily.get("temperature_2m_min");
			List<Double> tempMenor = (List<Double>) daily.get("temperature_2m_max");
			List<Double> ventos = (List<Double>) daily.get("windspeed_10m_max");
			List<String> datasAno = (List<String>) daily.get("time");
			List<Double> mediasPorDia = calcularTemperaturaMedia(tempMaior, tempMenor);
					
			return calcularVelocidadeVento( datasAno, ventos, armazemDados);

		}
}
