package quiz;

import java.util.Scanner;

/**
 * Repräsentiert eine Multiple-Choice-Aufgabe.
 */
public class MultipleChoiceFrage implements Aufgabe {

    private String frage;
    private String[] antworten;
    private String richtigeAntwort;
    private transient String benutzerAntwort; // Wird nicht in JSON gespeichert
    private transient Scanner scanner = new Scanner(System.in);

    public MultipleChoiceFrage(String frage, String[] antworten, String richtigeAntwort) {
        this.frage = frage;
        this.antworten = antworten;
        this.richtigeAntwort = richtigeAntwort;
    }

    @Override
    public void stelleFrage() {
        System.out.println(frage);
        char option = 'A';
        for (String antwort : antworten) {
            System.out.println(option++ + ") " + antwort);
        }
    }

    @Override
    public void leseAntwort() {
        System.out.print("Bitte gib deine Antwort ein (A, B, C, D): ");
        benutzerAntwort = scanner.nextLine().trim().toUpperCase();
    }

    @Override
    public void pruefeAntwort() {
        int index = benutzerAntwort.charAt(0) - 'A';
        if (index >= 0 && index < antworten.length && antworten[index].equals(richtigeAntwort)) {
            System.out.println("✅ Richtig!");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort war: " + richtigeAntwort);
        }
    }
}