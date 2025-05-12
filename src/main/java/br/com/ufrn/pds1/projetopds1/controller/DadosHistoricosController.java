package br.com.ufrn.pds1.projetopds1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioService;

@RestController
@RequestMapping("/historico1")
public class DadosHistoricosController {

    @Autowired
    private DadosDiarioService service;

    // Consulta e armazena novo histórico
    @GetMapping
    public DadosDiariosHistorico obterEArmazenar(@RequestParam double lat, @RequestParam double lon) {
        return service.armazenarDados(lat, lon, null, null);
    }

   
}
