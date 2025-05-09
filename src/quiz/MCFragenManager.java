package quiz;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MCFragenManager implements Aufgabe {
    private final String jsonFilePath = "mcaufgabe.json";
    private Gson gson;

    public MCFragenManager() {
        gson = new Gson();
    }
    
        public String[] viewFrage(int nummer) throws IOException {
            JsonArray jsonArray = readJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject task = element.getAsJsonObject();
                if (task.has(String.valueOf(nummer))) {
                    JsonObject frageDetails = task.getAsJsonObject(String.valueOf(nummer));

                    String frage = frageDetails.get("Frage").getAsString();
                    String antwortenString = frageDetails.get("Antworten").getAsString();
                    List<String> antworten = List.of(antwortenString.split(","));
                    String loesung = frageDetails.get("Loesung").getAsString();

                    String[] frageUndAntworten = new String[antworten.size() + 2];
                    frageUndAntworten[0] = frage; // Frage als erstes Element
                    for (int i = 0; i < antworten.size(); i++) {
                        frageUndAntworten[i + 1] = antworten.get(i); // Antworten folgen
                    }
                    frageUndAntworten[frageUndAntworten.length - 1] = loesung; // Lösung als letztes Element

                    return frageUndAntworten;
                }
            }
            throw new IOException("Frage mit der Nummer " + nummer + " wurde nicht gefunden.");
        }
    


    // Methode zum Hinzufügen einer neuen Frage und Antwort mit automatischer Nummer
    public void addFrage(String frage, String antwort, String loesung) {

    }

    // Methode zum Korrigieren von Fragen und Antworten
    public void updateFrage(int nummer, String neueFrage, String neueAntwort, String loesung) {

    }

 // Methode zum Löschen einer Frage mit Neunummerierung
    public void deleteFrage(int nummer) {

    }


    // Methode zum Ermitteln der nächsten freien Nummer
    private int getNextNummer(JsonArray jsonArray) {
        int maxNummer = 0;
        for (JsonElement element : jsonArray) {
            JsonObject task = element.getAsJsonObject();
            for (String key : task.keySet()) {
                int nummer = Integer.parseInt(key);
                if (nummer > maxNummer) {
                    maxNummer = nummer;
                }
            }
        }
        return maxNummer + 1; // Nächste Nummer ist die höchste Nummer + 1
    }

    // Hilfsmethode zum Lesen des JSON-Arrays
    JsonArray readJsonArray() throws IOException {
        FileReader reader = new FileReader(jsonFilePath);
        JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
        reader.close();
        return jsonArray != null ? jsonArray : new JsonArray(); // Falls die Datei leer ist, ein neues Array zurückgeben
    }
    // Hilfsmethode zum Schreiben des JSON-Arrays in die Datei
    void writeJsonArray(JsonArray jsonArray) throws IOException {
        FileWriter writer = new FileWriter(jsonFilePath);
        // Formatierung sicherstellen
        Gson prettyGson = new Gson().newBuilder().setPrettyPrinting().create();
        prettyGson.toJson(jsonArray, writer);

        writer.flush();
        writer.close();
    }

    // Methode zum Abrufen aller Nummern, Fragen und Antworten
    public List<String[]> getAlleFragenUndAntworten() {
        List<String[]> fragenListe = new ArrayList<>();
        try {
            JsonArray jsonArray = readJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject task = element.getAsJsonObject();
                for (String key : task.keySet()) {
                    JsonObject taskDetails = task.getAsJsonObject(key);
                    String frage = taskDetails.get("Frage").getAsString();
                    String antwort = taskDetails.get("Antwort").getAsString();
                    String loesung = taskDetails.get("loesung").getAsString();
                    fragenListe.add(new String[]{key, frage, antwort});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fragenListe;
    }

    @Override
    public void initialisiereNummer() {
        // Diese Methode ist für die Schnittstelle erforderlich, wird hier jedoch nicht genutzt.
    }

    @Override
    public void initialiereFrage() {
        // Diese Methode ist für die Schnittstelle erforderlich, wird hier jedoch nicht genutzt.
    }

    @Override
    public void stelleFrage() {
        // Diese Methode ist für die Schnittstelle erforderlich, wird hier jedoch nicht genutzt.
    }

    @Override
    public String leseAntwort(java.util.Scanner scanner) {
        return null; // Diese Methode ist für die Schnittstelle erforderlich, wird hier jedoch nicht genutzt.
    }

    @Override
    public void pruefeAntwort(String antwort) {
        // Diese Methode ist für die Schnittstelle erforderlich, wird hier jedoch nicht genutzt.
    }
}