package br.com.ufrn.pds1.projetopds1.service;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ComunicacaoComApiExternacao {
	//Extraindo dados da open-meteo
	public Map<String, Object>extrairDadosApi(String url){
			
			//Fazendo requisição HTTP
			RestTemplate restTemplate = new RestTemplate();
			Map<String, Object> resp = restTemplate.getForObject(url, Map.class);
			Map<String, Object> daily = (Map<String, Object>) resp.get("daily");
			return daily;
			
	}

}
