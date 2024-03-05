import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o tamanho do seu array");

        int tamanhoArr = scan.nextInt();
        double[] array = new double[tamanhoArr];

        System.out.println("Em seguida, digite os valores do seu array de tamanho " + tamanhoArr);

        for(int i = 0; i < tamanhoArr; i++) {
            System.out.print((i + 1) + "º número: ");
            double num = scan.nextDouble();
            array[i] = num;
        }

        System.out.println("--------------------------------");
        System.out.println("Array invetido: ");

        for(int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
        scan.close();
    }
}
