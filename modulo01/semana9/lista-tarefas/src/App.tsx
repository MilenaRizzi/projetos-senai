import "./App.css";
import { Header } from "./components/Header";
import { TaskList } from "./components/TaskList";

function App() {
  return (
    <div>
      <Header title="Lista de Tarefas" />
      {TaskList()}
    </div>
  );
}

export default App;
