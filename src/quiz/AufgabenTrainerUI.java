package quiz;

import javax.swing.*;
import java.awt.event.*;

public class AufgabenTrainerUI extends JFrame {
    private JPanel panelStart;
    private JPanel panelFragen;
    private JPanel panelJavaCode;
    private JPanel contentPanel;

    public AufgabenTrainerUI() {
        setTitle("App mit Menü");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 640);

        // Inhalte vorbereiten
        contentPanel = new JPanel(); // Initialisiere contentPanel
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(contentPanel); // Füge contentPanel zum JFrame hinzu

        panelStart = new JPanel();
        panelStart.add(new JLabel("Aufgaben Trainer"));

        panelFragen = new JPanel();
        panelFragen.add(new JLabel("Startseite"));

        panelJavaCode = new JavaCheckerUI();

        setJMenuBar(createMenuBar());

        showPanel(panelStart);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Erstes Menü: Navigation
        JMenu navigationMenu = new JMenu("Navigation");
        JMenuItem itemStart = new JMenuItem("Start");
        JMenuItem itemFragen = new JMenuItem("MC-Frage");
        JMenuItem itemEinstellungen = new JMenuItem("Programmieraufgabe");

        itemStart.addActionListener(e -> showPanel(panelStart));
        itemFragen.addActionListener(e -> showPanel(panelFragen));
        itemEinstellungen.addActionListener(e -> showPanel(panelJavaCode));

        navigationMenu.add(itemStart);
        navigationMenu.add(itemFragen);
        navigationMenu.add(itemEinstellungen);

        menuBar.add(navigationMenu);


        return menuBar;
    }

    private void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AufgabenTrainerUI::new);
    }
}