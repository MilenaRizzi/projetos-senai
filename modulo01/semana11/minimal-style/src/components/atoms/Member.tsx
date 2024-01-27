import styles from "../../style/MembersArea.module.css";

interface MemberProps {
    role: string;
    name: string;
}
export function Member( {role, name} : MemberProps) {
    return (
        <div className={styles.member}>
            <img src="src\assets\userIcon32.png" alt="" />
            <div className={styles.memberInfos}>
                <p>{role}</p>
                <h2>{name}</h2>
            </div>
        </div>
    )
}