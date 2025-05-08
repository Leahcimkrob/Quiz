package quiz;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
        panelStart = new JPanel();
        panelStart.add(new JLabel("tbd"));

        panelFragen = new JPanel();
        panelFragen.add(new JLabel("Startseite"));

        panelJavaCode = new JavaFrageAnzeigeUI();


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
        JMenuItem itemFragenNeu = new JMenuItem("Neue MC-Frage");
              
        
        itemStart.addActionListener(e -> showPanel(panelStart));
        itemFragen.addActionListener(e -> showPanel(panelFragen));
        itemEinstellungen.addActionListener(e -> showPanel(panelJavaCode));
        

        menu.add(itemStart);
        menu.add(itemFragen);
        menu.add(itemEinstellungen);
        menu.add(itemFragenNeu);
        
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