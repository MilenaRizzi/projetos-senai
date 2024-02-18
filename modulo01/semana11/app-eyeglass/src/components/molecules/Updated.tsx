import { Button } from "../atoms/Button";
import styles from './Updated.module.css'
export function Update() {
  return (
    <div className={styles.updated}>
      <h1>Be Updated</h1>
      <div className={styles.infoUser}>
        <input type="text" />
        <Button text="Subscribe"/>
      </div>
    </div>
  )
}