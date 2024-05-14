package com.senai.imobiliaria.exception;

public class RegistroExistenteException extends RuntimeException{
  public RegistroExistenteException(String mensagem) {
    super(mensagem);
}
}
