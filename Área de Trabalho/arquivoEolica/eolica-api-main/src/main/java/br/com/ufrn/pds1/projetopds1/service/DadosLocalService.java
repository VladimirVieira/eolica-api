package br.com.ufrn.pds1.projetopds1.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ufrn.pds1.projetopds1.model.DadosLocal;

@Service
public class DadosLocalService {
	public DadosLocal pesquisarDados(String latitude, String longitude, String data) {
		String url = String.format(
        	    "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m,windspeed_10m&start_date=%s&end_date=%s&timezone=America/Fortaleza",
        	    latitude, longitude, data, data);
		
		
		RestTemplate restTemplate = new RestTemplate();

        try {
       
            var resposta = restTemplate.getForObject(url, Map.class);

            if (resposta != null) {
                var hourly = (Map<?, ?>) resposta.get("hourly");

                var temperaturas = (List<?>) hourly.get("temperature_2m");
                var ventos = (List<?>) hourly.get("windspeed_10m");

                // Pega os dados do índice 18 
                double temp = Double.parseDouble(temperaturas.get(18).toString());
                double velVento = Double.parseDouble(ventos.get(18).toString());

               
                DadosLocal info = new DadosLocal();
                info.setData(data);
                info.setLatitude(Double.parseDouble(latitude));
                info.setLongitude(Double.parseDouble(longitude));
                info.setTemperatura(temp);
                info.setVelVento(velVento);

                return info;
            }
        } catch (Exception e) {
            System.out.println("Erro!!!"+ e.getMessage());
        }
		return null;
	}
}
