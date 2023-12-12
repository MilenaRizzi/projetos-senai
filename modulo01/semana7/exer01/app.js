const inputCep = document.querySelector("#inputCep");
const btnBuscaCep = document.querySelector("#btnBuscaCep");
const spanLocal = document.querySelector("#span-local");


async function buscaCEP(cep) {
    try {
      const url = `https://viacep.com.br/ws/${cep}/json`;
      const resposta = await fetch(url);
      const dados = await resposta.json();
  
      console.log(dados);
  
      spanLocal.innerHTML = `<strong>${dados.localidade}</strong>`;
    } catch (error) {
      console.error(error);
    } finally {
      console.log("Concluiu a busca!");
    }
  }
  
  btnBuscaCep.addEventListener("click", () => {
    const cepInformado = inputCep.value.trim();
  
    if (cepInformado) {
      buscaCEP(cepInformado);
    }
  });
  