package quiz;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            // Lade das Bild aus dem Ressourcenpfad
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
            if (backgroundImage == null) {
                System.err.println("Bild konnte nicht geladen werden: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Zeichne das Bild so, dass es die gesamte Größe des Panels ausfüllt
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}