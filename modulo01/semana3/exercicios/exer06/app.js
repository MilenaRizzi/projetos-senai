//Lanchonete

const campoCodigo = document.getElementById("codigo-prod");
const campoQuantidade = document.getElementById("quantidade");
const botaoPedir = document.getElementById("pedir");
const botaoNovoPedido = document.getElementById("novo-pedido")

const pValor = document.getElementById("valor-pedido");
const pAgradecimento = document.getElementById("agradecimento");
function handleClick(e) {
    e.preventDefault();
    const codigo = campoCodigo.value;
    const quantidade = Number(campoQuantidade.value);
    let preco = 0;

    //poderia usar switch também, ou objeto
    if (codigo === "1123") {
        preco = 12;
    } else if (codigo === "3423") {
        preco = 9;
    } else if (codigo === "4521") {
        preco = 15;
    } else if (codigo === "5322") {
        preco = 34.99;
    }

    const valor = preco * quantidade;

    document.querySelector(".pagina-inicial").classList.add('hide');
    document.querySelector(".resultado").classList.remove('hide');

    pValor.innerHTML = `O valor total da compra é de: R$ ${valor.toFixed(2)}`;

    pAgradecimento.innerHTML = `Lanchonete online agradece!`
}

function handleResetClick() {
    document.querySelector(".pagina-inicial").classList.remove('hide');
    document.querySelector(".resultado").classList.add('hide');
}

botaoPedir.addEventListener('click', handleClick);
botaoNovoPedido.addEventListener('click', handleResetClick);