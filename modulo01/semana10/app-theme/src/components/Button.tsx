import { useState } from "react"

export function Button() {
    const [theme, setTheme] = useState('light');

    function toggleTheme() {
        setTheme(theme === 'light' ? 'dark' : 'light');
    }
    
    return (
        <button onClick={toggleTheme}>Mudar tema {theme}</button>
    )
}