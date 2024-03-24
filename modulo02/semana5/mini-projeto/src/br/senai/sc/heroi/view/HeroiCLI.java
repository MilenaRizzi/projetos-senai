package br.senai.sc.heroi.view;

import java.util.List;
import java.util.Scanner;

import br.senai.sc.heroi.model.Heroi;
import br.senai.sc.heroi.model.Operacao;
import br.senai.sc.heroi.model.TipoMensagem;

public class HeroiCLI {
  public void exibirMenu() {
    System.out.println();
    System.out.println(ConsoleColors.BLUE_BOLD + "-------- MENU --------");
    System.out.println("1 - Adicionar Herói");
    System.out.println("2 - Listar Herói");
    System.out.println("3 - Sair" + ConsoleColors.RESET);
    System.out.println();
  }

  public Operacao obterOperacao() {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.print("Escolha uma opção: ");

    int codigoOperacao = scanner.nextInt();
    System.out.println();
    Operacao[] operacoes = Operacao.values();
    Operacao operacao = null;
    if ((codigoOperacao - 1) >= 0 && (codigoOperacao - 1) < operacoes.length) {
      operacao = operacoes[codigoOperacao - 1];
    } else {
      exibirMensagem("Código de Operação Inválido!!!", TipoMensagem.ERRO);
      aguardar();
    }

    // if (codigoOperacao == 1) {
    // operacao = Operacao.ADICIONAR;
    // } else if (codigoOperacao == 2) {
    // operacao = Operacao.LISTAR;
    // } else {
    // operacao = Operacao.SAIR;
    // }

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
    Scanner scanner = new Scanner(System.in);
    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite o nome do Héroi: " + ConsoleColors.RESET);
    String nome = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite o super-poder do Héroi: " + ConsoleColors.RESET);
    String superPoder = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite a idade do Héroi: " + ConsoleColors.RESET);
    Integer idade = scanner.nextInt();

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
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    System.out.println();
  }
}
