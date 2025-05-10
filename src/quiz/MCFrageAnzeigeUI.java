/*
 * Created by JFormDesigner on Sat May 10 14:16:00 CEST 2025
 */

package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Michael
 */
public class MCFrageAnzeigeUI extends JPanel {
	private JPanel mainJPanel = AufgabenTrainerUI.contentPanel;
    private MCFragenManager fragenManager; // Referenz auf den Fragen-Manager
    private List<JCheckBox> checkBoxList; // Liste aller Checkboxes
    private Map<Integer, String> nummerZuFrageMap; // Map zur Verknüpfung von Zeilennummer und ursprünglicher Nummer

    public MCFrageAnzeigeUI() {
        fragenManager = new MCFragenManager(); // Initialisiere den Fragen-Manager
        checkBoxList = new ArrayList<>();
        nummerZuFrageMap = new HashMap<>();
        initComponents();
        initAufgabe(); // Dynamische Zeilen basierend auf den Daten erstellen
    }
    
    public void showPanel(JPanel panel) {
        mainJPanel.removeAll();
        mainJPanel.add(panel);
        mainJPanel.revalidate();
        mainJPanel.repaint();
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
            System.out.println(textFieldAntwort);
            // Dynamisch die Komponenten zur GUI hinzufügen
            add(button, "cell 0 " + (zeile) + ",alignx left"); // Spalte 0
            add(checkBox, "cell 1 " + (zeile) + ",alignx left"); // Spalte 1
            add(textFieldFrage, "cell 2 " + (zeile) + ",growx"); // Spalte 2
//            add(textFieldAntwort.setText(textFieldAntwort[1]), "cell 3 " + (zeile) + ",growx"); // Spalte 3
//            add(textFieldAntwort.setText(textFieldAntwort[1], "cell 4 " + (zeile) + ",growx"); // Spalte 4
//            add(textFieldAntwort.setText(textFieldAntwort[1], "cell 5 " + (zeile) + ",growx"); // Spalte 5
//            add(textFieldAntwort.setText(textFieldAntwort[1], "cell 6 " + (zeile) + ",growx"); // Spalte 6

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

        JavaFragenNeuUI javaFragenNeuUI = new JavaFragenNeuUI();
        showPanel(javaFragenNeuUI);
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
    JavaFrageAnzeigeUI javaFrageAnzeigeUI = new JavaFrageAnzeigeUI();
    showPanel(javaFrageAnzeigeUI);
    // Aktualisierte Daten in JSON speichern
    try {
        fragenManager.writeJsonArray(fragenManager.readJsonArray());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
        label1 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();

		//======== this ========
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
		swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border
		.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
		,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
		())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
		.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
		();}});
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[13,fill]" +
			"[100:41:41,fill]" +
			"[194:224,grow,fill]" +
			"[fill]" +
			"[fill]" +
			"[72,fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Fragen\u00fcbersicht");
		add(label1, "cell 0 0 7 1,alignx center,growx 0");

		//---- label2 ----
		label2.setText("Frage");
		add(label2, "cell 2 1");

		//---- label3 ----
		label3.setText("Antwort 1");
		add(label3, "cell 3 1");

		//---- label4 ----
		label4.setText("Antwort 2");
		add(label4, "cell 4 1");

		//---- label5 ----
		label5.setText("Antwort 3");
		add(label5, "cell 5 1");

		//---- label6 ----
		label6.setText("Antwrot 4");
		add(label6, "cell 6 1");
		
        button2.addActionListener(e -> deleteMarkedQuestions());

        button3.addActionListener(e -> addNeueFragen());
        
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
    private JButton button2;
    private JButton button3;	
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
