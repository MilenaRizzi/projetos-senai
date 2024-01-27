import styles from "../../style/NavigationMenu.module.css";

interface MenuItemProps {
    text: string;
    onClick?: () => void;
}

export function MenuItem({ text, onClick }: MenuItemProps) {
    return (
        <div
            className={styles.menuItem}
            onClick={onClick}>
            <a href="#">{text}</a>
        </div>
    )
}