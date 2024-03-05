public class Funcionario {
  public String nome;
  public double salario;

  public Funcionario(String nome) {
    this.nome = nome;
  }

  public Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
  }

  public float aumentar(float valor) {
    return (float) (this.salario += valor);
  }
}