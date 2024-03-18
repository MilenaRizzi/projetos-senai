public class TesteContaBancaria {
    public static void main(String[] args) throws Exception {
        ContaBancaria contaJoao = new ContaBancaria(12345, 123, "João da Silva", 20000);

        contaJoao.depositar(20000);

        contaJoao.sacar(5500);

    }
}
