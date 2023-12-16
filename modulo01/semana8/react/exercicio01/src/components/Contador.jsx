import { useState } from "react";
import styles from './Contador.module.css';




export function Contador() {
    const [count, setCount] = useState(0);
    return (
        <>
            <button className={styles.contador} onClick={() => setCount((count) => count + 1)}>
                {count}
            </button>
        </>
    );
}