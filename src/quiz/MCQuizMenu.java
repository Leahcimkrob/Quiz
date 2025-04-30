package quiz;

import java.util.Scanner;

public class MCQuizMenu {
    private static final String DATEINAME = "fragen.json";

    public static void main(String[] args) {
        System.out.println("Aktuelles Verzeichnis: " + System.getProperty("user.dir")); // Speicherort anzeigen

        Scanner scanner = new Scanner(System.in);
        QuizManager quizManager = new QuizManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== MC-Quiz Menü ===");
            System.out.println("1) Neue Frage hinzufügen");
            System.out.println("2) Alle Fragen anzeigen");
            System.out.println("3) Fragen speichern");
            System.out.println("4) Fragen laden");
            System.out.println("5) Beenden");
            System.out.print("Auswahl (1–5): ");

            String auswahl = scanner.nextLine().trim();

            switch (auswahl) {
                case "1":
                    quizManager.neueFrageHinzufuegen(scanner);
                    break;
                case "2":
                    quizManager.alleFragenAnzeigen();
                    break;
                case "3":
                    quizManager.fragenSpeichern(DATEINAME);
                    break;
                case "4":
                    quizManager.fragenLaden(DATEINAME);
                    break;
                case "5":
                    running = false;
                    System.out.println("👋 Programm wird beendet.");
                    break;
                default:
                    System.out.println("⚠️ Ungültige Auswahl! Bitte 1–5 eingeben.");
            }
        }

        scanner.close();
    }
}
