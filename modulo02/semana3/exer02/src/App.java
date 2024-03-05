public class App {
    public static void main(String[] args) throws Exception {
        Funcionario funcionario1 = new Funcionario("Maria Joana", 3000);

        float salarioAumentado = funcionario1.aumentar(1780f);
        System.out.printf("O salário aumentado é: R$%.2f\n", salarioAumentado);

    }
}
