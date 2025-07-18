package br.com.cod3r.projetoTeste.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.projetoTeste.models.Cliente;


@RestController
public class ClienteController {
	
	@GetMapping(path = "/clientes/qualquer")
	public Cliente obterCliente() { //ao criar o método consigo importar a classe models
		return new Cliente(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping(path = "/clientes/{id}")//o id é o valor passado na variavel
	public Cliente obterClientePorId(@PathVariable int id) { //ao criar o método consigo importar a classe models
		return new Cliente(id, "Maria", "123.456.789-98");
	}
	
	//como exemplo na url digite http://localhost:8080/clientes?id=15
	@GetMapping(path = "/clientes")
	public Cliente obterClientePorId2(@RequestParam(name ="id") int id){
		return new Cliente(id, "João Augusto","111.222.333-44");
	}
}
