package quiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// POJO Klasse für eine Multiple-Choice Frage
/**
 * 
 */
public class SpeichereEineMCFrage {
    /**
     * @param args
     */
    public static void main(String[] args) {

    	// Initialisiere eine Multiple-Choice Frage
        MCFrage mcQuestion = new MCFrage(
            "Was ist die Hauptstadt von Frankreich?",
            "a) Berlin",
            "b) Madrid",
            "c) Paris",
            "d) Rom",
            "c"
        );

        // In Datei schreiben
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mc_question.ser"))) {
            oos.writeObject(mcQuestion);
            System.out.println("Frage wurde erfolgreich gespeichert.");
            oos.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }
}
