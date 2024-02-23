import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite o valor do raio do círculo: ");

        double raio = scanner.nextDouble();

        double PI = 3.14;

        double areaDoCirculo = PI * Math.pow(raio, 2);
        double perimetro = 2 * PI * raio;

        System.out.println("A área do círculo é: " + areaDoCirculo);
        System.out.println("O perímetro do círculo é: " + perimetro);

        scanner.close();
    }
}
