package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaCheckerUI implements Aufgabe {
    private JavaChecker javaChecker;
    private JFrame frame;
    private JTextArea codeInputArea;
    private JTextArea resultArea; // Changed from JTextField to JTextArea

    public JavaCheckerUI() {
        javaChecker = new JavaChecker();
        initialiereFrage(); // Initialize the question

        // Create the main frame
        frame = new JFrame("AufgabenTrainer - JavaCode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(510, 380);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Add question label
        JLabel questionLabel = new JLabel(javaChecker.frageText);
        frame.add(questionLabel);

        // Add text area for code input
        codeInputArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(codeInputArea);
        frame.add(scrollPane);

        // Add "Eingabe Prüfen" button
        JButton checkButton = new JButton("Eingabe Prüfen");
        frame.add(checkButton);

        // Add result area (multi-line text field with scroll pane)
        resultArea = new JTextArea(5, 40);
        resultArea.setEditable(false); // Make it non-editable
        resultArea.setLineWrap(true); // Enable line wrapping
        resultArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        frame.add(resultScrollPane);

        // Add action listener to the check button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceCode = codeInputArea.getText();
                try {
                    // Call the pruefeAntwortExeption method and display the output in resultArea
                    String output = javaChecker.pruefeAntwortExeption(sourceCode);
                    resultArea.setText(output); // Set the output with line breaks
                } catch (Exception ex) {
                    resultArea.setText("❌ Fehler bei der Verarbeitung.");
                    ex.printStackTrace();
                }
            }
        });

        // Add "Zum Hauptmenü" button
        JButton mainMenuButton = new JButton("Zum Hauptmenü");
        frame.add(mainMenuButton);

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Zurück zum Hauptmenü.");
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void initialiereFrage() {
        javaChecker.initialiereFrage();
    }

    @Override
    public void stelleFrage() {
        JOptionPane.showMessageDialog(frame, javaChecker.frageText);
    }

    @Override
    public String leseAntwort(java.util.Scanner scanner) {
        return codeInputArea.getText();
    }

    @Override
    public void pruefeAntwort(String antwort) {
        try {
            javaChecker.pruefeAntwort(antwort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JavaCheckerUI().show());
    }
}