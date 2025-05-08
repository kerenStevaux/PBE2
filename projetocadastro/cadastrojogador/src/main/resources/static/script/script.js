// Quando clicar no botão "Cadastrar"
document.getElementById('formCadastro').addEventListener('submit', function(e) {
	e.preventDefault();

	const nomeConst = document.getElementById('Nome Jogo Formulario').value;
	const anoConst = document.getElementById('Ano Lançamento Formulario').value;
	const tipoConst = document.getElementById('Tipo Jogo Formulario').value;
	const avaliacaoConst = document.getElementById('Avaliação Cliente Formulario').value;

	// Enviar para a API
	fetch('http://localhost:8080/cadastrojogos', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(
			{ 
				nomeJogoAtributo: nomeConst, 
				anoLancamentoAtributo: anoConst,
				tipoAtributo: tipoConst,
				avaliacaoAtributo: avaliacaoConst
			})
	});

	document.getElementById('formCadastro').reset();
	location.reload();

});

// Quando a página carregar
window.onload = function() {
	// Buscar pessoinhas da API e mostrar na tabela
	fetch('http://localhost:8080/cadastrojogos')
		.then(res => res.json())
		.then(pessoinhas => {
			const tabela = document.getElementById('tabelaJogos').querySelector('tbody');
			pessoinhas.forEach(p => {
				const linha = tabela.insertRow();
				linha.insertCell(0).textContent = p.nomeJogoAtributo;
				linha.insertCell(1).textContent = p.anoLancamentoAtributo;
				linha.insertCell(0).textContent = p.tipoAtributo;
				linha.insertCell(1).textContent = p.avaliacaoAtributo;
			});
		});
};