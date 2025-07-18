package br.com.ufrn.projetoeolico_ssb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufrn.projetoeolico_ssb.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@GetMapping("/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28,"Pedro","123");
	}
	
	@GetMapping("/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		return a+b;
	}

}
