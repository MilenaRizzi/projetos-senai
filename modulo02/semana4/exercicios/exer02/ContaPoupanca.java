package exer02;

import exer01.ContaBancaria;
import exer04.Imprimivel;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {
  private double taxaDeJuros;

  public ContaPoupanca() {
  }

  public ContaPoupanca(int numeroDaConta, int agencia, String nomeDoTitular, double saldo, double taxaDeJuros) {
    super(numeroDaConta, agencia, nomeDoTitular, saldo);
    this.taxaDeJuros = taxaDeJuros;
  }

  public void adicionarJuros() {
    double juros = getSaldo() * (taxaDeJuros / 100);
    System.out.println("A taxe de juros é de: " + this.taxaDeJuros + "%");
    System.out.println("Juros adicionados: " + juros);
    double novoSaldo = getSaldo() + juros;
    setSaldo(novoSaldo);
    System.out.println("Novo saldo após o juros: " + novoSaldo);

  }

  public double getTaxaDeJuros() {
    return this.taxaDeJuros;
  }

  public void setTaxaDeJuros(double taxaDeJuros) {
    this.taxaDeJuros = taxaDeJuros;
  }

  @Override
  public void mostrarDados() {
    System.out.println("Tipo de conta: Conta Poupança");
    System.out.println("Agência: " + getAgencia());
    System.out.println("Nome do titular: " + getNomeDoTitular());
    System.out.println("Saldo: " + getSaldo());
  }
}
