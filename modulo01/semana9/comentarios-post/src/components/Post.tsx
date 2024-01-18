import styles from './Post.module.css';
import faviconComment from '../assets/faviconComments.png';
import faviconHeart from '../assets/faviconHeart.png';
import { Comment } from './Comment';
import { FormEvent, ChangeEvent, useState } from 'react';

export function Post() {
    const [comments, setCommments] = useState<string[]>([]); // Explicita o tipo como string[]
    const [newCommentText, setNewCommentText] = useState('');
    const [userName, setUserName] = useState('');
    const [commentCount, setCommentCount] = useState(1);
    const [likeCount, setLikeCount] = useState(0);

    function handleLikeCount() {
        setLikeCount((state) => state + 1);
    }

    function handleCommentCount() {
        setCommentCount((state) => state + 1);
    }

    function handleCreateNewComponent(event: FormEvent) {
        event.preventDefault();

        if (userName.trim() === '') {
            // Validar se o nome do usuário está vazio
            alert('Por favor, insira seu nome antes de publicar o comentário.');
            return;
        }

        const newComment = `${userName}: ${newCommentText}`;
        setCommments([...comments, newComment]);
        setNewCommentText('');
    }

    function handleNewCommentChange(event: ChangeEvent<HTMLTextAreaElement>) {
        event.target.setCustomValidity('');
        setNewCommentText(event.target.value);
    }

    function handleUserNameChange(event: ChangeEvent<HTMLInputElement>) {
        setUserName(event.target.value);
    }

    return (
        <div className={styles.post}>
            <div className={styles.infoUser}>
                <img
                    className={styles.imgAvatar}
                    src="https://w7.pngwing.com/pngs/915/511/png-transparent-female-avatar-girl-face-woman-user-flat-classy-users-icon.png"
                    alt=""
                />
                <p>Milena Rizzi</p>
            </div>
            <hr />
            <div className={styles.postContent}>
                <div className={styles.imgContent}>
                    <img
                        src="https://images.unsplash.com/photo-1704972841788-86fac20fc87e?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw1OXx8fGVufDB8fHx8fA%3D%3D"
                        alt=""
                    />
                </div>
            </div>
            <div className={styles.interacaoUsuario}>
                <div className={styles.buttonLike}>
                    <button onClick={handleLikeCount}>
                        <img className={styles.imgFaviconLike} src={faviconHeart} alt="" /> {likeCount} curtidas
                    </button>
                </div>
                <div className={styles.favicon}>
                    <button>
                        <img className={styles.imgFaviconComment} src={faviconComment} alt="" />
                        {commentCount} comentários
                    </button>
                </div>
            </div>

            <form onSubmit={handleCreateNewComponent} className={styles.commentForm}>
                <strong>Comentar:</strong>
                <input
                    type="text"
                    placeholder="Digite nome"
                    value={userName}
                    onChange={handleUserNameChange}
                />
                <textarea
                    name="comment"
                    placeholder="Digite seu comentário"
                    onChange={handleNewCommentChange}
                />

                <footer>
                    <button onClick={handleCommentCount} className={styles.buttonComment} type="submit">
                        Publicar
                    </button>
                </footer>
            </form>

            <div className={styles.commentList}>
                <strong>Comentários <img className={styles.imgFaviconComment} src={faviconComment} alt="" /></strong>
                {comments.map((comment) => (
                    <Comment key={comment} content={comment} />
                ))}
            </div>
        </div>
    );
}
