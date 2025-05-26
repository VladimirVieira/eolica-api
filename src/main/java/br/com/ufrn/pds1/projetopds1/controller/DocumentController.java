package br.com.ufrn.pds1.projetopds1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.com.ufrn.pds1.projetopds1.service.DocumentService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        try{
            String path = documentService.saveDocument(file);
            return ResponseEntity.ok("Documento salvo com sucesso! " + path );
        } catch (IllegalArgumentException | IOException e) {
            return ResponseEntity.badRequest().body("Erro ao tentar salvar o arquivo!" + e.getMessage());
        }
    }

    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable String filename) throws MalformedURLException {
        Path path = Paths.get("src/main/resources/static/uploads/" + filename);
        Resource recurso = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(recurso);
    }

}
