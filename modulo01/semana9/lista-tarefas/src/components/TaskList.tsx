import { useState } from "react";
import "./taskList.css";

interface ToDoItem {
  id: string;
  value: string;
  completed: boolean;
}

export function TaskList() {
  const [list, setList] = useState<ToDoItem[]>([]);
  const [inputValue, setInputValue] = useState("");

  function addItemToList(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    if (inputValue.length > 0) {
      const newTask: ToDoItem = {
        id: Date.now().toString(),
        value: inputValue,
        completed: false,
      };
      setList((tasks) => [...tasks, newTask]);

      setInputValue("");
    }
  }

  function toggleItemCompletion(itemId: string) {
    const updatedList = list.map((item) =>
      item.id === itemId ? { ...item, completed: !item.completed } : item
    );

    setList(updatedList);
  }

  
  function handleDeleteTask(id: string) {
    setList((prevTask) => prevTask.filter((task) => task.id !== id));
  }

  return (
    <div className="lista-tarefas">
      <span className="texto-span">Adicione um item à sua lista</span>
      <form className="formulario" onSubmit={addItemToList}>
        <input
          type="text"
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
        />
        <button className="btn-adicionar" type="submit">
          Adicionar 
        </button>
      </form>
      <div>
        <ul className="itens">
          {list.map((item) => (
            <li className="item-lista" key={item.id}>
              <div>
                <input
                  className="checkbox"
                  type="checkbox"
                  checked={item.completed}
                  onChange={() => toggleItemCompletion(item.id)}
                />
                <span>{item.value}</span>
              </div>
              <button onClick={() => handleDeleteTask(item.id)}>🗑️</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
