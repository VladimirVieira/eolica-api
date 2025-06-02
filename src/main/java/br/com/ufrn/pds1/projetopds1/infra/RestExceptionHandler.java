package br.com.ufrn.pds1.projetopds1.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoSuchElementException.class})
    private ResponseEntity<String> elementNotFoundHandler(NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error trying save document: " + ex.getMessage());
    }

    @ExceptionHandler({FileNotFoundException.class})
    private ResponseEntity<String> fileNotFoundHandler(FileNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
    }

    @ExceptionHandler({IllegalArgumentException.class})
    private ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}
