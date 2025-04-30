package quiz;

import java.util.Scanner;

/**
 * Stellt eine Multiple-Choice-Frage und überprüft die Antwort des Benutzers.
 */
public class MultipleChoiceQuiz {

    /**
     * Hauptmethode, die die Frage stellt, eine Antwort einliest und überprüft.
     *
     * @param args die Konsolenargumente (werden hier nicht verwendet)
     */
    public static void main(String[] args) {
        // Scanner-Objekt erstellen, um Benutzereingaben zu lesen
        Scanner scanner = new Scanner(System.in);

        // Frage und Antwortmöglichkeiten anzeigen
        System.out.println("Was ist die Hauptstadt von Deutschland?");
        System.out.println("A) München");
        System.out.println("B) Berlin");
        System.out.println("C) Hamburg");
        System.out.println("D) Frankfurt");

        // Benutzereingabe abfragen
        System.out.print("Bitte gib deine Antwort ein (A, B, C oder D): ");
        String antwort = scanner.nextLine().trim().toUpperCase();

        // Antwort überprüfen
        if (antwort.equals("B")) {
            System.out.println("✅ Richtig! Berlin ist die Hauptstadt von Deutschland.");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort ist B) Berlin.");
        }

        // Scanner schließen
        scanner.close();
    }
}