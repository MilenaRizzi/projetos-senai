import './App.css'
import { Header } from './compents/Header'
import { TaskList } from './compents/TaskList'

function App() {
  return (
   <div>
     <Header title='Lista de Tarefas' />
    {TaskList()}
   </div>
  )
}

export default App
