/*
 * Created by JFormDesigner on Thu May 08 18:53:48 CEST 2025
 */

package quiz;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Michael
 */
public class MCFragenNeuUI extends JPanel {
    private MCFragenManager fragenManager;
	private JPanel mainJPanel = AufgabenTrainerUI.contentPanel;

    public MCFragenNeuUI() {
        fragenManager = new MCFragenManager();
        initComponents();
    }

    public void showPanel(JPanel panel) {
        mainJPanel.removeAll();
        mainJPanel.add(panel);
        mainJPanel.revalidate();
        mainJPanel.repaint();
    }
    
    private void addNewQuestion(ActionEvent e) {
        String frage = textField1.getText();
        String antwort1 = textField2.getText();
        String antwort2 = textField3.getText();
        String antwort3 = textField4.getText();
        String antwort4 = textField5.getText();

        // Überprüfen, welcher Radiobutton ausgewählt ist
        String loesung = null;
        if (radioButton1.isSelected()) {
            loesung = antwort1;
        } else if (radioButton2.isSelected()) {
            loesung = antwort2;
        } else if (radioButton3.isSelected()) {
            loesung = antwort3;
        } else if (radioButton4.isSelected()) {
            loesung = antwort4;
        }

        // Validierung der Eingaben
        if (frage.isEmpty() || antwort1.isEmpty() || antwort2.isEmpty() || antwort3.isEmpty() || antwort4.isEmpty() || loesung == null) {
            JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen und eine richtige Antwort auswählen.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Antworten zusammenführen
        String antwort = antwort1 + "; " + antwort2 + "; " + antwort3 + "; " + antwort4;

        // Frage hinzufügen
        fragenManager.addFrage(frage, antwort, loesung);

        // Bestätigung anzeigen
        int result = JOptionPane.showConfirmDialog(this,
            "Frage erfolgreich hinzugefügt.\nMöchten Sie zur Fragenübersicht zurückkehren?",
            "Erfolg",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            switchToMCFrageAnzeigeUI();
        }

        // Felder und Radiobuttons zurücksetzen
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");

        radioButton1.setSelected(false);
        radioButton2.setSelected(false);
        radioButton3.setSelected(false);
        radioButton4.setSelected(false);
    }
		
	    private void switchToMCFrageAnzeigeUI() {
	    	MCFrageAnzeigeUI mcFrageAnzeigeUI = new MCFrageAnzeigeUI();
            showPanel(mcFrageAnzeigeUI);
	    }		
		
	    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		label4 = new JLabel();
		label2 = new JLabel();
		textField1 = new JTextField();
		radioButton1 = new JRadioButton();
		label3 = new JLabel();
		textField2 = new JTextField();
		radioButton2 = new JRadioButton();
		label5 = new JLabel();
		textField3 = new JTextField();
		radioButton3 = new JRadioButton();
		label6 = new JLabel();
		textField4 = new JTextField();
		radioButton4 = new JRadioButton();
		label7 = new JLabel();
		textField5 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
		swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
		. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
		,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
		( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
		.beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
		( ); }} );
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[118,fill]" +
			"[304,fill]" +
			"[fill]" +
			"[34,fill]",
			// rows
			"[]" +
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
		label1.setText("Neue Aufgabe anlegen");
		add(label1, "cell 0 0 3 1,alignx center,growx 0");

		//---- label4 ----
		label4.setText("MultipleChoice Fragen eingeben (richtige durch Radiobutton ausw\u00e4hlen)");
		add(label4, "cell 0 1 5 1,alignx center,growx 0");

		//---- label2 ----
		label2.setText("Frage:");
		add(label2, "cell 1 2");
		add(textField1, "cell 2 2");
		add(radioButton1, "cell 0 3");

		//---- label3 ----
		label3.setText("Antwort 1");
		add(label3, "cell 1 3");
		add(textField2, "cell 2 3");
		add(radioButton2, "cell 0 4");

		//---- label5 ----
		label5.setText("Antwort 2");
		add(label5, "cell 1 4");
		add(textField3, "cell 2 4");
		add(radioButton3, "cell 0 5");

		//---- label6 ----
		label6.setText("Antwort 3");
		add(label6, "cell 1 5");
		add(textField4, "cell 2 5");
		add(radioButton4, "cell 0 6");

		//---- label7 ----
		label7.setText("Antwort 4");
		add(label7, "cell 1 6");
		add(textField5, "cell 2 6");

		//---- button1 ----
		button1.setText("Frage hinzuf\u00fcgen");
		button1.addActionListener(e -> {
			addNewQuestion(e);
			addNewQuestion(e);
		});
		add(button1, "cell 0 7 4 1,alignx center,growx 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JLabel label4;
	private JLabel label2;
	private JTextField textField1;
	private JRadioButton radioButton1;
	private JLabel label3;
	private JTextField textField2;
	private JRadioButton radioButton2;
	private JLabel label5;
	private JTextField textField3;
	private JRadioButton radioButton3;
	private JLabel label6;
	private JTextField textField4;
	private JRadioButton radioButton4;
	private JLabel label7;
	private JTextField textField5;
	private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}