//package br.com.ufrn.eolico2.controller;
//
//import br.com.ufrn.eolico2.model.DadosClima;
//import br.com.ufrn.eolico2.service.ClimaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ClimaController {
//
//    @Autowired
//    private ClimaService climaService;
//
//    // Método para exibir o formulário de consulta
//    @GetMapping("/")
//    public String form() {
//        return "formulario";  // Nome do template Thymeleaf
//    }
//
//    // Método para consultar os dados do clima e exibir o resultado
//    @GetMapping("/consultar")
//    public String buscarDadosClima(@RequestParam String codigo, @RequestParam String data, Model model) {
//        DadosClima clima = climaService.buscarDadosClima(codigo, data);
//        if (clima != null) {
//            model.addAttribute("clima", clima);
//        } else {
//            model.addAttribute("erro", "Dados não encontrados ou erro na consulta.");
//        }
//        return "resultado";  // Nome do template Thymeleaf para exibir o resultado
//    }
//}

package br.com.ufrn.eolico2.controller;

import br.com.ufrn.eolico2.model.DadosClima;
import br.com.ufrn.eolico2.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClimaController {
	
    @Autowired
    private ClimaService climaService;

    @GetMapping("/")
    public String form() {
        return "formulario";
    }

    @GetMapping("/consultar")
    public String buscarDadosClima(@RequestParam String latitude,
                                   @RequestParam String longitude,
                                   @RequestParam String data,
                                   Model model) {
        DadosClima clima = climaService.buscarDadosClima(latitude, longitude, data);
        
     
        
        if (clima != null) {
            model.addAttribute("clima", clima);
        } else {
            model.addAttribute("erro", "Dados não encontrados ou erro na consulta.");
        }
        return "resultado";
    }
}