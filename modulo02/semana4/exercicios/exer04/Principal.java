package exer04;

import exer02.ContaPoupanca;
import exer03.ContaCorrente;

public class Principal {
  public static void main(String[] args) {
    ContaPoupanca contaPoupancaMaria = new ContaPoupanca(54321, 450, "Maria", 5000.0, 2.5);

    contaPoupancaMaria.sacar(500);
    contaPoupancaMaria.mostrarDados();

    System.out.println();

    ContaCorrente contaCorrenteJoao = new ContaCorrente(12345, 123, "João da Silva", 20000, 3.50);

    contaCorrenteJoao.depositar(1000);
    contaCorrenteJoao.mostrarDados();
  }
}
