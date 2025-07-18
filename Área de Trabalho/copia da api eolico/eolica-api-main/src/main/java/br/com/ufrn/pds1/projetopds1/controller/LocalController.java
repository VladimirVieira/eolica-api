package br.com.ufrn.pds1.projetopds1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.model.DadosLocal;
import br.com.ufrn.pds1.projetopds1.service.DadosDiarioService;
import br.com.ufrn.pds1.projetopds1.service.DadosLocalService;


@Controller
public class LocalController {
	 @Autowired
	 private DadosLocalService dadoslocal;

	
	@GetMapping("/")
	public String enviarFormulario() {
		return "dadosmomentaneo";
	}
	
	@GetMapping("/verificar")
	public String verificarDados(@RequestParam String latitude,
			@RequestParam String longitude,
			@RequestParam String data,
            Model vmodel) {
		
		DadosLocal clima = dadoslocal.pesquisarDados(latitude, longitude, data);
		vmodel.addAttribute("clima", clima);
		return "dadosmomentaneo_resposta";	
	}

}
