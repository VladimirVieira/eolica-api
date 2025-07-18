//package br.com.ufrn.eolico2.service;
//
//import br.com.ufrn.eolico2.model.DadosClima;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class ClimaService {
//
//    private static final String URL_API_INMET = "https://apitempo.inmet.gov.br/estacao/";
//
//    public DadosClima buscarDadosClima(String codigo, String data) {
//        String url = URL_API_INMET + data + "/" + data + "/" + codigo;
//        RestTemplate restTemplate = new RestTemplate();
//        try {
//            DadosClima[] dadosArray = restTemplate.getForObject(url, DadosClima[].class);
//            if (dadosArray != null && dadosArray.length > 0) {
//                return dadosArray[0];
//            }
//        } catch (Exception e) {
//            // Log de erro pode ser adicionado aqui
//        }
//        return null;  // Retorna null caso não haja dados ou erro
//    }
//}
//
//package br.com.ufrn.eolico2.service;
//
//import br.com.ufrn.eolico2.model.DadosClima;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//public class ClimaService {
//
//    private static final String API_URL = "https://api.open-meteo.com/v1/forecast";
//
//    public DadosClima buscarDadosClima(String latitude, String longitude, String data) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
//                .queryParam("latitude", latitude)
//                .queryParam("longitude", longitude)
//                .queryParam("start_date", data)
//                .queryParam("end_date", data)
//                .queryParam("hourly", "temperature_2m,windspeed_10m")
//                .queryParam("timezone", "America/Fortaleza")
//                .toUriString();
//
//        try {
//            String json = restTemplate.getForObject(url, String.class);
//            return DadosClima.fromJson(json, data, latitude, longitude);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}


// ClimaService.java
package br.com.ufrn.eolico2.service;

import br.com.ufrn.eolico2.model.DadosClima;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
//import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;

@Service
public class ClimaService {

    public DadosClima buscarDadosClima(String latitude, String longitude, String data) {
//        String url = UriComponentsBuilder.fromHttpUrl("https://api.open-meteo.com/v1/forecast")
//                .queryParam("latitude", latitude)
//                .queryParam("longitude", longitude)
//                .queryParam("hourly", "temperature_2m,windspeed_10m")
//                .queryParam("start_date", data)
//                .queryParam("end_date", data)
//                .queryParam("timezone", "America/Fortaleza")
//                .toUriString();

    
        String url = String.format(
        	    "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m,windspeed_10m&start_date=%s&end_date=%s&timezone=America/Fortaleza",
        	    latitude, longitude, data, data
        	);
       
               
           
        
        
//        RestTemplate restTemplate = new RestTemplate();
//
//        try {
//            Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);
//            if (resposta != null && resposta.containsKey("hourly")) {
//                Map<String, Object> hourly = (Map<String, Object>) resposta.get("hourly");
//                Object tempo = ((java.util.List<?>) hourly.get("temperature_2m")).get(12); // Ex: meio-dia
//                Object vento = ((java.util.List<?>) hourly.get("windspeed_10m")).get(12);
//                DadosClima dados = new DadosClima();
//                dados.setData(data);
//                dados.setLatitude(Double.parseDouble(latitude));
//                dados.setLongitude(Double.parseDouble(longitude));
//                dados.setTemperatura(Double.parseDouble(tempo.toString()));
//                dados.setVelocidadeVento(Double.parseDouble(vento.toString()));
//                return dados;
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao consultar API: " + e.getMessage());
//        }
//
//        return null;
        
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Faz a requisição e recebe a resposta como um mapa
            var resposta = restTemplate.getForObject(url, Map.class);

            if (resposta != null) {
                var hourly = (Map<?, ?>) resposta.get("hourly");

                var temperaturas = (List<?>) hourly.get("temperature_2m");
                var ventos = (List<?>) hourly.get("windspeed_10m");

                // Pega os dados do índice 18 
                double temperatura = Double.parseDouble(temperaturas.get(18).toString());
                double velocidadeVento = Double.parseDouble(ventos.get(18).toString());

                // Cria e preenche o objeto de retorno
                DadosClima dados = new DadosClima();
                dados.setData(data);
                dados.setLatitude(Double.parseDouble(latitude));
                dados.setLongitude(Double.parseDouble(longitude));
                dados.setTemperatura(temperatura);
                dados.setVelocidadeVento(velocidadeVento);

                return dados;
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar API: " + e.getMessage());
        }

        return null;        
    }
}