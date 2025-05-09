/*
 * Created by JFormDesigner on Wed May 07 10:56:17 CEST 2025
 */

package quiz;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author mbor193
 */
public class MCFragenBeantwortenUI extends JPanel {
    private MCFragenManager fragenManager;
	
	public MCFragenBeantwortenUI() {
		initComponents();
		 fragenManager = new MCFragenManager();
		initFrage();
	}

	private void initFrage() {
	    int frageNummer = 1; // Beispiel: Lade die erste Frage
	    try {
	        // Hole Frage und Antworten mit viewFrage
	        String[] frageUndAntworten = fragenManager.viewFrage(frageNummer);
	        
	        label2.setText(frageUndAntworten[0]); // Setze die Frage
	        radioButton1.setText(frageUndAntworten[1]); // Setze Antwort 1
	        radioButton2.setText(frageUndAntworten[2]); // Setze Antwort 2
	        radioButton3.setText(frageUndAntworten[3]); // Setze Antwort 3
	        radioButton4.setText(frageUndAntworten[4]); // Setze Antwort 4
	    } catch (IOException e) {
	        label2.setText("Fehler beim Laden der Frage.");
	        radioButton1.setText("");
	        radioButton2.setText("");
	        radioButton3.setText("");
	        radioButton4.setText("");
	    }
	}

	private void button1(ActionEvent e) {
		// TODO add your code here
	}

	private void button2(ActionEvent e) {
		// TODO add your code here
	}
	
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		label2 = new JLabel();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		radioButton3 = new JRadioButton();
		radioButton4 = new JRadioButton();
		button1 = new JButton();
		button2 = new JButton();
		label3 = new JLabel();

		//======== this ========
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
		border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
		,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
		.BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
		new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
		.equals(e.getPropertyName()))throw new RuntimeException();}});
		setLayout(new MigLayout(
			"hidemode 3,alignx center",
			// columns
			"[234,fill]",
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
		label1.setText("MultipleCoice-Quiz");
		add(label1, "cell 0 0,alignx center,growx 0");

		//---- label2 ----
		label2.setText("Frage");
		add(label2, "cell 0 1");

		//---- radioButton1 ----
		radioButton1.setText("Antwort1");
		add(radioButton1, "cell 0 2");

		//---- radioButton2 ----
		radioButton2.setText("Antwort2");
		add(radioButton2, "cell 0 3");

		//---- radioButton3 ----
		radioButton3.setText("Antwort3");
		add(radioButton3, "cell 0 4");

		//---- radioButton4 ----
		radioButton4.setText("Antwort4");
		add(radioButton4, "cell 0 5");

		//---- button1 ----
		button1.setText("Antwort Pr\u00fcfen");
		button1.addActionListener(e -> button1(e));
		add(button1, "cell 0 6,alignx left,growx 0,width 111::111");

		//---- button2 ----
		button2.setText("N\u00e4chste Frage");
		button2.addActionListener(e -> button2(e));
		add(button2, "cell 0 6,alignx right,growx 0,width 111:111");

		//---- label3 ----
		label3.setText("RichtigFalsch");
		add(label3, "cell 0 7,alignx center,growx 0");

		//---- buttonGroup1 ----
		var buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(radioButton1);
		buttonGroup1.add(radioButton2);
		buttonGroup1.add(radioButton3);
		buttonGroup1.add(radioButton4);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JLabel label2;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JButton button1;
	private JButton button2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
