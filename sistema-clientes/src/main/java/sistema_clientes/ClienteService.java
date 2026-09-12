package sistema_clientes;

import java.util.ArrayList;

public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Cadastrar cliente
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    // Listar clientes
    public ArrayList<Cliente> listar() {
        return clientes;
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    // Excluir cliente
    public boolean excluir(int id) {

        Cliente cliente = buscarPorId(id);

        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }

        return false;
    }
}