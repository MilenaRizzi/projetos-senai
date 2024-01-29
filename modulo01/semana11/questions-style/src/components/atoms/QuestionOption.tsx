import styles from "../../style/Main.module.css";

interface QuestionOptionsProps {
    text: string;
    isSelected: boolean;
    onSelect: () => void;
}

export function QuestionOption({ text, isSelected, onSelect }: QuestionOptionsProps) {
    return (
        <div
            className={`${styles.questionOption} ${isSelected ? styles.selectedOption : ''}`}
            onClick={onSelect}
        >
            <img src="src\assets\icon-question.png" alt="" />
            <p>{text}</p>
        </div>
    );
}