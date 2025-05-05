package quiz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizManager {
    private List<MultipleChoiceFrage> fragenListe = new ArrayList<>();

    public void neueFrageHinzufuegen(Scanner scanner) {
        try {
            System.out.print("Fragentext: ");
            String frageText = scanner.nextLine().trim();
            if (frageText.isEmpty()) throw new IllegalArgumentException("Fragetext darf nicht leer sein.");

            System.out.print("Antwort a): ");
            String a = scanner.nextLine().trim();
            System.out.print("Antwort b): ");
            String b = scanner.nextLine().trim();
            System.out.print("Antwort c): ");
            String c = scanner.nextLine().trim();
            System.out.print("Antwort d): ");
            String d = scanner.nextLine().trim();

            System.out.print("Korrekte Antwort (a/b/c/d): ");
            String korrekt = scanner.nextLine().trim().toLowerCase();
            if (!List.of("a", "b", "c", "d").contains(korrekt)) {
                throw new IllegalArgumentException("Ungültige Eingabe! Nur a, b, c oder d erlaubt.");
            }

            MultipleChoiceFrage frage = new MultipleChoiceFrage(frageText, a, b, c, d, korrekt);
            fragenListe.add(frage);
            System.out.println("✅ Frage erfolgreich hinzugefügt.");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Eingabefehler: " + e.getMessage());
        }
    }

    public void alleFragenAnzeigen() {
        if (fragenListe.isEmpty()) {
            System.out.println("⚠️ Keine Fragen vorhanden.");
            return;
        }

        System.out.println("\n📋 Alle Fragen:");
        for (int i = 0; i < fragenListe.size(); i++) {
        	MultipleChoiceFrage frage = fragenListe.get(i);
            System.out.println("Frage " + (i + 1) + ": " + frage.getQuestionText());
            System.out.println("a) " + frage.getOptionA());
            System.out.println("b) " + frage.getOptionB());
            System.out.println("c) " + frage.getOptionC());
            System.out.println("d) " + frage.getOptionD());
            System.out.println("✔ Richtige Antwort: " + frage.getCorrectOption() + "\n");
        }
    }

    public void fragenSpeichern(String dateiname) {
        try (Writer writer = new FileWriter(dateiname)) {
            Gson gson = new GsonBuilder()
                           .setPrettyPrinting()   // ← hier die Formatierung anwerfen
                           .create();
            gson.toJson(fragenListe, writer);
            System.out.println("✅ Aufgaben wurden als schön formatierten JSON gespeichert.");
        } catch (IOException e) {
            System.out.println("⚠️ Fehler: " + e.getMessage());
        }
    }    

    public void fragenLaden(String dateiname) {
        try (Reader reader = new FileReader(dateiname)) {
            Gson gson = new Gson();
            fragenListe = gson.fromJson(reader, new TypeToken<List<MultipleChoiceFrage>>() {}.getType());
            if (fragenListe == null) fragenListe = new ArrayList<>();
            System.out.println("✅ Fragen wurden aus JSON geladen.");
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Datei nicht gefunden: " + dateiname);
        } catch (IOException e) {
            System.out.println("⚠️ Fehler beim Laden: " + e.getMessage());
        }
    }
}
