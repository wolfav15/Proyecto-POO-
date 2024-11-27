package vista;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



public class FondoPanel extends JPanel {
    private Image imagenFondo;

    public FondoPanel(String rutaImagen) {
        Image image = null;
        URL url = null;

        if (isValidURL(rutaImagen)){
            try {
                url = new URL(rutaImagen);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } 
            try {
                image = ImageIO.read(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
            this.imagenFondo = new ImageIcon(image).getImage();
        } else {
            this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        }
        
        this.setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

        public static boolean isValidURL(String urlString) {
            try {
                new URL(urlString);
                return true; // Es una URL válida
            } catch (Exception e) {
                return false; // No es una URL válida
            }
        }
}

