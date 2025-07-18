package com.exemplo.inmetapi.service;

import com.exemplo.inmetapi.model.DadosMeteorologicos;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class InmetService {

    private static final String API_URL = "https://apitempo.inmet.gov.br/estacao/ultimas/";

    public DadosMeteorologicos buscarDados(String codigo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + codigo;

        try {
            String resposta = restTemplate.getForObject(url, String.class);
            JSONArray jsonArray = new JSONArray(resposta);
            JSONObject primeiro = jsonArray.getJSONObject(0);

            DadosMeteorologicos dados = new DadosMeteorologicos();
            dados.setLocal(primeiro.optString("DC_NOME", "Desconhecido"));
            dados.setTemperatura(primeiro.optString("TEM_INS", "N/A") + " °C");
            dados.setVelocidadeVento(primeiro.optString("VEN_VEL", "N/A") + " km/h");

            return dados;
        } catch (Exception e) {
            DadosMeteorologicos dados = new DadosMeteorologicos();
            dados.setLocal("Erro ao consultar estação");
            dados.setTemperatura("Erro");
            dados.setVelocidadeVento("Erro");
            return dados;
        }
    }
}