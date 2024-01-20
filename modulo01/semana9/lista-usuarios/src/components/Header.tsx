import styles from './Header.module.css'


export function Header() {
    return (
        <div className={styles.header}>

            <div className={styles.headerContent}>
                <h1>Cadastro de Alunos</h1>
                <p>Preencha o formulário abaixo para fazer parte da nova turma do curso Futuro Dev - Senai</p>
            </div>
        </div>
    )
}