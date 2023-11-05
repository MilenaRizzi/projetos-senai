const screen1 = document.querySelector('.screen1')
const screen2 = document.querySelector('.screen2')
const screen3 = document.querySelector('.screen3')

function handleTryClick(event) {
    event.preventDefault()

    const inputNota1 = document.querySelector('#inputNota1');
    const nota1 = Number(inputNota1.value);

    const inputNota2 = document.querySelector('#inputNota2')
    const nota2 = Number(inputNota2.value);

    const inputNota3 = document.querySelector('#inputNota3')
    const nota3 = Number(inputNota3.value)

    const media = (nota1 + nota2 + nota3) / 3;

    if (media >= 7) {
        document.querySelector(".screen3 #aprovado").innerText = `Aprovado: ${media.toFixed(2)}`
        screen1.classList.add('hide')
        screen3.classList.remove('hide')
    } else {
        screen1.classList.add('hide')
        screen2.classList.remove('hide')
        document.querySelector(".screen2 #recuperacao").innerText = `Em recuperacao: ${media.toFixed(2)}`
    }
}


function handleResetClick() {
    screen1.classList.remove('hide')
    screen2.classList.add('hide')
    screen3.classList.add('hide')   
}


const btnTry = document.querySelector('#btnCalc')
const btnReset1 = document.querySelector('#btnReset1')
const btnReset2= document.querySelector('#btnReset2')


btnTry.addEventListener('click', handleTryClick)
btnReset1.addEventListener('click', handleResetClick)
btnReset2.addEventListener('click', handleResetClick)