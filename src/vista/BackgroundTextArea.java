package vista;

import javax.swing.*;
import java.awt.*;

public class BackgroundTextArea extends JTextArea {
    private Image imagenFondo;

    public BackgroundTextArea(String rutaImagen) {

    	this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setOpaque(false);
	}

	@Override
    protected void paintComponent(Graphics g) {
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
}
