package day0507;

import java.io.Serializable;
import java.util.List;

/**
 * eine MC-Frage inclusive Antwort
 */
public class MCFrage implements Serializable{

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption; // "a", "b", "c" oder "d"

    // Konstruktor
    /**
     * @param questionText
     * @param optionA
     * @param optionB
     * @param optionC
     * @param optionD
     * @param correctOption
     */
    public MCFrage(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption.toLowerCase(); // Normalisieren
        if (!List.of("a", "b", "c", "d").contains(correctOption.toLowerCase())) {
            throw new IllegalArgumentException("Correct option must be one of: a, b, c, d");
        }

    }

    // Getter-Methoden
    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    // Hilfsmethode zur Antwortüberprüfung
    public boolean isCorrect(String userAnswer) {
        return correctOption.equalsIgnoreCase(userAnswer);
    }
}