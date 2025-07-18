package br.com.cod3r.projetoTeste.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {
	
	@GetMapping
	public String get() {
		return "Requisicao Get";
	}
	
	@PostMapping
	public String post() {
		return "Requisicao Post";
	}
	
	@PutMapping
	public String put() {
		return "Requisicao Put";
	}
	
	@PatchMapping
	public String patch() {
		return "Requisicao Patch";
	}
	
	@DeleteMapping
	public String delete() {
		return "Requisicao Delete";
	}
}
