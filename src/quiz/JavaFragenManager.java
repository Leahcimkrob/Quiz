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

public class JavaFragenManager implements Aufgabe {
    private final String jsonFilePath = "javaaufgabe.json";
    private Gson gson;

    public JavaFragenManager() {
        gson = new Gson();
    }

    // Methode zum Hinzufügen einer neuen Frage und Antwort mit automatischer Nummer
    public void addFrage(String frage, String antwort) {
        try {
            JsonArray jsonArray = readJsonArray();
            int neueNummer = getNextNummer(jsonArray); // Automatische Nummer berechnen
            JsonObject newTask = new JsonObject();
            JsonObject taskDetails = new JsonObject();
            taskDetails.addProperty("Frage", frage);
            taskDetails.addProperty("Antwort", antwort);
            newTask.add(String.valueOf(neueNummer), taskDetails);
            jsonArray.add(newTask);
            writeJsonArray(jsonArray);
            System.out.println("Frage erfolgreich hinzugefügt: Nummer " + neueNummer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode zum Korrigieren von Fragen und Antworten
    public void updateFrage(int nummer, String neueFrage, String neueAntwort) {
        try {
            JsonArray jsonArray = readJsonArray();
            boolean updated = false;
            for (JsonElement element : jsonArray) {
                JsonObject task = element.getAsJsonObject();
                if (task.has(String.valueOf(nummer))) {
                    JsonObject taskDetails = task.getAsJsonObject(String.valueOf(nummer));
                    taskDetails.addProperty("Frage", neueFrage);
                    taskDetails.addProperty("Antwort", neueAntwort);
                    updated = true;
                    break;
                }
            }
            if (updated) {
                writeJsonArray(jsonArray);
                System.out.println("Frage erfolgreich aktualisiert: Nummer " + nummer);
            } else {
                System.out.println("Aufgabe mit der Nummer " + nummer + " nicht gefunden.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 // Methode zum Löschen einer Frage mit Neunummerierung
    public void deleteFrage(int nummer) {
        try {
            JsonArray jsonArray = readJsonArray();
            JsonArray updatedArray = new JsonArray();
            boolean deleted = false;

            // Lösche die Frage mit der angegebenen Nummer
            for (JsonElement element : jsonArray) {
                JsonObject task = element.getAsJsonObject();
                if (!task.has(String.valueOf(nummer))) {
                    updatedArray.add(task);
                } else {
                    deleted = true;
                }
            }

            if (deleted) {
                // Schreibe das aktualisierte Array in die Datei
                writeJsonArray(updatedArray);
                System.out.println("Frage " + nummer + " erfolgreich gelöscht und Nummern neu zugewiesen.");
            } else {
                System.out.println("Aufgabe mit der Nummer " + nummer + " nicht gefunden.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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