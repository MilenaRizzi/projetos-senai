import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className="card">
        <div className="count">
          {count}
        </div>
        <div className="buttons">
          <button onClick={() => setCount((count) => count + 1)}>
            Incrementar
          </button>
          <button onClick={() => setCount((count) => count - 1)}>
            Decrementar
          </button>
        </div>
      </div>
    </>
  )
}

export default App
