package quiz;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class JavaCheckerUI extends JPanel {
    private JavaChecker javaChecker;
    private String currentQuestion; // Speichert die aktuelle Frage
    private String currentAnswer;   // Speichert die aktuelle Antwort

    public JavaCheckerUI() {
        javaChecker = new JavaChecker(); // Initialize JavaChecker instance
        
        // Init numbers first
        initNummern(); // Nummern der Aufgaben werden zuerst geladen
        
        initComponents();
        initAufgabe(); // Danach wird die erste Aufgabe geladen
    }

    private void initAufgabe() {
        // Initialisiert die erste Aufgabe
        javaChecker.initialiereFrage();
        currentQuestion = javaChecker.frageText; // Speichert die Frage in der Instanzvariable
        currentAnswer = javaChecker.antwort; // Speichert die Antwort in der Instanzvariable
        int currentTaskNumber = javaChecker.currentTaskNumber; // Holt die Nummer der aktuellen Aufgabe
        label1.setText("Aufgabe " + currentTaskNumber + ": " + currentQuestion); // Nummer und Frage anzeigen
    }

    private void initNummern() {
        // Ruft die Methode `initialisiereNummer` auf, um die Aufgaben-Nummern zu laden
        javaChecker.initialisiereNummer();
        Integer[] aufgabenNummern = javaChecker.aufgabenNummern; // Zugriff auf die Nummern

        // Nullprüfung hinzufügen
        if (aufgabenNummern == null || aufgabenNummern.length == 0) {
            System.out.println("Keine Aufgaben-Nummern verfügbar oder Array ist null.");
            return; // Beendet die Methode, wenn keine Nummern verfügbar sind
        }

        // Ausgabe der Aufgaben-Nummern in der Konsole (optional)
        System.out.println("Aufgaben-Nummern: ");
        for (Integer nummer : aufgabenNummern) {
            System.out.println(nummer);
        }
 
        // Alternativ: Die Nummern könnten in der UI angezeigt werden, falls benötigt.
    }

    private void buttonCheckeAufgabe(ActionEvent e) {
        try {
            String sourceCode = textArea1.getText(); // Holen des Quellcodes aus dem Eingabefeld
            // Übergibt `currentQuestion` und `currentAnswer` an die Methode pruefeAntwortExeption
            String output = javaChecker.pruefeAntwortExeption(sourceCode, currentQuestion, currentAnswer);
            textArea2.setText(output); // Zeigt die Ausgabe
        } catch (Exception ex) {
            textArea2.setText("❌ Fehler bei der Verarbeitung.");
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Michael Bork
        label1 = new JLabel();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea2 = new JTextArea();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062order".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });
        setLayout(new MigLayout(
            "hidemode 3,alignx center",
            // columns
            "[334,fill]",
            // rows
            "[]" +
            "[184]" +
            "[]" +
            "[143]"));

        //---- label1 ----
        label1.setText("Frage");
        add(label1, "cell 0 0,alignx center,growx 0");
        add(textArea1, "cell 0 1,dock center");

        //---- button1 ----
        button1.setText("Eingabe Prüfen");
        button1.addActionListener(e -> buttonCheckeAufgabe(e));
        add(button1, "cell 0 2,growx");

        //---- button2 ----
        button2.setText("nächste Aufgabe");
        add(button2, "cell 0 2,growx");

        //======== scrollPane1 ========
        {
            //---- textArea2 ----
            textArea2.setText("ausgabe");
            textArea2.setEditable(false);
            scrollPane1.setViewportView(textArea2);
        }
        add(scrollPane1, "cell 0 3,dock center");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Michael Bork
    private JLabel label1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}