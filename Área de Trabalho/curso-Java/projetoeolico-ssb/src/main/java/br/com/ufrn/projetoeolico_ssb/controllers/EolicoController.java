package br.com.ufrn.projetoeolico_ssb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EolicoController {

    @RequestMapping("/teste")
    public String teste() {
        return "Teste realizado";
    }
}