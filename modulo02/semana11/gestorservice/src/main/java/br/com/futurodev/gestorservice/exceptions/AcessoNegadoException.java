package br.com.futurodev.gestorservice.exceptions;

public class AcessoNegadoException extends RuntimeException {
    public AcessoNegadoException(String msg) {
        super(msg);
    }
}
