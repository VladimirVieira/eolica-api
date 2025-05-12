package br.com.ufrn.pds1.projetopds1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufrn.pds1.projetopds1.model.Alertas;
import br.com.ufrn.pds1.projetopds1.model.PrevisaoTempo;
import br.com.ufrn.pds1.projetopds1.service.PrevisaoTempoService;

@RestController
@RequestMapping("/previsao1")
public class PrevisaoTempoController {
	 
	@Autowired
	 private PrevisaoTempoService service;
	
	// Consulta e armazena novo histórico
	@GetMapping("/armazenar")
    public PrevisaoTempo armazenarPrevisao(@RequestParam double lat, @RequestParam double lon) {
        return service.armazenarDadosPrevisao(lat, lon);
    }
    
	 @GetMapping("/alertas")
    public List<Alertas> alertas(@RequestParam double lat, @RequestParam double lon) {
        PrevisaoTempo verificaPrevisao = service.armazenarDadosPrevisao(lat, lon);
        return service.verificarAlertas(verificaPrevisao);
    }  

}
