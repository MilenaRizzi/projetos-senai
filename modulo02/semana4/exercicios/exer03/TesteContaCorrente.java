package exer03;

public class TesteContaCorrente {
  public static void main(String[] args) {
    ContaCorrente contaJoao = new ContaCorrente(12345, 123, "João da Silva", 20000, 3.50);

    contaJoao.sacar(50);
  }
}
