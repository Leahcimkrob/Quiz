package quiz;

import java.util.Scanner;

/**
 * Multiple-Choice-Aufgabe, die das Aufgabe-Interface implementiert.
 */
public class MultipleChoiceFrage implements Aufgabe {

    private String richtigeAntwort;
    private String benutzerAntwort;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void stelleFrage() {
        System.out.println("Was ist die Hauptstadt von Deutschland?");
        System.out.println("A) München");
        System.out.println("B) Berlin");
        System.out.println("C) Hamburg");
        System.out.println("D) Frankfurt");
        richtigeAntwort = "B";
    }

    @Override
    public void leseAntwort() {
        System.out.print("Bitte gib deine Antwort ein (A, B, C oder D): ");
        benutzerAntwort = scanner.nextLine().trim().toUpperCase();
    }

    @Override
    public void pruefeAntwort() {
        if (benutzerAntwort.equals(richtigeAntwort)) {
            System.out.println("✅ Richtig!");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort ist B) Berlin.");
        }
    }
}