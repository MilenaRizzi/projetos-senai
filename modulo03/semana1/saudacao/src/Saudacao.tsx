import './Saudacao.css'
import { useState } from "react";

interface SaudarProps {
  nomeInicial: string;
}

export function Saudacao({ nomeInicial } : SaudarProps) {
  const [nome, setNome] = useState(nomeInicial);
  const [novoNome, setNovoNome] = useState('');

  const atualizarNome = () => {
    setNome(novoNome);
    setNovoNome('');
  };

  return (
    <div className="card">
      <h1>Olá, {nome}!</h1>
      <input 
        type="text" 
        value={novoNome} 
        onChange={(e) => setNovoNome(e.target.value)} 
        placeholder="Digite um novo nome" 
      />
      <button onClick={atualizarNome}>Atualizar Nome</button>
    </div>
  );
}
