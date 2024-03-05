public class Contador {
  private String frase;

  public Contador(String frase) {
    this.frase = frase;
  }

  public int contarPalavras(){
    String[] palavras = this.frase.split(" ");
    int quantidadePalvras = palavras.length;

    return quantidadePalvras;
  }
}