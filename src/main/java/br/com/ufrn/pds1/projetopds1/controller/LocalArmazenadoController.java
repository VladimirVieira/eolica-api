package br.com.ufrn.pds1.projetopds1.controller;

import br.com.ufrn.pds1.projetopds1.DTO.LocalArmazenadoDTO;
import br.com.ufrn.pds1.projetopds1.model.LocalArmazenado;
import br.com.ufrn.pds1.projetopds1.service.LocalArmazenadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locais") // Define um path base para este CRUD
public class LocalArmazenadoController {

    @Autowired
    private LocalArmazenadoService localArmazenadoService;

    @PostMapping
    public ResponseEntity<LocalArmazenado> createLocal(@RequestBody LocalArmazenadoDTO localDTO) {
        LocalArmazenado novoLocal = localArmazenadoService.createLocal(localDTO);
        return new ResponseEntity<>(novoLocal, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalArmazenado> getLocalById(@PathVariable Long id) {
        Optional<LocalArmazenado> local = localArmazenadoService.getLocalById(id);
        return local.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LocalArmazenado>> getAllLocais() {
        List<LocalArmazenado> locais = localArmazenadoService.getAllLocais();
        return ResponseEntity.ok(locais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalArmazenado> updateLocal(@PathVariable Long id, @RequestBody LocalArmazenadoDTO localDTO) {
        Optional<LocalArmazenado> localAtualizado = localArmazenadoService.updateLocal(id, localDTO);
        return localAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        if (localArmazenadoService.deleteLocal(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}