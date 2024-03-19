package exer03;

import exer01.ContaBancaria;
import exer04.Imprimivel;

public class ContaCorrente extends ContaBancaria implements Imprimivel {
  private double taxaDeOperacao;

  public ContaCorrente() {

  }

  public ContaCorrente(int numeroDaConta, int agencia, String nomeDoTitular, double saldo, double taxaDeOperacao) {
    super(numeroDaConta, agencia, nomeDoTitular, saldo);
    this.taxaDeOperacao = taxaDeOperacao;
  }

  public double getTaxaDeOperacao() {
    return this.taxaDeOperacao;
  }

  @Override
  public void sacar(double valor) {
    double valorComTaxa = valor + taxaDeOperacao;

    if (getSaldo() >= valorComTaxa && valorComTaxa >= 2) {
      setSaldo(getSaldo() - valorComTaxa);
      System.out.println("Valor de: " + valor + " sacado com sucesso. Novo saldo é: " + getSaldo());
      System.out.println("Taxa de operação debitada da conta: " + taxaDeOperacao);
    } else if (getSaldo() >= valorComTaxa && valorComTaxa < 2) {
      System.out.println("Saque inválido. Saque disponível a partir de R$2,00!");
    } else {
      System.out.println("Saque inválido. Saldo indisponível!");
    }

  }

  public void setTaxaDeOperacao(double taxaDeOperacao) {
    this.taxaDeOperacao = taxaDeOperacao;
  }

  @Override
  public void mostrarDados() {
    System.out.println("Tipo de conta: Conta Corrente");
    System.out.println("Número da conta: " + getNumeroDaConta());
    System.out.println("Agência: " + getAgencia());
    System.out.println("Nome do titular: " + getNomeDoTitular());
    System.out.println("Saldo: " + getSaldo());
  }

}
