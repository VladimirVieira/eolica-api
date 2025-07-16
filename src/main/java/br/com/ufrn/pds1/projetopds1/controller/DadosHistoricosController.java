package br.com.ufrn.pds1.projetopds1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufrn.pds1.projetopds1.model.DadosDiarioHistoricoModel;
import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioAgriculturaService;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioClimaUrbanoService;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioEolicoService;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioService;

@Controller
//@RequestMapping("/historico1")
public class DadosHistoricosController {

    @Autowired
    private DadosDiarioService service;
    
   
    // Consulta e armazena novo histórico
    @GetMapping("/historico1")
    public String obterEArmazenar() {
    	return "historicoprevisao";
    }
     
    @GetMapping("/dadoshistorico")
    public String obterEArmazenar(@RequestParam double lat, @RequestParam double lon, Model hmodel) {
    	DadosDiarioHistoricoModel historico = service.armazenarDados(lat, lon);
    	hmodel.addAttribute("hist", historico);
    	return "historicoprevisao_resposta";
    }

   
}





