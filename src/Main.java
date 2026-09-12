public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
            1,
            "Thayna",
            "000.000.000-00",
            "teste@email.com",
            "(22) 99999-9999"
        );

        cliente.exibirDados();
    }
}