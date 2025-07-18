package br.com.cod3r.projetoTeste.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //marca a classe como um controller
public class PrmeiroController {
	
	@RequestMapping //Diz que quer mapear uma requisição para esse método
	//é o mesmo que @RequestMapping(method = RequestMethod.GET)
	public String ola() {
		return "olá Spring Boot";
	}
	
	
	//quando digitar no browser http://localhost:8080/ola retornar o que tem no método
	@RequestMapping(method = RequestMethod.GET,path="/ola")
	public String ola1() {
		return "olá Spring Boot2";
	}
	
	//mais comum 
	//pode usar sem path
	@GetMapping(path="/ola3")
	public String ola3() {
		return "Olá Spring Boot3";
	}

}
