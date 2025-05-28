package br.com.ufrn.pds1.projetopds1.controller;

import br.com.ufrn.pds1.projetopds1.DTO.AvaliationDTO;
import br.com.ufrn.pds1.projetopds1.model.AvaliationEntity;
import br.com.ufrn.pds1.projetopds1.service.AvaliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("avaliation")
public class AvaliationController {
    @Autowired
    private AvaliationService avaliationService;

    //Metodo de getAll do Avaliation
    @GetMapping("getAll")
    public ResponseEntity<List<AvaliationEntity>> getAll(){
        List<AvaliationEntity> avaliationEntityList = avaliationService.getAllAvaliation();
        return ResponseEntity.ok().body(avaliationEntityList);
    }

    //LANCA EXCECAO DE AVLIATION N ENCONTRADA
    //Metodo de getById do Avaliation
    @GetMapping("getById/{id}")
    public ResponseEntity<AvaliationEntity> getById(@PathVariable long id){
        AvaliationEntity avaliation = avaliationService.getAvaliationById(id);
        return ResponseEntity.ok().body(avaliation);

    }

    //PODE SER LANCADA EXC3ECOE DE PECA NAO ENCONTRADA
    //Metodo de post do Avaliation
    @PostMapping("postAvaliation")
    public ResponseEntity<AvaliationEntity> postAvaliation(@RequestBody AvaliationDTO avaliationDTO){
        AvaliationEntity avaliation = avaliationService.postAvaliation(avaliationDTO);
        return ResponseEntity.ok().body(avaliation);
    }

    //LANCA EXCECAO DE AVLIATION N ENCONTRADA
    //Metodo do put do Avaliation
    @PutMapping("putAvaliation/{id}")
    public ResponseEntity<AvaliationEntity> putAvaliation(@PathVariable long id, @RequestBody AvaliationDTO avaliationATT){
        AvaliationEntity avaliation = avaliationService.putAvaliation(id, avaliationATT);
        return ResponseEntity.ok().body(avaliation);
    }

    //LANCA EXCECAO DE AVLIATION N ENCONTRADA
    //Metodo de delete do Avaliation
    @DeleteMapping("deleteAvaliation/{id}")
    public ResponseEntity<AvaliationEntity> deleteAvaliation(@PathVariable long id){
        AvaliationEntity avaliation = avaliationService.deleteAvaliation(id);
        return ResponseEntity.ok().body(avaliation);
    }
}
