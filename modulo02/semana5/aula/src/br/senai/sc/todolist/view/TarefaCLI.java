package br.senai.sc.todolist.view;

import java.util.List;
import java.util.Scanner;

import br.senai.sc.todolist.model.Tarefa;
import br.senai.sc.todolist.model.TipoMensagem;

public class TarefaCLI {
  
   public void exibirMenu() {
    System.out.println();
    System.out.println(ConsoleColors.BLUE_BOLD + "-------- MENU --------" + ConsoleColors.RESET);
    System.out.println(ConsoleColors.BLUE + "1 - Incluir Tarefa");
    System.out.println("2 - Excluir Tarefa");
    System.out.println("3 - Listar Tarefa");
    System.out.println("4 - Listar Tarefa pelo id");
    System.out.println("5 - Marcar Tarefa como concluída");
    System.out.println("6 - Exportar Tarefa para o arquivo");
    System.out.println("7 - SAIR" + ConsoleColors.RESET);
    System.out.println();

  }

  public Operacao obterOperacao() {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.print("Digite a opção desejada: ");

    int codigoOperacao = scanner.nextInt();
    System.out.println();
    //chama o método values de enum que me retorna um array com todas as opções do enum 
    Operacao[] operacoes = Operacao.values();

    //codigo operacao - 1, pois o array começa em 0 e minha primerai opção de inserir será 1, então para eu acessar a opção correta no array, como inserir é a primeira opção ela estará na posição 0, e assim sucessivamente para todos outras opções 
    Operacao operacao = operacoes[codigoOperacao-1];

    // if (codigoOperacao == 1) {
    //   operacao = Operacao.INCLUIR;
    // } else if (codigoOperacao == 2) {
    //   operacao = Operacao.EXCLUIR;
    // } else if(codigoOperacao == 3) {
    //   operacao = Operacao.LISTAR
    // } else if...
    
    return operacao;
  }


  public void exibirMensagem(String mensagem, TipoMensagem tipo) {
    System.out.println();
    String nomeCor = null;
    switch (tipo) {
      case SUCESSO:
        nomeCor = ConsoleColors.GREEN_BOLD;
        break;
      case AVISO:
        nomeCor = ConsoleColors.YELLOW_BOLD;
        break;
      case ERRO:
        nomeCor = ConsoleColors.RED_BOLD;
        break;
      default:
        break;
    }
    System.out.println(nomeCor + mensagem + ConsoleColors.RESET);
    System.out.println();
  }

  public Tarefa obterDadosTarefa() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe o texto da tarefa: ");
    String texto = scanner.nextLine();
    Tarefa tarefa = new Tarefa(texto);
    return tarefa;
  }

  public void exibirListagem(List<Tarefa> lista) {
    System.out.println();
    System.out.println("Tarefas Cadastradas: ");
    for(Tarefa tarefa : lista) {
      System.out.println(tarefa);
    }
    System.out.println();
  }

  public void exibir(Tarefa tarefa) {
    System.out.println();
    System.out.println(tarefa);
    System.out.println();
  }

  //o que o método faz é basicamente esperar que o usuário aperte o enter
  public void aguardar() {
    System.out.println(ConsoleColors.BLUE_BACKGROUND + "Pressione qualquer tecla para continuar..." + ConsoleColors.RESET);
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    System.out.println();
  }

  public int obterIdTarefa() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe o id da tarefa: ");
    int id = scanner.nextInt();
    return id;
  }


}
