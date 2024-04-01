package br.senai.sc.heroi;

import java.util.InputMismatchException;
import java.util.List;

import br.senai.sc.heroi.exception.OperacaoInvalidaException;
import br.senai.sc.heroi.model.Heroi;
import br.senai.sc.heroi.model.Operacao;
import br.senai.sc.heroi.model.TipoMensagem;
import br.senai.sc.heroi.repository.HeroiRepository;
import br.senai.sc.heroi.view.HeroiCLI;

public class DevHeroiAplicacao {
  private HeroiCLI cli = new HeroiCLI();
  private HeroiRepository repo = new HeroiRepository();

  public void executar() {
    Operacao operacao = null;

    do {
      cli.exibirMenu();
      operacao = obterOperacao();
      processar(operacao);
    } while (operacao != Operacao.SAIR);

    cli.exibirMensagem("Sistema Encerrado", TipoMensagem.AVISO);
    cli.fecharScanner();
  }

  public Operacao obterOperacao() {
    String opcao = cli.obterCodigoOperacao();
    try {
      Operacao operacao = Operacao.converter(opcao);
      return operacao;
    } catch (OperacaoInvalidaException e) {
      return null;
    }
  }

  private void processar(Operacao operacao) {
    if (operacao == Operacao.SAIR)
      return;

    try {
      if (operacao == null) {
        cli.exibirMensagem("Código de operação inválido", TipoMensagem.ERRO);
        cli.aguardar();
      } else if (operacao == Operacao.ADICIONAR) {
        adicionar();
      } else if (operacao == Operacao.LISTAR) {
        listar();
      }
    } catch (InputMismatchException e) {
      cli.exibirMensagem("A idade precisa ser um número", TipoMensagem.ERRO);
      cli.aguardar();
    }
  }

  private void adicionar() {
    Heroi heroi = cli.obterDadosHeroi();
    if (repo.existePorNome(heroi.getNome())) {
      cli.exibirMensagem("Herói já cadastrado!", TipoMensagem.ERRO);
      cli.aguardar();
      return;
    }

    repo.adicionar(heroi);
    cli.exibirMensagem("Herói adicionado com sucesso!", TipoMensagem.SUCESSO);
    cli.aguardar();
  }

  private void listar() {
    List<Heroi> lista = repo.consultar();

    if (lista.size() > 0) {
      cli.exibirListagem(lista);
      cli.aguardar();

    } else {
      cli.exibirMensagem("Lista vazia. Não há heróis cadastrados!", TipoMensagem.ERRO);
      cli.aguardar();
    }
  }
}
