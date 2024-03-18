import styles from "./Comments.module.css";

interface CommentProps {
  content: string;
}

export function Comment({ content }: CommentProps) {
  return (
    <div className={styles.comment}>
      <div className={styles.commentContent}>
        <div className={styles.contentDiv}>
          <p>{content}</p>
        </div>
      </div>
    </div>
  );
}
