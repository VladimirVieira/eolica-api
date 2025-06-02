package br.com.ufrn.pds1.projetopds1.service;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ComunicacaoComApi {
	//Extraindo dados da open-meteo
		public Map<String, Object>obterDadosDaApi(String url){
			
			//Fazendo requisição HTTP
			RestTemplate restTemplate = new RestTemplate();
			Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);
			Map<String, Object> hourly = (Map<String, Object>) resposta.get("hourly");
			return hourly;
			//Refatorar hora/dia
		}
}
