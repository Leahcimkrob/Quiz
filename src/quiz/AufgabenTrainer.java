package quiz;

import java.util.Scanner;

public class AufgabenTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pfad = "fragen.json"; // Pfad zur JSON-Datei
        MCFrageBeantworten mcFragenBeantworten = new MCFrageBeantworten();

        System.out.println("📚 Willkommen beim Aufgaben-Trainer!");

        boolean running = true;
		while (running ) {
            System.out.println("Welche Art von Aufgabe möchtest du lösen?");
            System.out.println("1. Multiple-Choice-Frage");
            System.out.println("2. Java-Programm überprüfen");
            System.out.println("3. Fragen bearbeiten starten");
            System.out.println("4. Beenden");
            System.out.print("Bitte wähle (1 - 4): ");

            String wahl = scanner.nextLine().trim();

            switch (wahl) {
                case "1":
                    mcFragenBeantworten.starteAufgabenVerarbeitung(pfad, scanner);
                    continue;
                case "2":
                    Aufgabe javaChecker = new JavaChecker(); // JavaChecker wird verwendet
                    javaChecker.initialiereFrage();
                    javaChecker.stelleFrage();
                    String antwort = javaChecker.leseAntwort(scanner);
                    javaChecker.pruefeAntwort(antwort);
                    continue;
                case "3":
                    MCQuizMenu.main(new String[] {}); // Start MCQuizMenu
                    continue;
                case "4":
                	running = false;
                	System.out.println("👋 Bis zum nächsten Mal!");
                	break;
                default:
                    System.out.println("❌ Ungültige Auswahl. Bitte versuche es erneut.");
                    break;
            }

        }

//        scanner.close();
    }
}