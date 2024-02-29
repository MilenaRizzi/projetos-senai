public class App {
    public static void main(String[] args) throws Exception {
        double notas[] = {5, 8, 10, 6, 7, 4, 5.5, 7.5, 9.5, 6.5};
        System.out.printf("O calculo da média da turma é: %.2f\n", calculoMedia(notas)); // Saída: 3.14
    }

    public static Double calculoMedia(double[] numero) {
        double media = 0;
        for (int i = 0; i < numero.length; i++) {
            media += numero[i];
        }
        return media / numero.length;  
    }
}
