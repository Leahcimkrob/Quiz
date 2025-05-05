package quiz;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MCFragenManager {

    private List<MultipleChoiceFrage> fragenListe = new ArrayList<>();

    public void addFrage(MultipleChoiceFrage frage) {
        fragenListe.add(frage);
    }

    public void saveToFile(String dateiname) {
        try (FileWriter writer = new FileWriter(dateiname)) {
            Gson gson = new Gson();
            gson.toJson(fragenListe, writer);
            System.out.println("Fragen wurden gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    public void loadFromFile(String dateiname) {
        try (FileReader reader = new FileReader(dateiname)) {
            Gson gson = new Gson();
            fragenListe = gson.fromJson(reader, new TypeToken<List<MultipleChoiceFrage>>() {}.getType());
            System.out.println("Fragen wurden geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Laden: " + e.getMessage());
        }
    }

    
    
    public void printFragen() {
        for (MultipleChoiceFrage frage : fragenListe) {
            System.out.println(frage.getQuestionText());
            System.out.println("A) " + frage.getOptionA());
            System.out.println("B) " + frage.getOptionB());
            System.out.println("C) " + frage.getOptionC());
            System.out.println("D) " + frage.getOptionD());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MCFragenManager manager = new MCFragenManager();

        // Fragen erstellen und hinzufügen
        manager.addFrage(new MultipleChoiceFrage("Was ist die Hauptstadt von Frankreich?", "Berlin", "Madrid", "Paris", "Rom", "C"));
        manager.addFrage(new MultipleChoiceFrage("Welche Farbe hat der Himmel?", "Blau", "Rot", "Gelb", "Grün", "A"));

        // Fragen speichern
        manager.saveToFile("fragen.json");

        // Neu laden und ausgeben
        manager.loadFromFile("fragen.json");
        manager.printFragen();
    }
    
    
}
