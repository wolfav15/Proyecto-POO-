package vista;

import javax.swing.*;
import java.awt.*;

public class BackgroundLabel extends JLabel {
    private Image imagenFondo;

    public BackgroundLabel(String rutaImagen, String text) {
        super(text);
        this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
}
