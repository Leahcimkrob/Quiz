package quiz;

import java.util.Scanner;

public class AufgabenTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pfad = "fragen.json"; // Pfad zur JSON-Datei

        System.out.println("📚 Willkommen beim Aufgaben-Trainer!");

        while (true) {
            System.out.println("Welche Art von Aufgabe möchtest du lösen?");
            System.out.println("1. Multiple-Choice-Frage");
            System.out.println("2. Java-Programm überprüfen");
            System.out.println("3. Fragen bearbeiten starten");
            System.out.print("Bitte wähle (1 - 3): ");

            String wahl = scanner.nextLine().trim();

            Aufgabe frage = null; // Standardinitialisierung der Variable

            switch (wahl) {
                case "1":
                    frage = MultipleChoiceFrage.zufallsfrageAusDatei(pfad);
                    if (frage == null) {
                        System.out.println("⚠️ Keine Frage verfügbar. Beende.");
                        scanner.close();
                        return;
                    }
                    break;
                case "2":
                    frage = new JavaChecker(); // JavaChecker wird verwendet
                    break;
                case "3":
                    MCQuizMenu.main(new String[] {}); // Start MCQuizMenu
                    continue; // Zurück zum Hauptmenü nach Schließen
                default:
                    System.out.println("❌ Ungültige Auswahl. Bitte versuche es erneut.");
                    continue;
            }

            // Sicherstellen, dass frage nicht null ist, bevor sie verwendet wird
            if (frage != null) {
                frage.initialiereFrage(); // Initialisierung der Aufgabe
                frage.stelleFrage(); // Aufgabe stellen

                String antwort = frage.leseAntwort(scanner); // Antwort einlesen
                frage.pruefeAntwort(antwort); // Antwort prüfen
            }

            System.out.print("\n↩️ Noch eine Aufgabe? (j/n): ");
            String erneut = scanner.nextLine().trim().toLowerCase();
            if (!erneut.equals("j")) {
                System.out.println("👋 Bis zum nächsten Mal!");
                break;
            }
        }

        scanner.close();
    }
}