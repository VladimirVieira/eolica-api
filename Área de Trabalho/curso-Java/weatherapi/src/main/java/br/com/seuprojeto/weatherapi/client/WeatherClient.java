package br.com.seuprojeto.weatherapi.client;

import br.com.seuprojeto.weatherapi.model.WeatherResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast";

    // 1. Previsão do tempo
    public WeatherResponse fetchWeatherForecast(double latitude, double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?latitude=%.4f&longitude=%.4f&current_weather=true", API_URL, latitude, longitude);
        
        // Log da URL e resposta da API
        System.out.println("URL da API: " + url);
        
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        
        // Log do corpo da resposta
        if (response != null) {
            System.out.println("Resposta da API: " + response.toString());
        } else {
            System.out.println("Resposta da API: null");
        }
        
        return response;
    }

    // 2. Alertas Meteorológicos
    public String fetchWeatherAlerts(double latitude, double longitude) {
        // Implementar integração com alertas meteorológicos, se necessário
        return "Alerta: Nenhum alerta para a região.";
    }

    // 3. Histórico do Tempo
    public WeatherResponse fetchWeatherHistory(double latitude, double longitude, String date) {
        // Simulação
        return new WeatherResponse(); // Substituir por implementação real
    }
}
