public class App {
    public static void main(String[] args) throws Exception {
        Empregado empregado1 = new Empregado("01122245077", "João da Silva", 5000);

        float novoSalario = empregado1.promover(1.5f);
        System.out.printf("O novo salário do funcionário " + empregado1.getNome() + ", é: R$%.2f\n", novoSalario);
    }
}
