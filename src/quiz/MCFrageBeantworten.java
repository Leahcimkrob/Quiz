package quiz;

import java.util.Scanner;

public class MCFrageBeantworten {

    public void starteAufgabenVerarbeitung(String pfad, Scanner scanner) {
        while (true) {
            Aufgabe frage = holeMultipleChoiceFrage(pfad, scanner);
            if (frage == null) {
                return; // Beenden, wenn keine Frage verfügbar ist
            }

            frage.initialiereFrage(); // Initialisierung der Aufgabe
            frage.stelleFrage(); // Aufgabe stellen

            String antwort = frage.leseAntwort(scanner); // Antwort einlesen
            frage.pruefeAntwort(antwort); // Antwort prüfen

            // Fragen, ob der Nutzer eine neue Aufgabe lösen möchte
            System.out.print("\n↩️ Noch eine Aufgabe? (j/n): ");
            String erneut = scanner.nextLine().trim().toLowerCase();
            if (!erneut.equals("j")) {
                System.out.println("-------------------------");
                break;
            }
        }
    }

    private Aufgabe holeMultipleChoiceFrage(String pfad, Scanner scanner) {
        Aufgabe frage = MultipleChoiceFrage.zufallsfrageAusDatei(pfad);
        if (frage == null) {
            System.out.println("⚠️ Keine Frage verfügbar. Beende.");
            return null;
        }
        return frage;
    }
}