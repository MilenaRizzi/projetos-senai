import { ChangeEvent, useState } from 'react'
import styles from './App.module.css'


function App() {
  const [newFeedbackText, setNewFeedbackText] = useState('');

  const [feedbacksText, setFeedbacksText] = useState<string[]>([]);


  function handleNewFeedBackText(event: ChangeEvent<HTMLInputElement>) {
    event.target.setCustomValidity('Este campo não pode ser vazio');
    setNewFeedbackText(event.target.value);

  }

  function handleEnviarFeedBack() {
    setFeedbacksText([...feedbacksText, newFeedbackText]);
    setNewFeedbackText('');
  }

  function handleDeletFeedback(index: number) {
    setFeedbacksText((prevUsers) => prevUsers.filter((_, i) => i !== index));
  }


  return (
    <div id='hero' className={styles.page}>
      <header className={styles.header}>
        <a href="https://www.instagram.com/lab365_/" target="_blank">
          <img src="https://lab365-admin.hml.sesisenai.org.br/javax.faces.resource/img/logo-lab.png" alt="React logo" />
        </a>
      </header>

      <div className={styles.content}>
        <img src="\src\assets\ilustracao-do-conceito-de-loop-de-feedback.png" alt="" />
        <section className={styles.sectionContent}>
          <h1>FeedBack</h1>

          <p>Seja bem-vindo(a) ao espaço dedicado ao seu feedback sobre o curso: <br /> <span>Análise e Desenvolvimento Web fornecido por Senai - Lab365. </span><br /> Compartilhe sua Experiência e deixe a sua opinião!</p>

          <div>
            <input
              className={styles.inputInfo}
              type="text"
              placeholder="Sua opinião"
              value={newFeedbackText}
              onChange={handleNewFeedBackText}

            />
          </div>

          <button
            className={styles.btnEnviar}
            onClick={handleEnviarFeedBack}
            disabled={!newFeedbackText}>
            Enviar
          </button>

        </section>

      </div>
      {
        feedbacksText.length >= 1 && (
          <div className={styles.feedbackList}>
            <h2>Feedbacks</h2>
            {
              feedbacksText.map((feedback, index) => {
                return (
                  <div className={styles.feedback}>
                    <p> {feedback} </p>
                    <button onClick={() => handleDeletFeedback(index)}>🗑️</button>
                  </div>
                );
              })
            }
          </div>
        )
      }

    </div>
  )
}

export default App
