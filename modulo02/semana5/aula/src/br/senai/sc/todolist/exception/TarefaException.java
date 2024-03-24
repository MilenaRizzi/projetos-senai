package br.senai.sc.todolist.exception;

public class TarefaException extends Exception {
  public TarefaException(){
  }

  public TarefaException(String mensagem) {
    super(mensagem);
  }
}
