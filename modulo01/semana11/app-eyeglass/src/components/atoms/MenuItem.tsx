import styles from "../organisms/Header.module.css";

interface MenuItemProps {
  title: string;
}


export function MenuItem({ title } : MenuItemProps) {
  return(
    <div className={styles.itemMenu}>
      <a href="#">{title}</a>
    </div>
  )
}