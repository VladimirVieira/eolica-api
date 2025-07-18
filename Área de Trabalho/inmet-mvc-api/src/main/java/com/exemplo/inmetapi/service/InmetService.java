package com.exemplo.inmetapi.service;

import com.exemplo.inmetapi.model.DadosMeteorologicos;
import org.springframework.stereotype.Service;

@Service
public class InmetService {
    public DadosMeteorologicos buscarDados(String codigo) {
        DadosMeteorologicos dados = new DadosMeteorologicos();
        dados.setLocal("Cidade Exemplo - " + codigo);
        dados.setTemperatura("28°C");
        dados.setVelocidadeVento("12 km/h");
        return dados;
    }
}