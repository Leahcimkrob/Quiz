package quiz;

import javax.swing.*;
import java.awt.event.*;

public class AufgabenTrainerUI extends JFrame {
    private JPanel panelStart;
    private JPanel panelFragen;
    private JPanel panelJavacode;
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

        // Initialisierung des Multiple-Choice-Panels
        panelFragen = new JPanel();
        panelFragen.add(new JLabel("Multiple-Choice-Frage"));        
        
        panelJavacode = new JavaCheckerUI();

        setJMenuBar(createMenu());

        showPanel(panelStart);
        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Erstes Menü: Navigation
        JMenu menuNavigation = new JMenu("Navigation");
        JMenuItem itemStart = new JMenuItem("Start");
        JMenuItem itemFragen = new JMenuItem("MultipleChoice-Frage");
        JMenuItem itemJavacode = new JMenuItem("Programmieraufgabe");

        itemStart.addActionListener(e -> showPanel(panelStart));
        itemFragen.addActionListener(e -> showPanel(panelFragen));
        itemJavacode.addActionListener(e -> showPanel(panelJavacode));

        menuNavigation.add(itemStart);
        menuNavigation.add(itemFragen);
        menuNavigation.add(itemJavacode);

        menuBar.add(menuNavigation);

        // Zweites Menü: Einstellungen
        JMenu menuSettings = new JMenu("Einstellungen");
        JMenuItem itemOption1 = new JMenuItem("Option 1");
        JMenu itemOption2 = new JMenu("Java-Aufgaben"); // Convert Option 2 to a JMenu for a submenu

        // Add submenu items to Option 2
        JMenuItem subItem1 = new JMenuItem("Unteroption 1");
        JMenuItem subItem2 = new JMenuItem("Unteroption 2");
        JMenuItem subItem3 = new JMenuItem("Unteroption 3");
        JMenuItem subItem4 = new JMenuItem("Anzeigen und löschen");
        
        subItem1.addActionListener(e -> JOptionPane.showMessageDialog(this, "Unteroption 1 ausgewählt."));
        subItem2.addActionListener(e -> JOptionPane.showMessageDialog(this, "Unteroption 2 ausgewählt."));
        subItem3.addActionListener(e -> JOptionPane.showMessageDialog(this, "Unteroption 3 ausgewählt."));
        subItem4.addActionListener(e -> JOptionPane.showMessageDialog(this, "Unteroption 4 ausgewählt."));

        itemOption2.add(subItem1);
        itemOption2.add(subItem2);
        itemOption2.add(subItem3);
        itemOption2.add(subItem4);
        
        menuSettings.add(itemOption1);
        menuSettings.add(itemOption2);
        
        menuBar.add(menuSettings);

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

    // Dummy-Klasse für JavaCheckerUI
    static class JavaCheckerUI extends JPanel {
        public JavaCheckerUI() {
            add(new JLabel("JavaCheckerUI-Panel"));
        }
    }
}