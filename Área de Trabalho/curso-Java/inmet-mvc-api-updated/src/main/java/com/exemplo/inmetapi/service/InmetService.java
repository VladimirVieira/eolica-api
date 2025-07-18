package com.exemplo.inmetapi.service;

import com.exemplo.inmetapi.model.DadosMeteorologicos;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class InmetService {
    
    private static final String API_URL = "https://apitempo.inmet.gov.br/estacao/ultimas/"; // URL de exemplo da API do INMET

    public DadosMeteorologicos buscarDados(String codigo) {
        // Construa a URL da requisição com o código da estação
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
            .queryParam("codigoEstacao", codigo)  // O parâmetro é o código da estação
            .toUriString();

        // Criação do RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();
        String respostaApi = restTemplate.getForObject(url, String.class);

        // Aqui deve ser feito o parsing do JSON. Considerando um formato simples de resposta:
        DadosMeteorologicos dados = new DadosMeteorologicos();
        
        // Vamos simular que a resposta tem os dados a serem extraídos
        // Aqui, substitua com o JSON real que será tratado conforme a estrutura real da API
        dados.setLocal("Estação " + codigo);
        dados.setTemperatura("24°C");
        dados.setVelocidadeVento("10 km/h");

        return dados;
    }
}