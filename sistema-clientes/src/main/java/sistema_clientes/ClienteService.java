package sistema_clientes;

import java.util.ArrayList;

public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    private int proximoId = 1;

    // Cadastrar cliente
    public Cliente cadastrar(Cliente cliente) {

        cliente.setId(proximoId);
        proximoId++;

        clientes.add(cliente);

        return cliente;
    }

    // Listar clientes
    public ArrayList<Cliente> listar() {
        return clientes;
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() != null
                    && cliente.getId().equals(id)) {
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