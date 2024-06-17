import './Mensagens.css'
import { useState } from "react";

interface MensagensProps {
  mensagens: string[]
}

export function Mensagens({ mensagens }: MensagensProps) {
  const [messages, setMessages] = useState<string[]>(mensagens);
  const [newMessage, setNewMessage] = useState<string>('');

  const handleAddMessage = () => {
    if (newMessage.trim() !== '') {
      setMessages([...messages, newMessage]);
      setNewMessage('');
    }
  };

  return (
    <>
      <div className="card">
        <div>
          
          <input
            type="text"
            value={newMessage}
            onChange={(e) => setNewMessage(e.target.value)}
            placeholder="Digite uma nova mensagem"
          />
          <button onClick={handleAddMessage}>Adicionar Mensagem</button>
        </div>

        <ul className="lista">
          {messages.map((message, index) => (
            <li key={index}>{message}</li>
          ))}
        </ul>

      </div>
    </>
  )
}