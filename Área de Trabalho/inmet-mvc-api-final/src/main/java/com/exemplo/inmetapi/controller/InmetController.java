package com.exemplo.inmetapi.controller;

import com.exemplo.inmetapi.model.DadosMeteorologicos;
import com.exemplo.inmetapi.service.InmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InmetController {

    @Autowired
    private InmetService inmetService;

    @GetMapping("/")
    public String formulario() {
        return "formulario";
    }

    @PostMapping("/consultar")
    public String consultar(@RequestParam("codigo") String codigo, Model model) {
        DadosMeteorologicos dados = inmetService.buscarDados(codigo);
        model.addAttribute("dados", dados);
        return "resultado";
    }
}