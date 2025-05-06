package quiz;

import javax.swing.*;
/**
 * 
 */
public class JavaCheckerController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new WasMachtJavaProgramm();
		frame.setTitle("meine Was macht Programm-Frage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
	}

}