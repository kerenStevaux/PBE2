document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("formCadastroEndereco");

    // Busca o ID da pessoa armazenado
    const pessoaId = localStorage.getItem('pessoaId');

    if (!pessoaId) {
        alert("Pessoa não encontrada. Por favor, cadastre uma pessoa primeiro.");
        window.location.href = "cadastroPessoa.html";
        return;
    }

    // Evento de envio do formulário
    form.addEventListener("submit", function(event) {
        event.preventDefault();

        // Coleta os dados do formulário
        const rua = document.getElementById("rua").value;
        const numero = document.getElementById("numero").value;
        const cidade = document.getElementById("cidade").value;
        const estado = document.getElementById("estado").value;
        const cep = document.getElementById("cep").value;

        // Faz o POST para o backend
        fetch(`http://localhost:8080/api/enderecos`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                rua,
                numero,
                cidade,
                estado,
                cep,
                pessoa: {
                    id:pessoaId
                }
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao cadastrar endereço.");
            }
            return response.json();
        })
        .then(data => {
            alert("Cadastro de endereço realizado com sucesso!");
            localStorage.removeItem('pessoaId'); // Limpa o ID da pessoa
            window.location.href = "../index.html"; // Redireciona para a página principal
        })
        .catch(error => {
            console.error("Erro:", error);
            alert("Erro ao cadastrar endereço. Tente novamente.");
        });
    });

    // Função para buscar o endereço automaticamente pelo CEP
    document.getElementById("cep").addEventListener("blur", function() {
        const cep = this.value.replace(/\D/g, '');

        if (cep.length === 8) {
            fetch(`https://viacep.com.br/ws/${cep}/json/`)
                .then(response => response.json())
                .then(data => {
                    if (!data.erro) {
                        document.getElementById("rua").value = data.logradouro || '';
                        document.getElementById("cidade").value = data.localidade || '';
                        document.getElementById("estado").value = data.uf || '';
                    } else {
                        alert("CEP não encontrado.");
                    }
                })
                .catch(error => {
                    console.error("Erro ao buscar CEP:", error);
                });
        }
    });
});
