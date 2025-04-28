package br.com.ufrn.pds1.projetopds1.controller;

import br.com.ufrn.pds1.projetopds1.DTO.PartDTO;
import br.com.ufrn.pds1.projetopds1.model.PartEntity;
import br.com.ufrn.pds1.projetopds1.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parts")
public class PartController {
    @Autowired
    PartService partService;

    //Metodo POST
    @PostMapping("postPart")
    public ResponseEntity<PartEntity> postPart(@RequestBody PartDTO partDTO) {
        PartEntity partEntity = partService.postPart(partDTO);
        return ResponseEntity.ok().body(partEntity);
    }

    //Metodo Put
    @PutMapping("putPart/{id}")
    public PartEntity putPart(@PathVariable long id, @RequestBody PartDTO partUpdated) {
        return partService.putPart(id, partUpdated);
    }

    //Metodo Delete
    @DeleteMapping("deletePart/{id}")
    public ResponseEntity<PartEntity> deletePart(@PathVariable long id) {
        PartEntity partEntity = partService.deletePart(id);
        return ResponseEntity.ok().body(partEntity);
    }

    //Metodo getAll
    @GetMapping("getAll")
    public ResponseEntity<List<PartEntity>> getAll() {
        List<PartEntity> part = partService.getAllParts();
        return ResponseEntity.ok().body(part);
    }

    //Metodo getById
    @GetMapping("getById/{id}")
    public ResponseEntity<PartEntity> getById(@PathVariable long id) {
        PartEntity part = partService.getPartById(id);
        return ResponseEntity.ok().body(part);
    }
}
