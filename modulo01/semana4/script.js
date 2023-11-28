// function addTask() {
//     var taskInput = document.getElementById("taskInput");
//     var taskList = document.getElementById("taskList");

//     if (taskInput.value.trim() === "") {
//         alert("Please enter a task");
//         return;
//     }

//     var li = document.createElement("li");

//     // Criar o checkbox
//     var checkbox = document.createElement("input");
//     checkbox.type = "checkbox";
//     checkbox.className = "task-checkbox";
//     li.appendChild(checkbox);

//     // Criar a label
//     var label = document.createElement("label");
//     label.className = "task-text";
//     label.textContent = taskInput.value;
//     li.appendChild(label);

//     // Criar o botão de exclusão
//     var deleteButton = document.createElement("button");
//     deleteButton.className = "delete-btn";
//     deleteButton.innerHTML = '<img src="imagens/delete16px.png" alt="">';
//     deleteButton.onclick = function() {
//         taskList.removeChild(li);
//     };
//     li.appendChild(deleteButton);

//     // Adicionar a nova tarefa à lista
//     taskList.appendChild(li);

//     // Limpar o campo de entrada após adicionar a tarefa
//     taskInput.value = "";
// }

function addTask() {
    var taskInput = document.getElementById("taskInput");
    var taskList = document.getElementById("taskList");

    if (taskInput.value.trim() === "") {
        alert("Please enter a task");
        return;
    }

    var li = document.createElement("li");
    li.textContent = taskInput.value;

    var deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.onclick = function() {
        taskList.removeChild(li);
    };

    li.appendChild(deleteButton);
    taskList.appendChild(li);

    // Limpar o campo de entrada após adicionar a tarefa
    taskInput.value = "";
}

