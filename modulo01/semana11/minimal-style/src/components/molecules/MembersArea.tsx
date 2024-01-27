import { Member } from "../atoms/Member";

import styles from "../../style/MembersArea.module.css";


export function MembersArea () {
    return(
        <div className={styles.memberArea}>
            <Member role={"Managing Assistant"} name={"Kyle Edwards"}/>
            <Member role={"Manager"} name={"Ann Warren"}/>
            <Member role={"Agent"} name={"Tomothy Pena"}/>
            <Member role={"Designer"} name={"Serenity Henry"}/>
            <Member role={"User Reserarch"} name={"Arlene Russell"}/>
            <Member role={"Marketing"} name={"Marvin Howard"}/>
        </div>
    )
}