package quiz;

import javax.swing.*;
import java.awt.event.*;

public class MenuPanelSwitcher extends JFrame {
    private JPanel panelStart;
    private JPanel panelFragen;
    private JavaChecker panelEinstellungen;
    private JPanel contentPanel;

    public MenuPanelSwitcher() {
        setTitle("App mit Menü");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 640);

        // Inhalte vorbereiten
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(contentPanel);

        panelStart = new JPanel();
        panelStart.add(new JLabel("Startseite"));

  //      panelFragen = "";

        panelEinstellungen = new JavaChecker();
//        panelEinstellungen.add(new JLabel("Einstellungen"));

        setJMenuBar(createMenu());

        showPanel(panelStart);
        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Navigation");
        JMenuItem itemStart = new JMenuItem("Start");
        JMenuItem itemFragen = new JMenuItem("MC-Frage");
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

    private void showPanel(JavaChecker panelEinstellungen2) {
        contentPanel.removeAll();
        contentPanel.add(panelEinstellungen2);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPanelSwitcher::new);
    }
}