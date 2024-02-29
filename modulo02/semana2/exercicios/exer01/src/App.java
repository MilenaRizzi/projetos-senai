import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número para o início do intervalo");
        int num1 = scan.nextInt();

        System.out.println("Digite para o fim do intervalo");
        int num2 = scan.nextInt();

        int soma = 0;
        for(int i = num1; i <= num2; i++) {
            soma += i;
        }

        System.out.println("A soma dos valores é: " + soma);
        scan.close();
    }
}
