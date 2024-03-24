package br.senai.sc.todolist;

import java.util.List;

import br.senai.sc.todolist.model.Tarefa;
import br.senai.sc.todolist.model.TipoMensagem;
import br.senai.sc.todolist.repository.TarefaRepository;
import br.senai.sc.todolist.view.Operacao;
import br.senai.sc.todolist.view.TarefaCLI;

public class AplicacaoTarefa {
  private TarefaCLI cli = new TarefaCLI();
  private TarefaRepository repo = new TarefaRepository();

  public void executar() {
  Operacao operacao = null;

   do {
      cli.exibirMenu();
      operacao = cli.obterOperacao();
      processar(operacao);
    }  while(operacao != Operacao.SAIR);
    
    cli.exibirMensagem("Sistema Encerrado", TipoMensagem.AVISO);
  }

  private void processar(Operacao operacao) {
    if (operacao == Operacao.SAIR) 
      return;
    
    if (operacao == Operacao.INCLUIR) {
      Tarefa tarefa = cli.obterDadosTarefa();
      repo.gravar(tarefa);

      cli.exibirMensagem("Tarefa incluída com sucesso",TipoMensagem.SUCESSO);
      cli.aguardar(); 
      
    } else if (operacao == Operacao.LISTAR) {
      List<Tarefa> lista = repo.consultar();
      cli.exibirListagem(lista);

      cli.aguardar(); 

    } else if (operacao == Operacao.EXCLUIR) {
      int id = cli.obterIdTarefa();
      repo.excluir(id);
      //aqui eu poderia incluir uma mensagem de confirmação antes de apagar . cli.exibirMensagemDeConfirmacao
      cli.exibirMensagem("Tarefa excluida com sucesso",TipoMensagem.SUCESSO);
      cli.aguardar(); 
    }

    }
}
