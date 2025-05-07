/*
 * Created by JFormDesigner on Wed May 07 10:40:46 CEST 2025
 */

package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author mbor193
 */
public class AufgabenTrainerUI extends JPanel {
	public AufgabenTrainerUI() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();

		//======== this ========
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
		0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
		. BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
		red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
		beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- button1 ----
		button1.setText("Multiple Choic Quiz");
		add(button1, "cell 0 0,dock center");

		//---- button2 ----
		button2.setText("Java-Code schreiben");
		add(button2, "cell 0 1,dock center");

		//---- button3 ----
		button3.setText("Java-Code erkennen");
		add(button3, "cell 0 2,dock center");

		//---- button4 ----
		button4.setText("Fragen bearbeiten");
		add(button4, "cell 0 3,dock center");

		//---- button5 ----
		button5.setText("App schlie\u00dfen");
		add(button5, "cell 0 4,dock center");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
