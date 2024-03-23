package br.senai.sc.todolist;

import br.senai.sc.todolist.view.TarefaCLI;

public class Principal {
  public static void main(String[] args) {
    TarefaCLI cli = new TarefaCLI();
    cli.exibirMenu();
    
  }
}
