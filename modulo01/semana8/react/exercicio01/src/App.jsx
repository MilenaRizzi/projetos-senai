import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Contador } from './components/Contador'
function App() {
  return (
    <>
    <p>Clique no botão abaixo para fazer a contagem:</p>
      <Contador/>
    </>
  )
}

export default App
