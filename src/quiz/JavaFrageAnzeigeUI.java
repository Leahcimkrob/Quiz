package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JavaFrageAnzeigeUI extends JPanel {
    private JavaFragenManager fragenManager; // Referenz auf den Fragen-Manager
    private List<JCheckBox> checkBoxList; // Liste aller Checkboxes


    public JavaFrageAnzeigeUI() {
        fragenManager = new JavaFragenManager(); // Initialisiere den Fragen-Manager
        checkBoxList = new ArrayList<>();
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
            JCheckBox checkBox = new JCheckBox(frageDetails[0]); // Checkbox für die Nummer
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

        // Nach dem Hinzufügen von Komponenten die GUI neu validieren
        revalidate();
        repaint();
    }

    public void addNeueFragen() {
        // Wechsel zum Panel für neue Fragen
        switchPanel(new JavaFragenNeuUI());
    }
    
    private void deleteMarkedQuestions() {
        // Iteriere über die CheckBox-Liste und lösche die markierten Fragen
        for (JCheckBox checkBox : checkBoxList) {
            if (checkBox.isSelected()) {
                int nummer = Integer.parseInt(checkBox.getText()); // Nummer aus der Checkbox
                fragenManager.deleteFrage(nummer); // Frage löschen
            }
        }

        // Wechsel zu aktualisierter Fragenübersicht
        switchPanel(new JavaFrageAnzeigeUI());

        // Aktualisierte Daten in JSON speichern
        try {
            fragenManager.writeJsonArray(fragenManager.readJsonArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void switchPanel(JPanel newPanel) {
        // Hole das Hauptfenster (JFrame) des aktuellen Panels
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (topFrame != null) {
            // Entferne nur den zentralen Inhaltsbereich (ohne Menü)
            topFrame.getContentPane().removeAll();

            // Füge das neue Panel hinzu
            topFrame.getContentPane().add(newPanel);

            // Aktualisiere und rendere das Fenster neu
            topFrame.revalidate();
            topFrame.repaint();
        } else {
            System.err.println("Fehler: Kein übergeordnetes Fenster gefunden.");
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

        //---- button2 ----
        button2.setText("Markierte Löschen");
        add(button2, "cell 1 7 2 1,alignx left,growx 0"); // Reduced the gap to 10 pixels on the right

        //---- button3 ----
        button3.setText("Neue hinzufügen");
        add(button3, "cell 1 7 2 1,alignx left,growx 0"); // Reduced the gap to 10 pixels on the left
        // Hinzufügen der Funktionalität für button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMarkedQuestions();
            }            
        });
        
        // ActionListener für Button3
        button3.addActionListener(e -> addNeueFragen());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY
    private JLabel label1;
    private JButton button2;
    private JButton button3;    
    // JFormDesigner - End of variables declaration
}