package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.GsonBuilder;

/**
 * Verwalten mehrerer Aufgaben und Speichern im Dateisystem als JSON.
 */
public class AufgabenVerwalter {

    private List<Aufgabe> aufgaben = new ArrayList<>();

    public void fuegeAufgabeHinzu(Aufgabe aufgabe) {
        aufgaben.add(aufgabe);
    }

    public void speichereAufgabenAlsJson(String dateiname) throws IOException {
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(aufgaben);
        java.nio.file.Files.writeString(java.nio.file.Paths.get(dateiname), json);
    }

    public static void main(String[] args) throws IOException {
        AufgabenVerwalter verwalter = new AufgabenVerwalter();

        verwalter.fuegeAufgabeHinzu(new MultipleChoiceFrage(
            "Was ist die Hauptstadt von Deutschland?",
            new String[]{"München", "Berlin", "Hamburg", "Frankfurt"},
            "Berlin"
        ));

        verwalter.fuegeAufgabeHinzu(new JavaProgrammFrage(
            "Schreibe ein Java-Programm, das 'Hello World' ausgibt.",
            "System.out.println('Hello World')"
        ));

        verwalter.speichereAufgabenAlsJson("aufgaben.json");

        System.out.println("Aufgaben wurden erfolgreich gespeichert!");
    }
}