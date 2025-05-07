package quiz;

import javax.swing.*;
import java.awt.event.*;

public class AufgabenTrainerUI extends JFrame {
    private JPanel panelStart;
    private JPanel panelFragen;
    private JPanel panelEinstellungen;
    private JPanel contentPanel;

    public AufgabenTrainerUI() {
        setTitle("App mit Menü");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 640);

        // Inhalte vorbereiten
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(contentPanel);

        panelStart = new JPanel();
        panelStart.add(new JLabel("Startseite"));

 //       panelFragen = new MCFrageVier();

        panelEinstellungen = new JavaCheckerUI();
//        panelEinstellungen.add(new JLabel("Einstellungen"));

        setJMenuBar(createMenu());

        showPanel(panelStart);
        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Navigation");
        JMenuItem itemStart = new JMenuItem("Start");
        JMenuItem itemFragen = new JMenuItem("MultipleChoice-Frage");
        JMenuItem itemEinstellungen = new JMenuItem("Programmieraufgabe");

        itemStart.addActionListener(e -> showPanel(panelStart));
        itemFragen.addActionListener(e -> showPanel(panelFragen));
        itemEinstellungen.addActionListener(e -> showPanel(panelEinstellungen));

        menu.add(itemStart);
        menu.add(itemFragen);
        menu.add(itemEinstellungen);

        menuBar.add(menu);
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