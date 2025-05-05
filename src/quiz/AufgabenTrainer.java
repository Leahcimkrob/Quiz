package quiz;

import java.io.IOException;
import java.util.Scanner;

public class AufgabenTrainer {
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner scanner = new Scanner(System.in);
        String pfad = "fragen.json"; // Pfad zur JSON-Datei

        System.out.println("🎓 Willkommen beim Aufgaben-Trainer!");

        while (true) {
            System.out.println("\n📋 Wähle eine Option:");
            System.out.println("1. Multiple-Choice-Frage");
            System.out.println("2. JavaChecker");
            System.out.println("3. Beenden");
            System.out.print("Deine Auswahl: ");
            String auswahl = scanner.nextLine().trim();

            switch (auswahl) {
                case "1":
                    Aufgabe frage = MultipleChoiceFrage.zufallsfrageAusDatei(pfad);
                    if (frage == null) {
                        System.out.println("⚠️ Keine Frage verfügbar.");
                        break;
                    }
                    frage.stelleFrage();
                    frage.leseAntwort();
                    frage.pruefeAntwort();
                    break;

                case "2":
                    try {
                        // HelloWorldChecker ausführen
                        JavaChecker.main(new String[]{});
                    } catch (Exception e) {
                        System.out.println("❌ Fehler bei der Ausführung des HelloWorldCheckers.");
                        e.printStackTrace();
                    }
                    break;

                case "3":
                    System.out.println("👋 Bis zum nächsten Mal!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Ungültige Auswahl. Bitte versuche es erneut.");
                    break;
            }
        }
    }
}