package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaFrageAnzeigeUI extends JPanel {
    private JavaFragenManager fragenManager; // Referenz auf den Fragen-Manager
    private List<JCheckBox> checkBoxList; // Liste aller Checkboxes
    private Map<Integer, String> nummerZuFrageMap; // Map zur Verknüpfung von Zeilennummer und ursprünglicher Nummer

    public JavaFrageAnzeigeUI() {
        fragenManager = new JavaFragenManager(); // Initialisiere den Fragen-Manager
        checkBoxList = new ArrayList<>();
        nummerZuFrageMap = new HashMap<>();
        initComponents();
        initAufgabe(); // Dynamische Zeilen basierend auf den Daten erstellen
    }

    private void initAufgabe() {
        // Rufe die Methode getAlleFragenUndAntworten auf, um die Daten zu erhalten
        List<String[]> fragenListe = fragenManager.getAlleFragenUndAntworten();
        int zeile = 1;
        for (String[] frageDetails : fragenListe) {
            // Für jede Nummer, Frage und Antwort eine Zeile erstellen
            JButton button = new JButton("Bearb.");

            // Checkbox mit durchgehender Nummerierung basierend auf der Zeile
            JCheckBox checkBox = new JCheckBox(String.valueOf(zeile));
            nummerZuFrageMap.put(zeile, frageDetails[0]); // Speichere ursprüngliche Nummer mit Zeilennummer

            JTextField textFieldFrage = new JTextField(frageDetails[1]); // Textfeld für die Frage
            JTextField textFieldAntwort = new JTextField(frageDetails[2]); // Textfeld für die Antwort

            // Dynamisch die Komponenten zur GUI hinzufügen
            add(button, "cell 0 " + (zeile) + ",alignx left"); // Spalte 0
            add(checkBox, "cell 1 " + (zeile) + ",alignx left"); // Spalte 1
            add(textFieldFrage, "cell 2 " + (zeile) + ",growx"); // Spalte 2
            add(textFieldAntwort, "cell 3 " + (zeile) + ",growx"); // Spalte 3

            // Füge die Checkbox zur Liste hinzu
            checkBoxList.add(checkBox);

            zeile++;
        }

        // Buttons hinzufügen
        button2.setText("Markierte Löschen");
        add(button2, "cell 1 " + (zeile + 2) + " 2 1,alignx left,growx 0");

        button3.setText("Neue hinzufügen");
        add(button3, "cell 1 " + (zeile + 2) + " 2 1,alignx left,growx 0");

        // Nach dem Hinzufügen von Komponenten die GUI neu validieren
        revalidate();
        repaint();
    }

    public void addNeueFragen() {
        // Hole das Hauptfenster (JFrame) des aktuellen Panels
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (topFrame != null) {
            // Entferne alle bestehenden Inhalte des Fensters
            topFrame.getContentPane().removeAll();

            // Erstelle ein neues JavaFragenNeuUI-Panel
            JavaFragenNeuUI javaFragenNeuUI = new JavaFragenNeuUI();

            // Füge das neue Panel zum Fenster hinzu
            topFrame.getContentPane().add(javaFragenNeuUI);

            // Aktualisiere und rendere das Fenster neu
            topFrame.revalidate();
            topFrame.repaint();
        } else {
            System.err.println("Fehler: Kein übergeordnetes Fenster gefunden.");
        }
    }    
    
    private void deleteMarkedQuestions() {
        // Iteriere über die CheckBox-Liste und lösche die markierten Fragen
        List<JCheckBox> toRemove = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxList) {
            if (checkBox.isSelected()) {
                int zeilennummer = Integer.parseInt(checkBox.getText()); // Zeilennummer aus Checkbox
                String originalNummer = nummerZuFrageMap.get(zeilennummer); // Ursprüngliche Nummer abrufen
                fragenManager.deleteFrage(Integer.parseInt(originalNummer)); // Frage löschen
                toRemove.add(checkBox); // Checkbox zur Entfernungs-Liste hinzufügen
            }
        }

        // Entferne die gelöschten Checkboxen aus der Liste
        checkBoxList.removeAll(toRemove);

        // GUI neu laden, um Änderungen anzuzeigen
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (topFrame != null) {
            // Entferne alle bestehenden Inhalte des Fensters
            topFrame.getContentPane().removeAll();

            // Erstelle ein neues JavaFrageAnzeigeUI-Panel
            JavaFrageAnzeigeUI javaFrageAnzeigeUI = new JavaFrageAnzeigeUI();

            // Füge das neue Panel zum Fenster hinzu
            topFrame.getContentPane().add(javaFrageAnzeigeUI);

            // Aktualisiere und rendere das Fenster neu
            topFrame.revalidate();
            topFrame.repaint();
        } else {
            System.err.println("Fehler: Kein übergeordnetes Fenster gefunden.");
        }

        // Aktualisierte Daten in JSON speichern
        try {
            fragenManager.writeJsonArray(fragenManager.readJsonArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        label1 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder("Fragenübersicht"),
                getBorder()));
        setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[13,fill]" +
                "[100:41:41,fill]" +
                "[194:258,grow,fill]" +
                "[100:230:100,grow,fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

        //---- label1 ----
        label1.setText("Fragenübersicht");
        add(label1, "cell 0 0 4 1,alignx center,growx 0");

        button2.addActionListener(e -> deleteMarkedQuestions());

        // ActionListener für Button3
        button3.addActionListener(e -> addNeueFragen());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY
    private JLabel label1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration
}