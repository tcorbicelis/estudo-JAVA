const API_URL = "http://localhost:8080/clientes";

const formulario = document.getElementById("clienteForm");
const lista = document.getElementById("clientesLista");
const listarBtn = document.getElementById("listarBtn");

formulario.addEventListener("submit", async function (event) {
    event.preventDefault();

    const cliente = {
        id: 0,
        nome: document.getElementById("nome").value.trim(),
        cpf: document.getElementById("cpf").value.trim(),
        email: document.getElementById("email").value.trim(),
        telefone: document.getElementById("telefone").value.trim()
    };

    try {
        const resposta = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cliente)
        });

        const textoResposta = await resposta.text();

        console.log("Status:", resposta.status);
        console.log("Resposta:", textoResposta);

        if (!resposta.ok) {
            throw new Error(
                `Erro ${resposta.status}: ${
                    textoResposta || "Falha no servidor"
                }`
            );
        }

        alert("Cliente cadastrado com sucesso!");

        formulario.reset();

        await listarClientes();

    } catch (erro) {
        console.error("Erro ao cadastrar:", erro);

        alert(
            "Não foi possível cadastrar o cliente.\n\n" +
            erro.message
        );
    }
});

async function listarClientes() {
    try {
        const resposta = await fetch(API_URL);

        if (!resposta.ok) {
            throw new Error(`Erro ao listar clientes: ${resposta.status}`);
        }

        const clientes = await resposta.json();

        lista.innerHTML = "";

        clientes.forEach(function (cliente) {
            const item = document.createElement("li");

            item.textContent =
                `ID: ${cliente.id} - ` +
                `${cliente.nome} - ` +
                `${cliente.cpf} - ` +
                `${cliente.email} - ` +
                `${cliente.telefone}`;

            lista.appendChild(item);
        });

    } catch (erro) {
        console.error("Erro ao carregar clientes:", erro);

        alert(
            "Não foi possível carregar os clientes.\n\n" +
            erro.message
        );
    }
}

listarBtn.addEventListener("click", listarClientes);

listarClientes();