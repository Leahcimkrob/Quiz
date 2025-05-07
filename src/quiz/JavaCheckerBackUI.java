/*
 * Created by JFormDesigner on Wed May 07 10:50:58 CEST 2025
 */

package quiz;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author mbor193
 */
public class JavaCheckerBackUI extends JPanel {
	public JavaCheckerBackUI() {
		initComponents();
	}

	private void button1CheckErgebnis(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Michael Bork
		label1 = new JLabel();
		scrollPane2 = new JScrollPane();
		textArea1 = new JTextArea();
		label2 = new JLabel();
		button1 = new JButton();

		//======== this ========
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
		,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
		,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt.Color.red),
		 getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
		){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}});
		setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]",
			// rows
			"[]" +
			"[77]" +
			"[]" +
			"[]"));

		//---- label1 ----
		label1.setText("Was macht dieses Java-Programm?");
		add(label1, "cell 0 0");

		//======== scrollPane2 ========
		{

			//---- textArea1 ----
			textArea1.setText("Java-Code");
			scrollPane2.setViewportView(textArea1);
		}
		add(scrollPane2, "cell 0 1,dock center");

		//---- label2 ----
		label2.setText("richtig/falsche");
		add(label2, "cell 0 3,alignx center,growx 0");

		//---- button1 ----
		button1.setText("Pr\u00fcfe Ergebnis");
		button1.addActionListener(e -> button1CheckErgebnis(e));
		add(button1, "cell 0 2");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Michael Bork
	private JLabel label1;
	private JScrollPane scrollPane2;
	private JTextArea textArea1;
	private JLabel label2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
