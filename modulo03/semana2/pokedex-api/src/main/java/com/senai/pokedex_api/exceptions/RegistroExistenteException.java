package com.senai.pokedex_api.exceptions;

public class RegistroExistenteException extends RuntimeException{
  public RegistroExistenteException(String mensagem) {
    super(mensagem);
}
}
