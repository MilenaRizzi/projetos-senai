package br.senai.sc.heroi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
      operacao = cli.obterOperacao();
      processar(operacao);
    } while (operacao != Operacao.SAIR);

    cli.exibirMensagem("Sistema Encerrado", TipoMensagem.AVISO);
    cli.fecharScanner();
  }

  private void processar(Operacao operacao) {
    if (operacao == Operacao.SAIR)
      return;

    try {
      List<Heroi> lista = new ArrayList<>();
      if (operacao == Operacao.ADICIONAR) {
        Heroi heroi = cli.obterDadosHeroi();
        lista = repo.consultar();

        if (lista.size() != 0) {
          for (Heroi her : lista) {
            if (her.getNome().equalsIgnoreCase(heroi.getNome())) {
              cli.exibirMensagem("Herói já cadastrado!", TipoMensagem.ERRO);
              cli.aguardar();
              return;
            }
          }
        }

        repo.adicionar(heroi);
        cli.exibirMensagem("Herói adicionado com sucesso!", TipoMensagem.SUCESSO);
        cli.aguardar();

      } else if (operacao == Operacao.LISTAR) {
        lista = repo.consultar();

        if (lista.size() > 0) {
          cli.exibirListagem(lista);
          cli.aguardar();

        } else {
          cli.exibirMensagem("Lista vazia. Não há heróis cadastrados!", TipoMensagem.ERRO);
          cli.aguardar();
        }
      }
    } catch (InputMismatchException e) {
      cli.exibirMensagem("A idade precisa ser um número", TipoMensagem.ERRO);
      cli.aguardar();
    } catch (Exception e) {
      cli.exibirMensagem("Erro no sistema", TipoMensagem.ERRO);
    }


  }
}
