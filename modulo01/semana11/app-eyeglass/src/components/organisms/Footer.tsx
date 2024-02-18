import styles from './Footer.module.css'


export function Footer() {
  return (
    <footer className={styles.footer}>
      <p>Help</p>
      <span>/</span>
      <p>Connect</p>
    </footer>
  )
}