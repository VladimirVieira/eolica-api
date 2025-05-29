package br.com.ufrn.pds1.projetopds1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ufrn.pds1.projetopds1.exception.ComunicacaoApiException;
import br.com.ufrn.pds1.projetopds1.exception.DadosInvalidosException;
import br.com.ufrn.pds1.projetopds1.model.DadosLocal;

@Service
public class DadosLocalService {
	
	@Autowired
	private ComunicacaoComApi comunicaoApi;
	//**********************************************************************************************************************
		//Constroi a URL
		public String construirUrl(String latitude, String longitude, String data) {
						
			return  String.format(
					"https://api.open-meteo.com/v1/forecast?"
					+ "latitude=%s&"
					+ "longitude=%s&"
					+ "hourly=temperature_2m,windspeed_10m&start_date=%s&end_date=%s&timezone=America/Fortaleza"
					,latitude, longitude, data, data);
		}
	
	//**********************************************************************************************************************	
	//Extraindo dados da open-meteo
	public Map<String, Object>obterDadosDaApi(String url){
		
		try {
			return comunicaoApi.obterDadosDaApi(url);
		}catch (Exception e) {
			throw new ComunicacaoApiException("Erro ao realizar a comunicacao com a API",e);
		}
			
	}
			
	//**********************************************************************************************************************
	//Método para obter dados de temperatura do dia
	public Double obterDadosTemperatura(Map<String, Object> hourly){
		
		if (hourly == null) {
			throw new DadosInvalidosException("Apresenta dados inválidos para temperatura");
		}
		
		List<Double> temperaturas = (List<Double>) hourly.get("temperature_2m");
		return temperaturas.get(18);
		
	}
	
	//**********************************************************************************************************************
	//Método para obter dados de temperatura do dia
	public Double obterDadosVentos(Map<String, Object> hourly){
		
		if (hourly == null) {
			throw new DadosInvalidosException("Apresenta dados inválidos para ventos");
		}
        
		List<Double> ventos = (List<Double>) hourly.get("windspeed_10m");
		return ventos.get(18);
		
	}
	
	
	
	//**********************************************************************************************************************
	public DadosLocal pesquisarDados(String latitude, String longitude, String data) {
		
		double lat;
		double lon;

		try {
		    lat = Double.parseDouble(latitude);
		    lon = Double.parseDouble(longitude);
		} catch (NumberFormatException e) {
		    throw new DadosInvalidosException("Latitude ou longitude não possuem valores numéricos válidos.");
		}
		

		
		String url = construirUrl(latitude, longitude, data);
		Map<String, Object> hourly = obterDadosDaApi(url);


        // Pega os dados do índice 18 
        double temp = obterDadosTemperatura(hourly);
        double velVento = obterDadosVentos(hourly);

               
        DadosLocal informacao = new DadosLocal();
        informacao.setData(data);
        informacao.setLatitude(lat);
        informacao.setLongitude(lon);
        informacao.setTemperatura(temp);
        informacao.setVelVento(velVento);

        return informacao;
           
	}
}
