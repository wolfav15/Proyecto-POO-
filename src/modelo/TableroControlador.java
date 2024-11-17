package modelo;

import java.awt.Color;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.VistaTabla;
@SuppressWarnings("deprecation")

public class TableroControlador implements Observer {
    
    private TableroModelo modelo;
    private VistaTabla vista;
    private CartaMounstro cartaMounstruoSeleccionada;
    private CartaMagica cartaMagicaSeleccionada;

    public TableroControlador (TableroModelo modelo, VistaTabla vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.addObserver(this);
        inicializarVista();
        agregarManejadoresDeEventos();
    }

    private void inicializarVista() {
        vista.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o == modelo) {
            actualizarVista();
        }
    }

    private void seleccionarCarta(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        // Restablecer el fondo de todas las cartas del jugador
        for (JLabel lbl : vista.getLblMonstruosJugador()) {
            lbl.setBackground(Color.LIGHT_GRAY);
        }
        // Encontrar la carta correspondiente al JLabel
        cartaMounstruoSeleccionada = encontrarCarta(lblMonstruo, cartas);
        if (cartaMounstruoSeleccionada != null) {
            lblMonstruo.setBackground(Color.YELLOW); // Cambiar el color de fondo de la carta seleccionada
        }
    }

    private void seleccionarCarta(JLabel lblMonstruo, List<CartaMagica> cartas) {
        // Restablecer el fondo de todas las cartas del jugador
        for (JLabel lbl : vista.getLblMonstruosJugador()) {
            lbl.setBackground(Color.LIGHT_GRAY);
        }
        // Encontrar la carta correspondiente al JLabel
        cartaMagicaSeleccionada = encontrarCarta(lblMonstruo, cartas);
        if (cartaMagicaSeleccionada != null) {
            lblMonstruo.setBackground(Color.YELLOW); // Cambiar el color de fondo de la carta seleccionada
        }
    }

    private CartaMounstro encontrarCarta(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        for (CartaMounstro carta : cartas) {
            if (lblMonstruo.getIcon() != null && lblMonstruo.getIcon() instanceof ImageIcon) {
                // Comparar el icono del JLabel con el icono de la carta
                ImageIcon icon = new ImageIcon(carta.getImagen());
                if (icon.getImage().equals(((ImageIcon) lblMonstruo.getIcon()).getImage())) {
                    return carta;
                }
            } else if (lblMonstruo.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    private CartaMagica encontrarCarta(JLabel lblMagia, List<CartaMagica> cartas) {
        for (CartaMagica carta : cartas) {
            if (lblMagia.getIcon() != null && lblMagia.getIcon() instanceof ImageIcon) {
                // Comparar el icono del JLabel con el icono de la carta
                ImageIcon icon = new ImageIcon(carta.getImagen());
                if (icon.getImage().equals(((ImageIcon) lblMagia.getIcon()).getImage())) {
                    return carta;
                }
            } else if (lblMagia.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }
}
