public class ContaBancaria {
  private int numeroDaConta;
  private int agencia;
  private String nomeDoTitular;
  private double saldo;

  public ContaBancaria() {
  }

  public ContaBancaria(int numeroDaConta, int agencia, String nomeDoTitular, double saldo) {
    this.numeroDaConta = numeroDaConta;
    this.agencia = agencia;
    this.nomeDoTitular = nomeDoTitular;
    this.saldo = saldo;
  }

  public void depositar(double valor) {
    if (valor >= 2) {
      this.saldo += valor;
      System.out.println("Valor de: " + valor + " depositado com sucesso. Novo saldo é: " + this.saldo);
    } else {
      System.out.println("Deposite um valor maior que ou igual a R$2,00");
    }
  }

  public void sacar(double valor) {
    if (this.saldo >= valor && valor >= 2) {
      this.saldo -= valor;
      System.out.println("Valor de: " + valor + " sacado com sucesso. Novo saldo é: " + this.saldo);
    } else if (this.saldo >= valor && valor < 2) {
      System.out.println("Saque inválido. Saque disponível a partir de R$2,00!");
    } else {
      System.out.println("Saque inválido. Saldo indisponível disponível a partir de R$2,00!");
    }

  }

  public int getNumeroDaConta() {
    return this.numeroDaConta;
  }

  public void setNumeroDaConta(int numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public int getAgencia() {
    return this.agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  }

  public String getNomeDoTitular() {
    return this.nomeDoTitular;
  }

  public void setNomeDoTitular(String nomeDoTitular) {
    this.nomeDoTitular = nomeDoTitular;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

}
