package exer05;

import exer02.ContaPoupanca;
import exer03.ContaCorrente;

public class Principal {
  public static void main(String[] args) {
    Banco aplicacaoBanco = new Banco();
    aplicacaoBanco.adicionarConta(new ContaCorrente(12345, 123, "João da Silva", 20000, 3.50));
    aplicacaoBanco.adicionarConta(new ContaCorrente(00375, 273, "Fernanda", 10000, 3.50));

    aplicacaoBanco.adicionarConta(new ContaPoupanca(54321, 450, "Maria", 5000.0, 2.5));
    aplicacaoBanco.adicionarConta(new ContaPoupanca(66821, 380, "Joaquim", 3000.0, 2.5));


    aplicacaoBanco.removerConta(12345);

    System.out.println();
    
    aplicacaoBanco.mostrarContas();
  }
}
