package br.com.ufrn.pds1.projetopds1.controller;

import br.com.ufrn.pds1.projetopds1.model.ComparacaoResultadosView;
import br.com.ufrn.pds1.projetopds1.service.ComparacaoMeteorologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comparacao-meteorologica")
public class ComparacaoMeteorologicaController {

    private final ComparacaoMeteorologicaService comparacaoService;

    @Autowired
    public ComparacaoMeteorologicaController(ComparacaoMeteorologicaService comparacaoService) {
        this.comparacaoService = comparacaoService;
    }

    @GetMapping("/form")
    public String mostrarFormularioComparacao() {
        return "comparacao_trimestral_form"; // Novo HTML para o formulário
    }

    @GetMapping("/resultados")
    public String obterResultadosComparacao(
            @RequestParam double lat1, @RequestParam double lon1,
            @RequestParam double lat2, @RequestParam double lon2,
            Model model) {

        ComparacaoResultadosView resultados = comparacaoService.compararDadosTrimestrais(lat1, lon1, lat2, lon2);
        model.addAttribute("resultadosComparacao", resultados);
        return "comparacao_trimestral_resposta"; // Novo HTML para exibir os resultados
    }
}