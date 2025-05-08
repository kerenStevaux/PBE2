// Aguarda o carregamento da página
document.addEventListener("DOMContentLoaded", function() {

	// Seleciona o formulário pelo ID
	const form = document.getElementById("formCadastroPessoa");

	// Adiciona um evento de submit no formulário
	form.addEventListener("submit", function(event) {
		event.preventDefault(); // Impede o envio padrão do formulário

		// Captura os valores digitados nos campos

		const nome = document.getElementById("nome").value;
		const email = document.getElementById("email").value;
		const telefone = document.getElementById("telefone").value;
		const senha = document.getElementById("senha").value;

		// Envia os dados para o backend usando fetch
		fetch('http://localhost:8080/api/pessoas', { // <-- URL do seu backend Spring Boot
			method: 'POST', // Método HTTP
			headers: {
				'Content-Type': 'application/json' // Tipo de conteúdo enviado
			},
			body: JSON.stringify({
				nome,
				email,
				telefone,
				senha
			})
		})
			.then(response => {
				if (!response.ok) {
					throw new Error('Erro ao cadastrar pessoa');
				}
				return response.json(); // Pega o corpo da resposta (esperando que venha o objeto com id)
			})
			.then(data => {
				// Armazena o ID da pessoa no localStorage
				localStorage.setItem('pessoaId', data.id); // Supondo que o backend retorne { id: 1, ... }

				// Redireciona para a página de endereço
				window.location.href = './pages/cadastroEndereco.html';
			})

	})
		.catch(error => {
			// Mostra o erro no console
			console.error('Erro no cadastro:', error);
			alert('Falha ao cadastrar pessoa. Tente novamente.');
		});
});

