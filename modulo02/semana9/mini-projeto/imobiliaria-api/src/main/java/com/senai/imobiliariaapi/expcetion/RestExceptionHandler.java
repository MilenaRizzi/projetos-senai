package com.senai.imobiliariaapi.expcetion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
  
  @ExceptionHandler(RegistroExistenteException.class)
  public ResponseEntity<Object> handleRegistroExistenteException(RegistroExistenteException e) {
      Map<String, String> retorno = new HashMap<>();
      retorno.put("erro", "Imovél já cadastrado!");        
      return ResponseEntity.status(HttpStatus.CONFLICT).body(retorno);
  }

  @ExceptionHandler(RegistroNaoEncontradoException.class)
  public ResponseEntity<Object> handleRegistroNaoEncontradoException(RegistroNaoEncontradoException e) {
      Map<String, String> retorno = new HashMap<>();
      retorno.put("erro", "Registro não encontrado!");        
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
  }
}
