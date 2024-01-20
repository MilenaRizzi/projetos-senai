import { useState } from "react";
import styles from './StyleToggle.module.css'

export function StyleToggle() {

    const [currentStyle, setCurrentStyle] = useState<'light' | 'dark'>('light');

    function toggleStyle() {
        setCurrentStyle((prevStyle) => (prevStyle === 'light' ? 'dark' : 'light'));
    }

     // Aplicar classes CSS com base no estilo atual
     const containerClass = `${styles.StyleToggle} ${currentStyle === 'light' ? styles.LightStyle : styles.DarkStyle}`;

    return (
        <div className={containerClass}>
            <h1>Alternar Estilo</h1>
            <p>Modo atual: {currentStyle}</p>
            <button onClick={toggleStyle}>Alterar estilo de fundo</button>
        </div>
    )
}