const screen1 = document.querySelector('.screen1');
const screen2 = document.querySelector('.screen2');

function handleTryClick(e) {
    e.preventDefault();

    const inputSalario = document.querySelector('#inputSalario')
    const salario = Number(inputSalario.value);

    //fgts mês
    const fgtsMensal = salario * 0.08;

    //fgts anula
    const fgtsAnual = fgtsMensal * 12;

    screen1.classList.add("hide")
    screen2.classList.remove("hide")

    document.querySelector('.screen2 #pMensal').innerText = `FGTS mensal - R$ ${fgtsMensal}`

    document.querySelector('.screen2 #pAnual').innerText = `FGT anual - R$ ${fgtsAnual}`

}

function handleResetClick() {
    screen1.classList.remove("hide")
    screen2.classList.add("hide")
}

//Eventos
const btnCalc = document.querySelector('#btnCalc');
const btnReset = document.querySelector('#btnReset');

btnCalc.addEventListener('click', handleTryClick);
btnReset.addEventListener('click', handleResetClick);