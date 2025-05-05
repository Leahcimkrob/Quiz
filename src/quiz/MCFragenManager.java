package quiz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//Manager-Klasse zum Speichern und Laden mehrerer Fragen
public class MCFragenManager {
	private List<MCFrage> fragenListe = new ArrayList<>();

	public void addFrage(MCFrage frage) {
		fragenListe.add(frage);
	}

	public void saveToFile(String dateiname) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname))) {
			oos.writeObject(fragenListe);
			System.out.println("Fragen wurden gespeichert.");
		} catch (IOException e) {
			System.out.println("Fehler beim Speichern: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void loadFromFile(String dateiname) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname))) {
			fragenListe = (List<MCFrage>) ois.readObject();
			System.out.println("Fragen wurden geladen.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fehler beim Laden: " + e.getMessage());
		}
	}

	public void printFragen() {
		for (MCFrage frage : fragenListe) {
			System.out.println(frage.getQuestionText());
			System.out.println(frage.getOptionA());
			System.out.println(frage.getOptionB());
			System.out.println(frage.getOptionC());
			System.out.println(frage.getOptionD());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MCFragenManager manager = new MCFragenManager();

		// Fragen erstellen und hinzufügen
		manager.addFrage(new MCFrage("Was ist die Hauptstadt von Frankreich?", "a) Berlin", "b) Madrid", "c) Paris",
				"d) Rom", "c"));
		manager.addFrage(new MCFrage("Welche Farbe hat der Himmel?", "a) Blau", "b) Rot", "c) Gelb", "d) Grün", "a"));

		// Fragen speichern
		manager.saveToFile("fragen.ser");

		// Neu laden und ausgeben
		manager.loadFromFile("fragen.ser");
		manager.printFragen();
	}
}