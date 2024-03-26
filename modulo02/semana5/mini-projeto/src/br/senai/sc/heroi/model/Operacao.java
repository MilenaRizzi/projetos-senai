package br.senai.sc.heroi.model;

import br.senai.sc.heroi.exception.OperacaoInvalidaException;

public enum Operacao {
  ADICIONAR,
  LISTAR,
  SAIR;

  public static Operacao converter(String opcao){
    try {
      if (opcao == null) 
        throw new OperacaoInvalidaException();
      Integer codigo = Integer.valueOf(opcao);
      if (codigo > Operacao.values().length) 
        throw new OperacaoInvalidaException();
      Operacao operacao = Operacao.values()[codigo - 1];
      return operacao;
    } catch(NumberFormatException e) {
      throw new OperacaoInvalidaException();
    }
  }
}
