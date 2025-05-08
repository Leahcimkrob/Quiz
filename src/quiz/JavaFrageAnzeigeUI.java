/*
 * Created by JFormDesigner on Thu May 08 11:39:58 CEST 2025
 */

package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author mbor193
 */
public class JavaFrageAnzeigeUI extends JPanel {
	public JavaFrageAnzeigeUI() {
        // Init numbers first
        initNummern(); // Nummern der Aufgaben werden zuerst geladen
        initComponents();
        initAufgabe(); // Danach wird die erste Aufgabe geladen
    }
	private void initAufgabe() {
		// TODO Auto-generated method stub
		
	}
	private void initNummern() {
		// TODO Auto-generated method stub
		
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		checkBox1 = new JCheckBox();
		textField1 = new JTextField();
		textField2 = new JTextField();

		//======== this ========
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
		, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
		, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
		 getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
		) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[41,fill]" +
			"[194,fill]" +
			"[230,fill]",
			// rows
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Titel");
		add(label1, "cell 0 0 3 1,alignx center,growx 0");

		//---- checkBox1 ----
		checkBox1.setText("Nummer");
		add(checkBox1, "cell 0 1");

		//---- textField1 ----
		textField1.setText("Frage");
		add(textField1, "cell 1 1");

		//---- textField2 ----
		textField2.setText("Antwort");
		add(textField2, "cell 2 1");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JCheckBox checkBox1;
	private JTextField textField1;
	private JTextField textField2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
