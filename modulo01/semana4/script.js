function addTask() {
    var taskInput = document.getElementById("taskInput");
    var taskList = document.getElementById("taskList");
    if (taskInput.value.trim() === "") {
        alert("Please enter a task");
        return;
    }
    var li = document.createElement("li");
    // Criar o checkbox
    var checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.className = "task-checkbox";
    li.appendChild(checkbox);
    // Criar a label
    var label = document.createElement("label");
    label.className = "task-text";
    label.textContent = taskInput.value;
    li.appendChild(label);
    // Criar o botão de exclusão
    var deleteButton = document.createElement("button");
    deleteButton.className = "delete-btn";
    deleteButton.innerHTML = '<img src="imagens/delete16px.png" alt="">';
    deleteButton.onclick = function () {
        taskList.removeChild(li);
    };
    li.appendChild(deleteButton);
    // Adicionar a nova tarefa à lista
    taskList.appendChild(li);
    taskInput.value = "";
}

// Adicione a função para excluir a tarefa
function deleteTask(btn) {
    // Obtém o elemento pai (li) do botão clicado
    var listItem = btn.parentNode;

    // Remove o elemento pai do DOM
    listItem.remove();
}

// Adicione eventos onclick aos botões delete-btn
document.addEventListener('DOMContentLoaded', function () {
    var deleteButtons = document.querySelectorAll('.delete-btn');

    deleteButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            deleteTask(this);
        });
    });
});