package vista;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image imagenFondo;

    public BackgroundPanel(String rutaImagen) {
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        this.setLayout(new BorderLayout()); // Usar BorderLayout para el JTextArea
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
