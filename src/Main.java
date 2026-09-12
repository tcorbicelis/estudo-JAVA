import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista onde vamos armazenar os clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n========================================");
            System.out.println("       SISTEMA DE CADASTRO DE CLIENTES");
            System.out.println("========================================");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Excluir cliente");
            System.out.println("0 - Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                // ========================================
                // CADASTRAR CLIENTE
                // ========================================

                case 1:

                    scanner.nextLine();

                    System.out.println("\n========================================");
                    System.out.println("          CADASTRO DE CLIENTE");
                    System.out.println("========================================");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    // Cria um ID automaticamente
                    int id = clientes.size() + 1;

                    Cliente cliente = new Cliente(
                        id,
                        nome,
                        cpf,
                        email,
                        telefone
                    );

                    // Adiciona o cliente à lista
                    clientes.add(cliente);

                    System.out.println("\nCliente cadastrado com sucesso!");

                    break;


                // ========================================
                // LISTAR CLIENTES
                // ========================================

                case 2:

                    System.out.println("\n========================================");
                    System.out.println("          LISTA DE CLIENTES");
                    System.out.println("========================================");

                    if (clientes.isEmpty()) {

                        System.out.println("Nenhum cliente cadastrado.");

                    } else {

                        for (Cliente c : clientes) {

                            c.exibirDados();

                            System.out.println("----------------------------------------");
                        }
                    }

                    break;


                // ========================================
                // BUSCAR CLIENTE
                // ========================================

                case 3:

                    System.out.println("\n========================================");
                    System.out.println("          BUSCAR CLIENTE");
                    System.out.println("========================================");

                    System.out.print("Digite o ID do cliente: ");
                    int idBusca = scanner.nextInt();

                    boolean encontrado = false;

                    for (Cliente c : clientes) {

                        if (c.getId() == idBusca) {

                            System.out.println("\nCliente encontrado!");
                            System.out.println("----------------------------------------");

                            c.exibirDados();

                            encontrado = true;

                            break;
                        }
                    }

                    if (!encontrado) {

                        System.out.println("\nCliente não encontrado.");
                    }

                    break;


                // ========================================
                // EDITAR CLIENTE
                // ========================================

                case 4:

                    System.out.println("\n========================================");
                    System.out.println("          EDITAR CLIENTE");
                    System.out.println("========================================");

                    System.out.print("Digite o ID do cliente: ");
                    int idEditar = scanner.nextInt();

                    scanner.nextLine();

                    boolean clienteEncontrado = false;

                    for (Cliente c : clientes) {

                        if (c.getId() == idEditar) {

                            clienteEncontrado = true;

                            System.out.println("\nCliente encontrado!");
                            System.out.println("----------------------------------------");

                            c.exibirDados();

                            System.out.println("\nDigite os novos dados:");

                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();

                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();

                            System.out.print("Novo e-mail: ");
                            String novoEmail = scanner.nextLine();

                            System.out.print("Novo telefone: ");
                            String novoTelefone = scanner.nextLine();

                            // Atualiza os dados do cliente
                            c.setNome(novoNome);
                            c.setCpf(novoCpf);
                            c.setEmail(novoEmail);
                            c.setTelefone(novoTelefone);

                            System.out.println("\nCliente atualizado com sucesso!");

                            break;
                        }
                    }

                    if (!clienteEncontrado) {

                        System.out.println("\nCliente não encontrado.");
                    }

                    break;


                // ========================================
                // EXCLUIR CLIENTE
                // ========================================

                case 5:

                    System.out.println("\n========================================");
                    System.out.println("          EXCLUIR CLIENTE");
                    System.out.println("========================================");

                    System.out.println("Funcionalidade em desenvolvimento...");

                    break;


                // ========================================
                // SAIR
                // ========================================

                case 0:

                    System.out.println("\nEncerrando o sistema...");

                    break;


                // ========================================
                // OPÇÃO INVÁLIDA
                // ========================================

                default:

                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}