package quiz;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MultipleChoiceFrage implements Aufgabe {

    private String questionText;  // Entspricht "questionText" in der JSON-Datei
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;  // Entspricht "correctOption" in der JSON-Datei

    // Standardkonstruktor
    public MultipleChoiceFrage() {}

    // Konstruktor, um eine Frage mit ihren Optionen zu erstellen
    public MultipleChoiceFrage(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    @Override
    public void initialiereFrage() {
        // Keine spezielle Initialisierung für Multiple-Choice-Fragen notwendig
    }

    @Override
    public void stelleFrage() {
        // Ausgabe der Frage
        System.out.println("\n" + questionText);
        System.out.println("A) " + optionA);
        System.out.println("B) " + optionB);
        System.out.println("C) " + optionC);
        System.out.println("D) " + optionD);
    }

    @Override
    public String leseAntwort(Scanner scanner) {
        // Antwort einlesen
        System.out.print("Bitte gib deine Antwort ein (A, B, C, D): ");
        String antwort = scanner.nextLine().trim().toUpperCase();
        System.out.println("Du hast Antwort: " + antwort + " eingegeben.");
        return antwort;
    }

    @Override
    public void pruefeAntwort(String antwort) {
        // Antwort vergleichen
        if (antwort.equalsIgnoreCase(correctOption)) {
            System.out.println("✅ Richtig!");
        } else {
            System.out.println("❌ Falsch. Die richtige Antwort war: " + correctOption);
        }
    }

    public static MultipleChoiceFrage zufallsfrageAusDatei(String dateipfad) {
        try (FileReader reader = new FileReader(dateipfad)) {
            Gson gson = new Gson();
            List<MultipleChoiceFrage> fragen = gson.fromJson(reader, new TypeToken<List<MultipleChoiceFrage>>() {}.getType());

            if (fragen == null || fragen.isEmpty()) {
                System.out.println("⚠️ Keine Fragen in Datei gefunden.");
                return null;
            }

            // Zufällige Frage aus der Liste auswählen
            return fragen.get(new Random().nextInt(fragen.size()));
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Lesen der Datei: " + e.getMessage());
            return null;
        }
    }
    
    public String getQuestionText() { 
    	return questionText; 
    }
    public String getOptionA() { 
    	return optionA; 
    	}
    public String getOptionB() {
    	return optionB; 
    	}
    public String getOptionC() { 
    	return optionC; 
    	}
    public String getOptionD() { 
    	return optionD; 
    	}
    public String getCorrectOption() { 
    	return correctOption;
    	}

	@Override
	public void initialisiereNummer() {
		// TODO Auto-generated method stub
		
	}

}