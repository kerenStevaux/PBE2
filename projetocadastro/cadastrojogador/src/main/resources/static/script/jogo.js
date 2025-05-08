document.getElementById("jogoForm").addEventListener("submit", function(e) {
    e.preventDefault();
    fetch("http://localhost:8080/api/jogos", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        nome: document.getElementById("nomeJogo").value,
        anoLancamento: parseInt(document.getElementById("ano").value),
        jogador: { id: parseInt(document.getElementById("jogadorId").value) }
      })
    }).then(res => res.json()).then(data => alert("Jogo cadastrado com ID: " + data.id));
  });