package quiz;

import java.util.Scanner;

public class AufgabenTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pfad = "fragen.json"; // Pfad zur JSON-Datei

        System.out.println("🎓 Willkommen beim Aufgaben-Trainer!");

        while (true) {
            Aufgabe frage = MultipleChoiceFrage.zufallsfrageAusDatei(pfad);
            if (frage == null) {
                System.out.println("⚠️ Keine Frage verfügbar. Beende.");
                break;
            }

            frage.stelleFrage();
            frage.leseAntwort();
            frage.pruefeAntwort();

            System.out.print("\n↩️ Noch eine Frage? (j/n): ");
            String antwort = scanner.nextLine().trim().toLowerCase();
            if (!antwort.equals("j")) {
                System.out.println("👋 Bis zum nächsten Mal!");
                break;
            }
        }

        scanner.close();
    }
}
