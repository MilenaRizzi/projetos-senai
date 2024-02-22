import java.util.Scanner;

public class App {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

            System.out.println("CALCULARADORA ONLINE");

           System.out.println("Digite o primeiro número:");
           double num1 = scanner.nextDouble();


           System.out.println("Digite o segundo número:");
           double num2 =  scanner.nextDouble();

           double soma = num1 + num2;

           double subtracao = num1 - num2;

           double multiplicacao = num1 * num2;

           double divisao = num1 / num2;

           double restoDaDivisaoNum1 = num1 % num2;
           double restoDaDivisaoNum2 = num2 % num1;
           

           scanner.close();

           System.out.println("A soma dos números é: " + soma);
           System.out.printf("A subtração dos números é: %.2f\n", subtracao);
           System.out.printf("A multiplicação dos números é: %.2f\n", multiplicacao);
           System.out.printf("A divisão dos números é: %.2f\n", divisao);
           System.out.printf("O resto da divisão do primeiro número pelo segundo é: %.2f\n", restoDaDivisaoNum1);
           System.out.printf("O resto da divisão do segundo número pelo primeiro é: %.2f\n", restoDaDivisaoNum2);
    }
}
