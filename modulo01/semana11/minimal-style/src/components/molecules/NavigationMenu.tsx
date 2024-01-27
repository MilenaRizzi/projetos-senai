import { MenuItem } from "../atoms/MenuItem";
import styles from "../../style/Header.module.css";
import { Button } from "../atoms/Button";
import { AiOutlineSearch } from "react-icons/ai";


export function NavigationMenu() {
    return (
        
        <div  className={styles.navigationMenu}>
             <p>YOUR LOGO</p>
            
            <div className={styles.meuItems}>
                <MenuItem text="Menu 1"/>
                <MenuItem text="Menu 2"/>
                <MenuItem text="Menu 3"/>
                <MenuItem text="Menu 4"/>
                <MenuItem text="Menu 5"/>
            </div>
            <div className={styles.buttonsNav}>
                <Button  Icon={AiOutlineSearch} />
                <Button title="GET IN TOUTCH" />
            </div>
        </div>
    )
}