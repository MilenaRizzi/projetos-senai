import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        isPrime();
    }

    public static void isPrime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número");


        int num = scan.nextInt();
        boolean primo = false;

        for (int i = 0; i < num; i++) {
            if (num % 2 != 0 || num == 2) {
                primo = true;
            }
        }
        if (primo) {
            System.out.println("O numero " + num + " é primo");
        } else {
            System.out.println("O numero " + num + " não é primo");

        }
        scan.close();
     }
}
