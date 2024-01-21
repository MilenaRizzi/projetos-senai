import React, { useEffect } from 'react';
import './App.css';

function App() {
  useEffect(() => {
    // Mensagem exibida quando o componente é montado
    console.log('Componente foi montado');

    // Função de limpeza (será chamada quando o componente for desmontado)
    return () => {
      console.log('Componente será desmontado');
    };
  }, []); // O array vazio assegura que o useEffect seja executado apenas uma vez (na montagem do componente)

  // Renderização do componente
  return (
    <div>
      <p>Componente</p>
    </div>
  );
}

export default App;
