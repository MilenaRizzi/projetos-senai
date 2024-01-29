import { useState } from "react";
import { Button } from "../atoms/Button";
import { Question } from "../molecules/Question";
import { IoIosArrowBack } from "react-icons/io";
import styles from "../../style/Main.module.css";

export function Main() {
    const [currentStep, setCurrentStep] = useState(2);
    const totalSteps = 3;

    const handleNext = () => {
        if (currentStep < totalSteps) {
            setCurrentStep(currentStep + 1);
        }
    };

    const handleBack = () => {
        if (currentStep > 1) {
            setCurrentStep(currentStep - 1);
        }
    };

    const progressPercentage = ((currentStep - 1) / (totalSteps - 1)) * 100;


    return (
        <div className={styles.contentMain}>
        <div className={styles.contentQuestionMain}>
            <Question title={`Question ${currentStep}`} question="What is your estimate skill level?" />
        </div>
      
     
        <div className={styles.buttons}>
            <Button Icon={() => <IoIosArrowBack style={{ fontSize: '24px' }} />} buttonProps={{ onClick: () => handleBack() }} />
            <Button title="Next" buttonProps={{onClick: handleNext}} />
        </div>   
          <div className={styles.progressBar}>
            <div className={styles.progress} style={{ width: `${progressPercentage}%` }}></div>
            <div className={styles.progressText}>
                <p>Step {currentStep} out of {totalSteps} </p>
                <p>{progressPercentage}%</p>
            </div>
        </div>
    </div>
    );
}
