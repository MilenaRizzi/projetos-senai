package br.senai.sc.todolist;

import java.util.List;

import br.senai.sc.todolist.exception.TarefaException;
import br.senai.sc.todolist.model.Tarefa;
import br.senai.sc.todolist.model.TipoMensagem;
import br.senai.sc.todolist.repository.TarefaRepository;
import br.senai.sc.todolist.util.GeradorArquivo;
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
    } while (operacao != Operacao.SAIR);

    cli.exibirMensagem("Sistema Encerrado", TipoMensagem.AVISO);
  }

  private void processar(Operacao operacao) {
    try {
      if (operacao == Operacao.SAIR)
        return;

      if (operacao == Operacao.INCLUIR) {
        Tarefa tarefa = cli.obterDadosTarefa();
        repo.gravar(tarefa);

        cli.exibirMensagem("Tarefa incluída com sucesso", TipoMensagem.SUCESSO);
        cli.aguardar();

      } else if (operacao == Operacao.LISTAR) {
        List<Tarefa> lista = repo.consultar();
        cli.exibirListagem(lista);

        cli.aguardar();

      } else if (operacao == Operacao.EXCLUIR) {
        int id = cli.obterIdTarefa();
        repo.excluir(id);
        // aqui eu poderia incluir uma mensagem de confirmação antes de apagar .
        // cli.exibirMensagemDeConfirmacao
        cli.exibirMensagem("Tarefa excluida com sucesso", TipoMensagem.SUCESSO);
        cli.aguardar();
      } else if (operacao == Operacao.LISTAR_POR_ID) {
        int id = cli.obterIdTarefa();
        Tarefa tarefa = repo.consultarPorId(id);
        cli.exibir(tarefa);
        cli.aguardar();
      } else if (operacao == Operacao.MARCAR_CONCLUIDA) {
        int id = cli.obterIdTarefa();
        repo.marcarComoConcluida(id);
        cli.exibirMensagem("Tarefa excluida com sucesso", TipoMensagem.SUCESSO);
        cli.aguardar();
      } else if (operacao == Operacao.EXPORTAR) {
        List<Tarefa> tarefas = repo.consultar();
        GeradorArquivo.gerar("tarefas.txt", tarefas);
        cli.exibirMensagem("Arquivo gerado com sucesso", TipoMensagem.SUCESSO);
        cli.aguardar();
      }
    } catch (TarefaException e) {
      cli.exibirMensagem(e.getMessage(), TipoMensagem.ERRO);
    } catch (Exception e) {
      String mensagemErro = e.getMessage();
      if (mensagemErro == null) {
        mensagemErro = "contate o administrador do sistema";
      }
      cli.exibirMensagem("Erro na aplicação: " + mensagemErro, TipoMensagem.ERRO);
    }

  }
}
