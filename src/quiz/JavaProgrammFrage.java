package quiz;

import java.util.Scanner;

/**
 * Repräsentiert eine Java-Programmieraufgabe.
 */
public class JavaProgrammFrage implements Aufgabe {

    private static final long serialVersionUID = 1L;

    private String aufgabenstellung;
    private String erwarteterCodeauszug;
    private transient String benutzerEingabe;
    private transient Scanner scanner = new Scanner(System.in);

    public JavaProgrammFrage(String aufgabenstellung, String erwarteterCodeauszug) {
        this.aufgabenstellung = aufgabenstellung;
        this.erwarteterCodeauszug = erwarteterCodeauszug;
    }

    @Override
    public void stelleFrage() {
        System.out.println(aufgabenstellung);
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
        if (benutzerEingabe != null && benutzerEingabe.contains(erwarteterCodeauszug)) {
            System.out.println("✅ Richtiger Programmcode gefunden!");
        } else {
            System.out.println("❌ Fehler: Erwarteter Code wurde nicht gefunden.");
        }
    }
}