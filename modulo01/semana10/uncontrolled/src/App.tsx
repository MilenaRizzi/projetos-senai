import { FormEvent, useRef } from 'react'
import './App.css'

function App() {

  const inputRef = useRef<HTMLInputElement | null>(null);

  function handleSubmit(event: FormEvent) {
    if (inputRef.current) {
      alert("O número inserido foi: " + inputRef.current.value);
    }
    event.preventDefault();
  }


  return (
    <>
      <form onSubmit={handleSubmit} className='content'>
        <label htmlFor="number">Digite um número</label>
        <input type="number" name='number' ref={inputRef} />
        <button type='submit'>Exibir número</button>
      </form>
    </>
  )
}

export default App
