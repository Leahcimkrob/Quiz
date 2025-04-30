package quiz;

import java.util.Scanner;

/**
 * Java-Programm-Aufgabe, die das Aufgabe-Interface implementiert.
 */
public class JavaProgrammFrage implements Aufgabe {

    private String benutzerEingabe;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void stelleFrage() {
        System.out.println("Schreibe ein Programm, das 'Hello World' ausgibt:");
    }

    @Override
    public void leseAntwort() {
        System.out.println("Bitte gib deinen Programmcode ein (Ende mit Leerzeile):");
        StringBuilder code = new StringBuilder();
        String zeile;
        while (!(zeile = scanner.nextLine()).isEmpty()) {
            code.append(zeile).append(System.lineSeparator());
        }
        benutzerEingabe = code.toString();
    }

    @Override
    public void pruefeAntwort() {
        if (benutzerEingabe.contains("System.out.println('Hello World')")) {
            System.out.println("✅ Richtige Ausgabe im Programm gefunden!");
        } else {
            System.out.println("❌ Fehler: 'Hello World' wurde nicht korrekt ausgegeben.");
        }
    }
}
