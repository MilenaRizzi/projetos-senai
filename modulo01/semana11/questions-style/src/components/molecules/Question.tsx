import { useState } from "react";
import styles from "../../style/Main.module.css";
import { QuestionOption } from "../atoms/QuestionOption";

interface QuestionProps {
    title: string;
    question: string;
}

export function Question({ title, question }: QuestionProps) {
    const [selectedOption, setSelectedOption] = useState<string | null>(null);

    const handleOptionSelect = (option: string) => {
        setSelectedOption(option === selectedOption ? null : option);
    };

    return (
        <div className={styles.questionConteiner}>
            <h1>{title}</h1>
            <p>{question}</p>
            <div className={styles.questionsArea}>
                <QuestionOption
                    text="Beginner"
                    isSelected={selectedOption === 'Beginner'}
                    onSelect={() => handleOptionSelect('Beginner')}
                />
                <QuestionOption
                    text="Experienced"
                    isSelected={selectedOption === 'Experienced'}
                    onSelect={() => handleOptionSelect('Experienced')}
                />
                <QuestionOption
                    text="Professional"
                    isSelected={selectedOption === 'Professional'}
                    onSelect={() => handleOptionSelect('Professional')}
                />
            </div>
        </div>
    );
}