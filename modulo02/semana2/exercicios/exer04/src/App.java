import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número para multiplicar");

        int num = scan.nextInt();

        for (int i = 1; i <= 10; i++) {
            int multiplicacao = num * i;
            System.out.println(i + " x " + num + " = " + multiplicacao);
        }

        scan.close();
    }
}
