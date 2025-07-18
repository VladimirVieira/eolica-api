package br.com.ufrn.projetoeolico_ssb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/calculadora")
public class PrimeiroController {
	
//	@RequestMapping(method = RequestMethod.GET)//requisitando algo
//	public String ola() {
//		return "ola isso ai";
//	}

//	@RequestMapping(method = RequestMethod.GET,path="/ola")//requisitando algo
//	public String ola() {
//		return "ola isso ai";
//	}
	
//	@GetMapping(path= {"/ola","/saudacao"})
//	public String ola() {
//		return "ola isso ai1";
//	}
	 @GetMapping("/somar/{a}/{b}")

	 public int somar(@PathVariable int a,@PathVariable int b){

		 return a + b;

	 }
	
	
}
