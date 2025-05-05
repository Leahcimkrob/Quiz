package quiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeseEineMCFrage {
    public static void main(String[] args) {

        // Aus Datei lesen
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fragen.json"))) {
        	MultipleChoiceFrage geleseneFrage = (MultipleChoiceFrage) ois.readObject();
            ois.close();
            
            // Ausgabe der geladenen Frage
            System.out.println("Frage: " + geleseneFrage.getQuestionText());
            System.out.println(geleseneFrage.getOptionA());
            System.out.println(geleseneFrage.getOptionB());
            System.out.println(geleseneFrage.getOptionC());
            System.out.println(geleseneFrage.getOptionD());
            System.out.println("Korrekte Antwort: " + geleseneFrage.getCorrectOption());
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fehler beim Laden: " + e.getMessage());
        }
    }
}
