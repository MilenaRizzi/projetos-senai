package br.com.futurodev.gestorservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.futurodev.gestorservice.exceptions.AcessoNegadoException;
import br.com.futurodev.gestorservice.exceptions.ConflitoException;
import br.com.futurodev.gestorservice.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ControleErro {
    
    @ExceptionHandler(value = {ConflitoException.class})
    ResponseEntity<Object> conflitoException(ConflitoException exp) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exp.getMessage());
    }

    @ExceptionHandler(value = {AcessoNegadoException.class})
    ResponseEntity<Object> acessoNegadoException(AcessoNegadoException exp) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exp.getMessage());
    }

    @ExceptionHandler(value = {NaoEncontradoException.class})
    ResponseEntity<Object> naoEncontradoException(NaoEncontradoException exp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
    }

}
