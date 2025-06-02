package br.com.ufrn.pds1.projetopds1.service;

import br.com.ufrn.pds1.projetopds1.model.DocumentEntity;
import br.com.ufrn.pds1.projetopds1.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    //Metodo de upload do arquivo
    public String saveDocument(MultipartFile file)  throws IOException{

        if(file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")){
            throw new IllegalArgumentException("file is not PDF");
        }

        //Capturando nome do arquivo e caminho de destino
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/uploads/" + filename);

        //Transferindo documento para a pasta uploads
        Files.createDirectories(path.getParent());
        file.transferTo(path);

        String destination = "uploads/" + filename;

        //Salvando "documento" no banco de dados
        DocumentEntity document = new DocumentEntity();
        document.setName(file.getOriginalFilename());
        document.setPath(destination);
        documentRepository.save(document);


        return destination;
    }
}
