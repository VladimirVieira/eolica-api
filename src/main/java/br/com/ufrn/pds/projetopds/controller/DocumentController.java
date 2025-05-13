package br.com.ufrn.pds.projetopds.controller;

import br.com.ufrn.pds.projetopds.model.DocumentEntity;
import br.com.ufrn.pds.projetopds.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try{
            String path = documentService.saveDocument(file);
            return ResponseEntity.ok("Documento salvo com sucesso! " + path );
        } catch (IllegalArgumentException | IOException e) {
            return ResponseEntity.badRequest().body("Erro ao tentar salvar o arquivo!" + e.getMessage());
        }
    }
}
