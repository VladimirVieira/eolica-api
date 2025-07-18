package br.com.ufrn.pds1.projetopds1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufrn.pds1.projetopds1.exception.DadosInvalidosException;
import br.com.ufrn.pds1.projetopds1.model.DadosLocal;
import br.com.ufrn.pds1.projetopds1.model.DadosLocalModel;

@Service
public class DadosLocalEolicaService extends DadosLocalServiceTemplate {
	
	@Autowired
	private ComunicacaoComApi comunicaoApi;
//*************************************************************************************************************************************************************************
			//Constroi a URL
			@Override
			public String construirUrl(String latitude, String longitude, String data) {
							
				return  String.format(
						"https://api.open-meteo.com/v1/forecast?"
						+ "latitude=%s&"
						+ "longitude=%s&"
						+ "hourly=temperature_2m,windspeed_10m&start_date=%s&end_date=%s&timezone=America/Fortaleza"
						,latitude, longitude, data, data);
			}
			
//*************************************************************************************************************************************************************************
			//Método para obter dados de temperatura do dia
			@Override
			public Double obterDadosFator1(Map<String, Object> hourly){
				
				if (hourly == null) {
					throw new DadosInvalidosException("Apresenta dados inválidos para temperatura");
				}
				
				List<Double> temperaturas = (List<Double>) hourly.get("temperature_2m");
				return temperaturas.get(18);
				//Aqui muda
			}
			
//************************************************************************************************************************************************************************
		//Método para obter dados de ventos do dia
			@Override
			public Double obterDadosFator2(Map<String, Object> hourly){
				
				if (hourly == null) {
					throw new DadosInvalidosException("Apresenta dados inválidos para ventos");
				}
		        
				List<Double> ventos = (List<Double>) hourly.get("windspeed_10m");
				return ventos.get(18);
				//Aqui muda
			}
			
//************************************************************************************************************************************************************************	

			@Override
			public DadosLocalModel pesquisarDados(String latitude, String longitude, String data) {
				//aqui tem de ser mais geral o nome das variáveis
				double lat = Double.parseDouble(latitude);
				double lon = Double.parseDouble(longitude);

				validarLatitudeLongitude(lat,lon);
				
				
				String url = construirUrl(latitude, longitude, data);
				Map<String, Object> hourly = obterDadosDaApi(url);

		        // Pega os dados do índice 18 
		        double temp = obterDadosFator1(hourly);
		        double velVento = obterDadosFator2(hourly);

		               
		        DadosLocalModel informacao = new DadosLocalModel();
		        informacao.setData(data);
		        informacao.setLatitude(lat);
		        informacao.setLongitude(lon);
		        informacao.setFator1(temp);
		        informacao.setFator2(velVento);

		        return informacao;
		           
			}
}
