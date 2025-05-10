package quiz;

import javax.swing.*;
import java.awt.event.*;

public class AufgabenTrainerUI extends JFrame {
    private JPanel panelStart;
    private JPanel panelFragen;
    private JPanel panelJavaCode;
    private JPanel panelMCFrage;
    private JPanel panelJavaFrage; // Neuer Panel für das zweite Menü
    public static JPanel contentPanel;

    public AufgabenTrainerUI() {
        setTitle("App mit Menü");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 640);

        // Inhalte vorbereiten
        contentPanel = new JPanel(); // Initialisiere contentPanel
        contentPanel = new BackgroundPanel("Logo groß.png");
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(contentPanel); // Füge contentPanel zum JFrame hinzu

        panelStart = new JPanel();
        panelStart.add(new JLabel("Aufgaben Trainer"));

        panelFragen = new MCFragenBeantwortenUI();

        panelJavaCode = new JavaCheckerUI();
        
        panelMCFrage = new MCFrageAnzeigeUI();

        panelJavaFrage = new JavaFrageAnzeigeUI();

        setJMenuBar(createMenuBar());

        showPanel(panelStart);
        setVisible(true);
    }
    
    

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Erstes Menü: Navigation
        JMenu navigationMenu1 = new JMenu("Navigation");
        JMenuItem itemStart = new JMenuItem("Start");
        JMenuItem itemFragen = new JMenuItem("MC-Frage");
        JMenuItem itemJavaCode = new JMenuItem("Programmieraufgabe");

        itemStart.addActionListener(e -> showPanel(panelStart));
        itemFragen.addActionListener(e -> showPanel(panelFragen));
        itemJavaCode.addActionListener(e -> showPanel(panelJavaCode));

        navigationMenu1.add(itemStart);
        navigationMenu1.add(itemFragen);
        navigationMenu1.add(itemJavaCode);

        menuBar.add(navigationMenu1);
        
        // Zweites Menü: Zusatz
        JMenu navigationMenu2 = new JMenu("Bearbeiten");
        JMenuItem itemFrageMCFrage = new JMenuItem("MultipleCoice Frage");
        JMenuItem itemFrageJava = new JMenuItem("JavaFrage");

        itemFrageMCFrage.addActionListener(e -> showPanel(panelMCFrage)); 
        itemFrageJava.addActionListener(e -> showPanel(panelJavaFrage)); // Aktion für das zweite Menü

        navigationMenu2.add(itemFrageMCFrage);
        navigationMenu2.add(itemFrageJava);

        menuBar.add(navigationMenu2); // Füge das zweite Menü hinzu

        return menuBar;
    }

    public void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AufgabenTrainerUI::new);
    }
}