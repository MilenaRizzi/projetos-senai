import { NavigationMenu } from "../molecules/NavigationMenu";
import styles from "../../style/Header.module.css";


export function Header() {
    return (
        <div className={styles.header}>
            <NavigationMenu />
            <h1>Team <br />Members</h1>
            <div className={styles.sectionContainer}>
                <div className={styles.section}>
                    <p>Select team member to view profile</p>
                    <div className={styles.sort}>
                        <a href="#">Sort By Name </a>
                        <img src="src\assets\dash.png" alt="" />
                        <a href="#">Sort By Date</a>
                    </div>
                </div>
            </div>

        </div >
    )
}