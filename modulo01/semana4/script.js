function addTask() {
    let taskInput = document.getElementById("taskInput");
    let taskList = document.getElementById("taskList");
    if (taskInput.value.trim() === "") {
        alert("Please enter a task");
        return;
    }
    let li = document.createElement("li");
    // Criar o checkbox
    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.className = "task-checkbox";
    li.appendChild(checkbox);
    /*o texto só é sublinhado quando eu clico no checkbox
       
    checkbox.addEventListener("change", function () {
    label.style.textDecoration = checkbox.checked ? "line-through" : "none";
    });*/

    // Criar a label
    let span = document.createElement("span");
    span.className = "task-text";
    span.textContent = taskInput.value;
    li.appendChild(span);
    // Criar o botão de exclusão
    let deleteButton = document.createElement("button");
    deleteButton.className = "delete-btn";
    deleteButton.innerHTML = '<img src="imagens/delete16px.png" alt="">';
    deleteButton.onclick = function () {
        let resposta = confirm("Tem certeza que deseja excluir esta tarefa?")
        if (resposta) {
            taskList.removeChild(li);
        }
    };
    li.appendChild(deleteButton);
    // Adicionar a nova tarefa à lista
    taskList.appendChild(li);
    taskInput.value = "";

    // Adicionar o ouvinte de eventos de clique para marcar/desmarcar a checkbox e sublinhar o texto
    li.addEventListener('click', function () {
        checkbox.checked = checkbox.checked;
        span.style.textDecoration = checkbox.checked ? 'line-through' : 'none';
    });
}

// Adicione a função para excluir a tarefa
function deleteTask(btn) {
    // Obtém o elemento pai (li) do botão clicado
    let listItem = btn.parentNode;

    // Remove o elemento pai do DOM
    listItem.remove();
}

// Adicione eventos onclick aos botões delete-btn
document.addEventListener('DOMContentLoaded', function () {
    //Poderia fazer o checkbox de todos os elementos assim, dessa forma quando eu clicasse no checked ele iria deixar o elemento grifado
    // let checkboxes = document.querySelectorAll('.task-checkbox');

    // checkboxes.forEach(function (checkbox) {
    //     checkbox.addEventListener('change', function () {
    //         let span = checkbox.nextElementSibling;
    //         span.style.textDecoration = checkbox.checked ? 'line-through' : 'none';
    //     });
    // });

    let deleteButtons = document.querySelectorAll('.delete-btn');

    deleteButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            let resposta = confirm("Tem certeza que deseja excluir esta tarefa?")
            if (resposta) {
                deleteTask(this);
            }
        });
    });
});