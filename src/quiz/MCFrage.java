package quiz;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * Eine MC-Frage inklusive Antwort.
 */
public class MCFrage implements Serializable, Aufgabe {
    private static final long serialVersionUID = -6992908664993915800L;

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption; // "a", "b", "c" oder "d"
    private String userAntwort;   // Eingabe des Benutzers

    // Konstruktor
    public MCFrage(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption.toLowerCase(); // Normalisieren
        if (!List.of("a", "b", "c", "d").contains(this.correctOption)) {
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

    public boolean isCorrect(String userAnswer) {
        return correctOption.equalsIgnoreCase(userAnswer);
    }

    // Implementierung des Interface Aufgabe
    @Override
    public void stelleFrage() {
        System.out.println(questionText);
        System.out.println("a) " + optionA);
        System.out.println("b) " + optionB);
        System.out.println("c) " + optionC);
        System.out.println("d) " + optionD);
    }

    @Override
    public void leseAntwort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deine Antwort (a/b/c/d): ");
        userAntwort = scanner.nextLine().trim().toLowerCase();
    }

    @Override
    public void pruefeAntwort() {
        if (isCorrect(userAntwort)) {
            System.out.println("✅ Richtig!");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort ist: " + correctOption);
        }
    }
}
