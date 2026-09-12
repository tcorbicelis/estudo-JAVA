package sistema_clientes.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sistema_clientes.Cliente;
import sistema_clientes.ClienteService;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {

    private ClienteService clienteService = new ClienteService();

    @GetMapping("/")
    public String inicio() {
        return "API do sistema de clientes funcionando!";
    }

    @GetMapping("/clientes")
    public ArrayList<Cliente> listarClientes() {
        return clienteService.listar();
    }

    @PostMapping("/clientes")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrar(cliente);
        return cliente;
    }
}