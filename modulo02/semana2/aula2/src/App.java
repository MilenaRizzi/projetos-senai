public class App {
    public static void main(String[] args) throws Exception {
       String[][] predio = new String[3][5];  
        predio[0][0] = "Ana Carolina";
        predio[0][1] = "Manoel Cavenati";
        predio[0][2] = "Nathalia Lanzendorf";
        predio[0][3] = "Milena Ribeiro";
        predio[0][4] = "Guildo Filho";
        predio[1][0] = "João de Souza";
        predio[1][1] = "Maria dos Santos";
        predio[1][2] = "Jaqueline Soares";
        predio[1][3] = "Andrea Gonçalves";
        predio[1][4] = "Rubens Machado";
        predio[2][0] = "Morador 1";
        predio[2][1] = "Morador 2";
        predio[2][2] = "Morador 3";
        predio[2][3] = "Morador 4";
        predio[2][4] = "Morador 5";

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 5; j++){
                System.out.println("Andar: " + (i + 1) + ", Morador " + (j + 1) + ": " + predio[i][j]);
            }
            System.out.println();
        }
    }
}
