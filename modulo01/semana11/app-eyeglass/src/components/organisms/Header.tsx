import { NavigationMenu } from "../molecules/NavigationMenuHeader";
import styles from './Header.module.css'

export function Header() {
  return (
    <div className={styles.header}>
      <div className={styles.logo}>
        <p>R</p>
      </div>
      <NavigationMenu />
      <div className={styles.userAndBag}>
        <p>Jasmine</p>
        <p>Bag: 3</p>
      </div>
    </div>
  )
}