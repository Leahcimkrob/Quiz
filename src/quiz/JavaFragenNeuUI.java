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
public class JavaFragenNeuUI extends JPanel {
    private JavaFragenManager fragenManager;

    public JavaFragenNeuUI() {
        fragenManager = new JavaFragenManager();
        initComponents();
    }

    private void addNewQuestion() {
        String frage = textField1.getText();
        String antwort = textField2.getText();

        if (frage.isEmpty() || antwort.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Frage und Antwort eingeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        fragenManager.addFrage(frage, antwort);

        JOptionPane.showMessageDialog(this, "Frage erfolgreich hinzugefügt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);

        textField1.setText("");
        textField2.setText("");
    }

	private void addNewQuestion(ActionEvent e) {
		// TODO add your code here
	}

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		label4 = new JLabel();
		label2 = new JLabel();
		textField1 = new JTextField();
		label3 = new JLabel();
		textField2 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
		EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
		. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
		java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
		{ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
		throw new RuntimeException( ) ;} } );
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[118,fill]" +
			"[304,fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Neue Aufgabe anlegen");
		add(label1, "cell 0 0 2 1,alignx center,growx 0");

		//---- label4 ----
		label4.setText(" Der Code muss durch den Teilnehmer erstelllt werden. ");
		add(label4, "cell 0 1 2 1,alignx center,growx 0");

		//---- label2 ----
		label2.setText("Frage:");
		add(label2, "cell 0 2");
		add(textField1, "cell 1 2");

		//---- label3 ----
		label3.setText("erwartete Ausgabe:");
		add(label3, "cell 0 3");
		add(textField2, "cell 1 3");

		//---- button1 ----
		button1.setText("Frage hinzuf\u00fcgen");
		button1.addActionListener(e -> addNewQuestion(e));
		add(button1, "cell 0 4 2 1,alignx center,growx 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JLabel label4;
	private JLabel label2;
	private JTextField textField1;
	private JLabel label3;
	private JTextField textField2;
	private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}