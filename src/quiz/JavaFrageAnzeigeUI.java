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
       int zeile = 1; 
        for (String[] frageDetails : fragenListe) {
            // Für jede Nummer, Frage und Antwort eine Zeile erstellen
        	JButton button = new JButton("Bearb.");
            JCheckBox checkBox = new JCheckBox(frageDetails[0]); // Checkbox für die Nummer
            JTextField textFieldFrage = new JTextField(frageDetails[1]); // Textfeld für die Frage
            JTextField textFieldAntwort = new JTextField(frageDetails[2]); // Textfeld für die Antwort

//            // Setze feste Breite für die Textfelder
//            textFieldFrage.setColumns(30);
//            textFieldAntwort.setColumns(15);

            // Dynamisch die Komponenten zur GUI hinzufügen
            add(button, "cell 0 " + (zeile) + ",alignx left"); // Spalte 0
            add(checkBox, "cell 1 " + (zeile) + ",alignx left"); // Spalte 0
            add(textFieldFrage, "cell 2 " + (zeile) + ",growx"); // Spalte 1
            add(textFieldAntwort, "cell 3 " + (zeile) + ",growx"); // Spalte 2
            zeile++;
        }

        // Nach dem Hinzufügen von Komponenten die GUI neu validieren
        revalidate();
        repaint();
    }

    private void initComponents() {

		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		button2 = new JButton();

		//======== this ========
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
		javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax
		.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
		.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt
		.Color.red), getBorder())); addPropertyChangeListener(new java.beans.
		PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".
		equals(e.getPropertyName()))throw new RuntimeException();}});
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
		label1.setText("Fragen\u00fcbersicht");
		add(label1, "cell 0 0 4 1,alignx center,growx 0");

		//---- button2 ----
		button2.setText("Markierte L\u00f6schen");
		add(button2, "cell 0 7 6 1,alignx center,growx 0");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}