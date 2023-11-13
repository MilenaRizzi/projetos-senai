const screen1 = document.querySelector('.screen1');
const screen2 = document.querySelector('.screen2');

function handleTryClick(e) {
    e.preventDefault();

    const mesesDoAno = [
        'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
        'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
      ];
      
      const dataAtual = new Date();
      const ano = dataAtual.getFullYear();
      const mesNumero = dataAtual.getMonth(); // Os meses são indexados de 0 a 11.
      const dia = dataAtual.getDate();
      
      const mesNome = mesesDoAno[mesNumero];
      
      const dataFormatada = `${dia} de ${mesNome} de ${ano}`;
      
    const inputName = document.querySelector('#inputName');
    const name = inputName.value;

    const inputDateStart = document.querySelector('#inputDateStart')
    const dateStart = inputDateStart.value;

    const inputDateEnd = document.querySelector('#inputDateEnd')
    const dateEnd = inputDateEnd.value;

    screen1.classList.add('hide');
    screen2.classList.remove('hide');

   
    document.querySelector('.screen2 p').innerText = `Caro(a) responsável Gostaria de soliciar minhas férias: 
    Nome do funcionário: ${name} 
    Data de início: ${dateStart} 
    Data de fim: ${dateEnd} 
    Agradeço a atenção. 
    Atenciosamente, ${name} 
    Gerado em ${dataFormatada}`

  
}

function handleResetClick() {
    screen1.classList.remove('hide')
    screen2.classList.add('hide')
}

const btnCalc = document.querySelector('.btn-gerar');
btnCalc.addEventListener('click', handleTryClick);

const btnReset = document.querySelector('.btn-reset');
btnReset.addEventListener('click', handleResetClick)