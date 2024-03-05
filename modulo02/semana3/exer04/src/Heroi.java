public class Heroi {
  private String nome;
  private String superPoder;
  private String nomeDaVidaReal;
  private String universo;


  public Heroi(String nome, String superPoder, String nomeDaVidaReal, String universo) {
    this.nome = nome;
    this.superPoder = superPoder;
    this.nomeDaVidaReal = nomeDaVidaReal;
    this.universo = universo;
  }

  public void atacar() {
    System.out.println(this.nome + " está atacando!");
  }
}