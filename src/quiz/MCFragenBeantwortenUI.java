/*
 * Created by JFormDesigner on Wed May 07 10:56:17 CEST 2025
 */

package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author mbor193
 */
public class MCFragenBeantwortenUI extends JPanel {
	public MCFragenBeantwortenUI() {
		initComponents();
		initFrage();
	}

	private void initFrage() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		textField1 = new JTextField();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		radioButton3 = new JRadioButton();
		radioButton4 = new JRadioButton();
		button1 = new JButton();
		button2 = new JButton();
		textField2 = new JTextField();

		//======== this ========
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
		. swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
		.border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
		Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
		) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
		public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
		) ) )throw new RuntimeException( ) ;} } );
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
			"[]"));

		//---- textField1 ----
		textField1.setText("Frage");
		add(textField1, "cell 0 0,alignx center,growx 0");

		//---- radioButton1 ----
		radioButton1.setText("Antwort1");
		add(radioButton1, "cell 0 1");

		//---- radioButton2 ----
		radioButton2.setText("Antwort2");
		add(radioButton2, "cell 0 2");

		//---- radioButton3 ----
		radioButton3.setText("Antwort3");
		add(radioButton3, "cell 0 3");

		//---- radioButton4 ----
		radioButton4.setText("Antwort4");
		add(radioButton4, "cell 0 4");

		//---- button1 ----
		button1.setText("Antwort Pr\u00fcfen");
		add(button1, "cell 0 5,alignx left,growx 0");

		//---- button2 ----
		button2.setText("N\u00e4chste Frage");
		add(button2, "cell 0 5");

		//---- textField2 ----
		textField2.setText("Antwort");
		textField2.setEditable(false);
		add(textField2, "cell 0 6");

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
	private JTextField textField1;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JButton button1;
	private JButton button2;
	private JTextField textField2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
