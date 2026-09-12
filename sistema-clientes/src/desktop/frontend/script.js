const API_URL = "http://localhost:8080/clientes";

const formulario = document.getElementById("clienteForm");
const lista = document.getElementById("clientesLista");
const listarBtn = document.getElementById("listarBtn");

formulario.addEventListener("submit", async function (event) {
    event.preventDefault();

    const cliente = {
        id: Date.now(),
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value
    };

    try {
        const resposta = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cliente)
        });

        if (!resposta.ok) {
            throw new Error("Erro ao cadastrar cliente.");
        }

        alert("Cliente cadastrado com sucesso!");

        formulario.reset();

        listarClientes();

    } catch (erro) {
        alert("Não foi possível cadastrar o cliente.");
        console.error(erro);
    }
});

async function listarClientes() {
    try {
        const resposta = await fetch(API_URL);
        const clientes = await resposta.json();

        lista.innerHTML = "";

        clientes.forEach(function (cliente) {
            const item = document.createElement("li");

            item.textContent =
                `${cliente.nome} - ${cliente.email} - ${cliente.telefone}`;

            lista.appendChild(item);
        });

    } catch (erro) {
        alert("Não foi possível carregar os clientes.");
        console.error(erro);
    }
}

listarBtn.addEventListener("click", listarClientes);

listarClientes();