public class TesteContador {
    public static void main(String[] args) throws Exception {
      Contador cont = new Contador("Quantidade de palavras que há nesta frase");
      System.out.println("A quantidade de palavras da frase é: " + cont.contarPalavras());
    }
}
