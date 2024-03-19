package exer05;

import java.util.ArrayList;

import exer01.ContaBancaria;
import exer04.Imprimivel;

public class Banco {
  private ArrayList<ContaBancaria> contas;  


  public Banco() {
    contas = new ArrayList<>();
}

  public void adicionarConta(ContaBancaria conta) {
    this.contas.add(conta);
    System.out.println("Conta de " + conta.getNomeDoTitular() + " adicionada com sucesso!");
  }

  public void removerConta(int numeroDaConta) {
    for (ContaBancaria conta : contas) {
      if (conta.getNumeroDaConta() == numeroDaConta) {
        contas.remove(conta);
        System.out.println("Conta de " + conta.getNomeDoTitular() + " removida com sucesso!");
        return;
      } 
    }
    System.out.println("Conta não encontrada");
  }


  public ArrayList<ContaBancaria> getContas() {
    return this.contas;
  }

  public void setContas(ArrayList<ContaBancaria> contas) {
    this.contas = contas;
  }


  public void mostrarContas() {
    System.out.println("----- Lista de Contas no Banco -----");
    for (ContaBancaria conta : contas) {
        if (conta instanceof Imprimivel) {
            Imprimivel imprimivel = (Imprimivel) conta;
            imprimivel.mostrarDados();
            System.out.println("------------------------------------");
        } else {
            System.out.println("Erro: A conta não implementa a interface Imprimivel.");
        }
    }
  }

}
