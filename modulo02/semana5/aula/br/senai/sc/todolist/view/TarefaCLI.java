package view;

import java.util.Scanner;

public class TarefaCLI {

  public void exibirMenu() {
    System.out.println("1 - Incluir Tarefa");
    System.out.println("2 - Excluir Tarefa");
    System.out.println("3 - Listar Tarefa");
    System.out.println("4 - Listar Tarefa pelo id");
    System.out.println("5 - Marcar Tarefa como concluída");
    System.out.println("6 - Exportar Tarefa para o arquivo");
    System.out.println("7 - SAIR");
  }

  public Integer obterOperacao() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informa a opção desejada: ");
    int codigoOperacao = scanner.nextInt();
    return codigoOperacao;
  }

}
