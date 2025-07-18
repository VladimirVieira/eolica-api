package br.com.ufrn.pds1.projetopds1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufrn.pds1.projetopds1.model.Alertas;
import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.model.PrevisaoTempo;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioService;
import br.com.ufrn.pds1.projetopds1.service.PrevisaoTempoService;

//@RestController
//@RequestMapping("/previsao1")
@Controller
public class PrevisaoTempoController {
	 
	@Autowired
	 private PrevisaoTempoService previsao;
	
	// Consulta e armazena novo histórico
	
	@GetMapping("/previsaosemana")
	public String preverEArmazenar() {
	    return "previsao_semana";
	}
	
	 
	@GetMapping("/emitirprevisao")
    public String armazenarPrevisao(@RequestParam double lat, @RequestParam double lon, Model prevmodel) {
		PrevisaoTempo prevtempo = previsao.armazenarDadosPrevisao(lat, lon);
		prevmodel.addAttribute("prev", prevtempo);
        return "resposta_previsao";
    }
	
	//*************************************************************************************************************
	
	@GetMapping("/previsaoalerta")
	public String preverAlertar() {
		return "previsao_alerta";
	}
    
	 @GetMapping("/alertas")
    public String alertas(@RequestParam double lat, @RequestParam double lon, Model alertmodel) {
        PrevisaoTempo alertPrevisao = previsao.armazenarDadosPrevisao(lat, lon);
        
     // Gera os alertas com base na previsão
        List<Alertas> listaAlertas = previsao.verificarAlertas(alertPrevisao);
        
        alertmodel.addAttribute("listaAlertas", listaAlertas);  
        alertmodel.addAttribute("alert",alertPrevisao);
        
        return "previsao_alertaresposta";
    }  

}

