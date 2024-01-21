import { ChangeEvent, FormEvent, useState } from "react"
import { Header } from "./Header"
import styles from './UserList.module.css'


export function UserList() {

    const [form, setForm] = useState({
        name: '',
        age: '',
        exp: ''
    });

    const [users, setUsers] = useState<{ name: string; age: string; exp: string }[]>([]);

    const [sent, setSent] = useState(false);

    function handleInputChange(event: ChangeEvent<HTMLInputElement>) {
        const { name, value } = event.target;
        setForm((prevForm) => ({
            ...prevForm,
            [name]: value
        }));
    }

    function handleAddNewUser(event: FormEvent) {
        // const newUser: UserProps = { name, email, phone };
        // setUsers(prevUsers => [...users, newUser]);
        event.preventDefault();
        setSent(true);

        setUsers((prevUsers) => [...prevUsers, form]);

        // Limpa o formulário
        setForm({
            name: '',
            age: '',
            exp: ''
        });
    }

    function handleDeleteRegister(index: number) {
        setUsers((prevUsers) => prevUsers.filter((_, i) => i !== index));
    }


    return (
        <div className={styles.content}>
            <div>
                <Header />
            </div>
            <form onSubmit={handleAddNewUser} className={styles.form}>
                <div className={styles.wrapper}>
                    <div className={styles.inputWrapper}>
                        <div className={styles.name}>
                            <label htmlFor="name">Nome<span>(digite um nome e sobrenome)</span></label>
                            <input
                                name="name"
                                type="text"
                                onChange={handleInputChange}
                                value={form.name}
                            />
                        </div>
                    </div>

                    <div className={styles.inputWrapper}>
                        <label htmlFor="age">Idade<span>(ex: 18 anos)</span></label>
                        <input
                            type="text"
                            name="age"
                            onChange={handleInputChange}
                            value={form.age}
                        />
                    </div>

                    <div className={styles.inputWrapper}>
                        <label htmlFor="exp">Nível de Experiência<span>(iniciante, intermediário, avançado)</span></label>
                        <input
                            type="text"
                            name="exp"
                            onChange={handleInputChange}
                            value={form.exp} />
                    </div>


                    <div className={styles.enviar}>
                        <button 
                        className={styles.btnEnviar}
                        disabled={!form}>
                            Enviar
                        </button>
                    </div>
                </div>
            </form>
            {
                users.length >= 1 && (
                    <div className={styles.result}>
                        <h2>Lista de Alunos Cadastrados</h2>
                        {users.map((user, index) => (
                            <div className={styles.userInfos}key={user.name}>

                                <div>
                                    <p>nome: <span>{user.name}</span></p>
                                    <button onClick={() => handleDeleteRegister(index)}>🗑️</button>
                                </div>
                                <p>idade:<span> {user.age} anos</span> </p>
                                <p>experiência: <span>{user.exp}</span></p>
                                <hr/>
                            </div>
                        ))}
                    </div>
                )
            }
        </div>
    )
}