package br.senai.sc.heroi.view;

import java.util.List;
import java.util.Scanner;

import br.senai.sc.heroi.model.Heroi;
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

  public String obterCodigoOperacao() {
    System.out.println();
    System.out.print("Escolha uma opção: ");
    String opcao = scanner.next(); // string
    System.out.println();
    return opcao;
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
    scanner.nextLine(); 

    String nome = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite o super-poder do Héroi: " + ConsoleColors.RESET);
    String superPoder = scanner.nextLine();

    System.out.print(ConsoleColors.PURPLE_BOLD + "Digite a idade do Héroi: " + ConsoleColors.RESET);
    Integer idade = scanner.nextInt();


    Heroi heroi = new Heroi(nome, superPoder, idade);
    return heroi;
  }

  public void exibirListagem(List<Heroi> lista) {
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
    scanner = new Scanner(System.in);
    scanner.nextLine();
    System.out.println();
  }

  public void fecharScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
