import { MenuItem } from "../atoms/MenuItem";
import styles from "../organisms/Header.module.css";

export function NavigationMenu() {
  return (
    <div className={styles.menu}>
      <MenuItem title="Curated"/>
      <MenuItem title="Categories"/>
      <MenuItem title="Objects"/>
    </div>
  )
}