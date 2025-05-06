/*
 * Created by JFormDesigner on Tue May 06 14:59:49 CEST 2025
 */

package quiz;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Michael
 */
public class JavaCheckerUI extends JFrame  {

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		button1 = new JButton();
		textField2 = new JTextField();
		button2 = new JButton();

		//======== this ========
		setTitle("AufgabenTrainer - JavaCode");
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3,aligny top",
			// columns
			"[fill]",
			// rows
			"[]" +
			"[149]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Bitte gib dein Hello-World Java-Programm ein (Ende mit einer Leerzeile):");
		contentPane.add(label1, "cell 0 0,alignx center,growx 0");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(textArea1);
		}
		contentPane.add(scrollPane1, "cell 0 1,dock center");

		//---- button1 ----
		button1.setText("Eingabe Pr\u00fcfen");
		contentPane.add(button1, "cell 0 2,alignx center,growx 0");

		//---- textField2 ----
		textField2.setText("richtigfalsch");
		contentPane.add(textField2, "cell 0 3,alignx center,growx 0");

		//---- button2 ----
		button2.setText("Zum Hauptmen\u00fc");
		contentPane.add(button2, "cell 0 4,alignx center,growx 0");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JButton button1;
	private JTextField textField2;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
