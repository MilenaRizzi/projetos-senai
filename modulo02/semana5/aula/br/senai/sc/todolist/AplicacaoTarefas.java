import view.TarefaCLI;

public class AplicacaoTarefas {
  
  private TarefaCLI cli = new TarefaCLI();

  public void executar() {

    Integer op = 0;

    while (op != 7)  {
      cli.exibirMenu();
      op = cli.obterOperacao();
    }
  }
}
