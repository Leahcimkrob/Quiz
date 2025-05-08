package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.util.List;

public class JavaFrageAnzeigeUI extends JPanel {
    private JavaFragenManager fragenManager; // Referenz auf den Fragen-Manager

    public JavaFrageAnzeigeUI() {
        fragenManager = new JavaFragenManager(); // Initialisiere den Fragen-Manager
        initComponents();
        initAufgabe(); // Dynamische Zeilen basierend auf den Daten erstellen
    }

    private void initAufgabe() {
        // Rufe die Methode getAlleFragenUndAntworten auf, um die Daten zu erhalten
        List<String[]> fragenListe = fragenManager.getAlleFragenUndAntworten();

        for (String[] frageDetails : fragenListe) {
            // Für jede Nummer, Frage und Antwort eine Zeile erstellen
            JCheckBox checkBox = new JCheckBox(frageDetails[0]); // Checkbox für die Nummer
            JTextField textFieldFrage = new JTextField(frageDetails[1]); // Textfeld für die Frage
            JTextField textFieldAntwort = new JTextField(frageDetails[2]); // Textfeld für die Antwort

            // Setze feste Breite für die Textfelder
            textFieldFrage.setColumns(30);
            textFieldAntwort.setColumns(15);

            // Dynamisch die Komponenten zur GUI hinzufügen
            add(checkBox, "cell 0 " + (getComponentCount() / 3 + 1) + ",alignx left"); // Spalte 0
            add(textFieldFrage, "cell 1 " + (getComponentCount() / 3 + 1) + ",growx"); // Spalte 1
            add(textFieldAntwort, "cell 2 " + (getComponentCount() / 3 + 1) + ",growx"); // Spalte 2
        }

        // Nach dem Hinzufügen von Komponenten die GUI neu validieren
        revalidate();
        repaint();
    }

    private void initComponents() {
        // Komponenten-Initialisierung
        setLayout(new MigLayout(
            "hidemode 3",
            // Spalten
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]",
            // Zeilen
            "[]15[]" // Fügt Abstand zwischen den Zeilen ein
        ));

        // Überschrift hinzufügen
        JLabel label1 = new JLabel("Fragenübersicht");
        add(label1, "cell 0 0 3 1,alignx center");

    }
}