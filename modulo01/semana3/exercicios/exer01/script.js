
// const btnTry = document.querySelector("#btnTry");
// const btnReset = document.querySelector("#btnReset")
// const resp = document.querySelector("h3");

// //registrando o evento na aplicação
// btnTry.addEventListener('click', handleTryClick)

// //esse parametro e da função tem a ver com o evento. Esse evento é um objeto e todos os dados do evento, que nesse caso está sendo um evento de clique. 
// function handleTryClick(e) {
//     const inputNumber = document.querySelector("#inputPesoProduto");
//     const pesoValue = Number(inputNumber.value);

//     const inputDistanciaTrajeto = document.querySelector("#inputDistanciaTrajeto");
//     const distanciaValue = inputDistanciaTrajeto.value;

//     const valorFrete = 6 * pesoValue * distanciaValue;

//     console.log(resp.innerText = `Valor a pagar R$: ${valorFrete}`)

//     document.querySelector('section').classList.toggle('hide')//toggle é para que caso não haja a classe qnd eu clicar ela vai aparecer, e caso ela esteja aparecendo qnd eu clica ela vai sumir

//o evento todo de clique então é capturado, e por padrão, como estou lidando com formulário, todo formulário é enviado para algum lugar, e isso faz o recarregamento da página. Dessa forma, quando eu coloco esse prenvetDefault, eu estou dizendo para que esse padrão de envio seja ignorado. Para que o formulário
//     e.preventDefault();
// }

const screen1 = document.querySelector(".screen1")
const screen2 = document.querySelector(".screen2")
function handleTryClick(event) {
    event.preventDefault();

    const inputNumber = document.querySelector("#inputPesoProduto");
    const pesoValue = Number(inputNumber.value);
    
    const inputDistanciaTrajeto = document.querySelector("#inputDistanciaTrajeto");
    const distanciaValue = Number(inputDistanciaTrajeto.value);
    
     const valorFrete = 6 * pesoValue * distanciaValue;
  
     screen1.classList.add("hide")
     screen2.classList.remove("hide")
    
     document.querySelector(".screen2 h3").innerText = `Valor do frete é: R$ ${valorFrete.toFixed(2)}`
    
}

function handleResetClick() {
     screen1.classList.remove("hide")
     screen2.classList.add("hide")
}

const btnTry = document.querySelector("#btnTry")
const btnReset = document.querySelector("#btnReset")

btnTry.addEventListener('click', handleTryClick)
btnReset.addEventListener('click', handleResetClick)