public class Empregado {
  private String cpf;
  private String nome;
  private double salario;


  public Empregado(String cpf, String nome, double salario) {
    this.cpf = cpf;
    this.nome = nome;
    this.salario = salario;
  }

  public float promover(float percentual) {
      float novoSalario = (float) (this.salario + (percentual * this.salario));
      return novoSalario;
  }

}