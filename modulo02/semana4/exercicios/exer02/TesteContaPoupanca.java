package exer02;

public class TesteContaPoupanca {
  public static void main(String[] args) {
    ContaPoupanca contaPoupancaMaria = new ContaPoupanca(54321, 450, "Maria", 5000.0, 2.5);
    System.out.println("Saldo inicial: " + contaPoupancaMaria.getSaldo());
    contaPoupancaMaria.adicionarJuros();
    System.out.println("Novo saldo após juros: " + contaPoupancaMaria.getSaldo());
  }
}
