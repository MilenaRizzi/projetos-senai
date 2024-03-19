package exer02;

public class TesteContaPoupanca {
  public static void main(String[] args) {
    ContaPoupanca minhaContaPoupanca = new ContaPoupanca(54321, 450, "Maria", 5000.0, 2.5);
    System.out.println("Saldo inicial: " + minhaContaPoupanca.getSaldo());
    minhaContaPoupanca.adicionarJuros();
    System.out.println("Novo saldo após juros: " + minhaContaPoupanca.getSaldo());
  }
}
