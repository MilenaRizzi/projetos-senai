package br.senai.sc.heroi.view;

import java.util.List;
import java.util.Scanner;

import br.senai.sc.heroi.model.Heroi;
import br.senai.sc.heroi.model.Operacao;
import br.senai.sc.heroi.model.TipoMensagem;

public class HeroiCLI {

  private Scanner scanner;

  public HeroiCLI() {
      this.scanner = new Scanner(System.in);
  }

  public void exibirMenu() {
    System.out.println();
    System.out.println(ConsoleColors.BLUE_BOLD + "-------- MENU --------");
    System.out.println("1 - Adicionar Herói");
    System.out.println("2 - Listar Herói");
    System.out.println("3 - Sair" + ConsoleColors.RESET);
    System.out.println();
  }

  public Operacao obterOperacao() {
    System.out.println();
    System.out.print("Escolha uma opção: ");

    Operacao operacao = null;
    try {
      int codigoOperacao = scanner.nextInt();
      scanner.nextLine();
      System.out.println();
      Operacao[] operacoes = Operacao.values();
      operacao = operacoes[codigoOperacao - 1];
    } catch (ArrayIndexOutOfBoundsException e) {
      exibirMensagem("Código de operação inválido!!!", TipoMensagem.ERRO);
      System.out.println();
      aguardar();
    } catch (Exception e) {
      exibirMensagem("Erro no sistema", TipoMensagem.ERRO);
      aguardar();
    }

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

  public Heroi obterDadosHeroi() {
    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite o nome do Héroi: " + ConsoleColors.RESET);
    String nome = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite o super-poder do Héroi: " + ConsoleColors.RESET);
    String superPoder = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite a idade do Héroi: " + ConsoleColors.RESET);
    Integer idade = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha pendente

    Heroi heroi = new Heroi(nome, superPoder, idade);
    return heroi;
  }

  public void exibirListagem(List<Heroi> lista) {
    System.out.println();
    exibirMensagem("Listagem de Heróis: ", TipoMensagem.AVISO);
    for (Heroi heroi : lista) {
      System.out.println(heroi);
    }
    System.out.println();
  }

  public void aguardar() {
    System.out.println(ConsoleColors.BLUE_BACKGROUND +
        "Pressione qualquer tecla para continuar..."
        + ConsoleColors.RESET);
    scanner.nextLine();
    System.out.println();
  }

  public void fecharScanner() {
    if (scanner != null) {
        scanner.close();
    }
}
}
