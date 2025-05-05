package quiz;

import java.util.Scanner;

public class MCFrage implements Aufgabe {

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    public MCFrage(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    @Override
    public void initialiereFrage() {
        // Logik zur Initialisierung der Frage
        System.out.println("Die Frage wird initialisiert...");
    }

    @Override
    public void stelleFrage() {
        System.out.println(questionText);
        System.out.println("A) " + optionA);
        System.out.println("B) " + optionB);
        System.out.println("C) " + optionC);
        System.out.println("D) " + optionD);
    }

    @Override
    public String leseAntwort(Scanner scanner) {
        System.out.print("Bitte gib deine Antwort ein (A, B, C, D): ");
        String antwort = scanner.nextLine().trim().toUpperCase();
        return antwort;
    }

    @Override
    public void pruefeAntwort(String antwort) {
        if (antwort.equalsIgnoreCase(correctOption)) {
            System.out.println("✅ Richtig!");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort war: " + correctOption);
        }
    }
}