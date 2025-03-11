document.getElementById("cep").addEventListener("input", async function (){
 const cep = this.value.replace(/\D/g, ""); 

 if (cep.length === 8){
    try{
        const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);

        if(!response.ok) throw new Error("Erro ao buscar CEP");

        const dados = await response.json();

        if (dados.erro){
            alert("CEP não encontrado.")
            return;
        }

        document.getElementById("rua").value = dados.rua;
        document.getElementById("bairro").value = dados.bairro;
        document.getElementById("cidade").value = dados.cidade;
        document.getElementById("estado").value = dados.estado;

    } catch (error) {
        alert("Erro ao buscar o endereço: " + error.message);
    }

 }
})

document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("cadastroEnderecoForm");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const cep = document.getElementById("cep").value;
        const estado = document.getElementById("estado").value;
        const cidade = document.getElementById("cidade").value;
        const numeroCasa = document.getElementById("numeroCasa").value;
        const rua = document.getElementById("rua").value;
        const complemento = document.getElementById("complemento").value;
        const bairro = document.getElementById("bairro").value;

        try {

            const response = await fetch("http://localhost:8080/cadastroendereco", {
                method: "POST",
                headers: {
                    "Content-type": "application/json"
                },

                body: JSON.stringify({
                    cep,
                    estado,
                    cidade,
                    numeroCasa,
                    rua,
                    complemento,
                    bairro
                }),
            });

            if (!response.ok){
				throw new("Erro ao cadastrar")
			} else {
				window.location.href = "sucessocadastro.html"; //
			}

        } catch (error) {
            console.error("Erro ao cadastrar o endereço", error);
        }

    });
})