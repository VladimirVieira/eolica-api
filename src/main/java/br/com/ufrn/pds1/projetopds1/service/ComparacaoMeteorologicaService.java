package br.com.ufrn.pds1.projetopds1.service;

import br.com.ufrn.pds1.projetopds1.model.DadosDiariosHistorico;
import br.com.ufrn.pds1.projetopds1.model.DadosLocalComparativo;
import br.com.ufrn.pds1.projetopds1.model.ComparacaoResultadosView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComparacaoMeteorologicaService {

    private final DadosDiarioService dadosDiarioService;

    @Autowired
    public ComparacaoMeteorologicaService(DadosDiarioService dadosDiarioService) {
        this.dadosDiarioService = dadosDiarioService;
    }

    public ComparacaoResultadosView compararDadosTrimestrais(double lat1, double lon1, double lat2, double lon2) {
        DadosDiariosHistorico historicoLocal1 = dadosDiarioService.armazenarDados(lat1, lon1);
        DadosDiariosHistorico historicoLocal2 = dadosDiarioService.armazenarDados(lat2, lon2);

        DadosLocalComparativo comparativoLocal1 = new DadosLocalComparativo(
                String.format("Local 1 (Lat: %.2f, Lon: %.2f)", lat1, lon1),
                historicoLocal1.getPrimeiroTrimestre(),
                historicoLocal1.getSegundoTrimestre(),
                historicoLocal1.getTerceiroTrimestre(),
                historicoLocal1.getQuartoSemestre() // Nota: no model original está getQuartoSemestre
        );

        DadosLocalComparativo comparativoLocal2 = new DadosLocalComparativo(
                String.format("Local 2 (Lat: %.2f, Lon: %.2f)", lat2, lon2),
                historicoLocal2.getPrimeiroTrimestre(),
                historicoLocal2.getSegundoTrimestre(),
                historicoLocal2.getTerceiroTrimestre(),
                historicoLocal2.getQuartoSemestre() // Nota: no model original está getQuartoSemestre
        );

        return new ComparacaoResultadosView(comparativoLocal1, comparativoLocal2);
    }
}