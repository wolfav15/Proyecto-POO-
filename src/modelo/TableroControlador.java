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
//    private CartaMounstro cartaMounstruoSeleccionada;
//    private CartaMagica cartaMagicaSeleccionada;
    private Carta cartaSeleccionada;

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

    private void actualizarVista() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        List<CartaMounstro> monstruosJugador = modelo.getCampoJugador().getCampoMounstruos().getCartasMounstruoEnCampo();

        for (int i = 0; i < lblMonstruosJugador.length; i++) {
            if (i < monstruosJugador.size()) {
                CartaMounstro carta = monstruosJugador.get(i);
                if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                    lblMonstruosJugador[i].setIcon(new ImageIcon(carta.getImagen())); // Establecer la imagen si existe
                    lblMonstruosJugador[i].setText(""); // Limpiar el texto si hay una imagen
                } else {
                    lblMonstruosJugador[i].setIcon(null); // Limpiar cualquier icono anterior
                    lblMonstruosJugador[i].setText(carta.getNombre());
                }
                lblMonstruosJugador[i].setBackground(carta.isActivo() ? Color.GREEN : Color.RED);
            } else {
                lblMonstruosJugador[i].setText("");
                lblMonstruosJugador[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblMonstruosJugador[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        List<CartaMounstro> monstruosRival = modelo.getCampoComputadora().getCampoMounstruos().getCartasMounstruoEnCampo();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                CartaMounstro carta = monstruosRival.get(i);
                if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                    lblMonstruosRival[i].setIcon(new ImageIcon(carta.getImagen())); // Establecer la imagen si existe
                    lblMonstruosRival[i].setText(""); // Limpiar el texto si hay una imagen
                } else {

                    lblMonstruosRival[i].setText(carta.getNombre());
                }
                lblMonstruosRival[i].setBackground(carta.isActivo() ? Color.GREEN : Color.RED);
            } else {
                lblMonstruosRival[i].setText("");
                lblMonstruosRival[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblMonstruosRival[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        JLabel[] lblCartasJugador = vista.getLblCartasJugador();
        List<Carta> manoJugador = modelo.getJugador().getMano();
        for (int i = 0; i < lblCartasJugador.length; i++) {
            if (i < manoJugador.size()) {
                lblCartasJugador[i].setText(manoJugador.get(i).getNombre());
                lblCartasJugador[i].setIcon(null);
            } else {
                lblCartasJugador[i].setText("");
            }
        }

        vista.getBarraVidaJugador().setValue(modelo.getJugador().getPuntosVida());
        vista.getBarraVidaRival().setValue(modelo.getComputadora().getPuntosVida());
    }

    private void seleccionarCarta(JLabel lblMonstruo, List<Carta> cartas) {
        // Restablecer el fondo de todas las cartas del jugador
        for (JLabel lbl : vista.getLblMonstruosJugador()) {
            lbl.setBackground(Color.LIGHT_GRAY);
        }
        // Encontrar la carta correspondiente al JLabel
        cartaSeleccionada = encontrarCarta(lblMonstruo, cartas);
        if (cartaSeleccionada != null) {
            lblMonstruo.setBackground(Color.YELLOW); // Cambiar el color de fondo de la carta seleccionada
        }
    }
// ver si puede ser generico el seleccionar y encontrar carta, como aqui arriba, antes se probo separado
    private void seleccionarCarta2(JLabel lblMonstruo, List<CartaMagica> cartas) {
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

    private Carta encontrarCarta(JLabel lblMonstruo, List<Carta> cartas) {
        for (Carta carta : cartas) {
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

    private CartaMagica encontrarCarta2(JLabel lblMagia, List<CartaMagica> cartas) {
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

    private Carta encontrarCartaEnMano(JLabel lblCarta, List<Carta> cartas) {
        for (Carta carta : cartas) {
            if (lblCarta.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    private void colocarCarta(CartaMounstro carta, JLabel lblMonstruo) throws Exception {
        if (carta != null && modelo.getCampoJugador().getCampoMounstruos().getCartasMounstruoEnCampo().size() < 5 && !cartaColocada) {
            modelo.colocarCarta(carta, modelo.getCampoJugador());
            modelo.getJugador().getMano().remove(carta); // Quitar la carta de la mano del jugador
            if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                lblMonstruo.setIcon(new ImageIcon(carta.getImagen())); // Establecer la imagen si existe
                lblMonstruo.setText(""); // Limpiar el texto si hay una imagen
            } else {
                lblMonstruo.setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruo.setText(carta.getNombre());
            }

            actualizarVista();
        }
    }
}
