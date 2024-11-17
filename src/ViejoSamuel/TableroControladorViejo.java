package controlador;
import vista.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;

import modelo.*;
import modelo.Jugador;

public class TableroControladorViejo {
    private TableroModeloSamuel modelo;
    private VistaTabla vista;
    private Jugador jugador;
    private Jugador rival;

    public TableroControladorViejo(TableroModeloSamuel modelo, VistaTabla vista, Jugador jugador, Jugador rival) {
        this.modelo = modelo;
        this.vista = vista;
        this.jugador = jugador;
        this.rival = rival;
        inicializarVista();
        agregarManejadoresDeEventos();

        modelo.addObserver((o, arg) -> actualizarVista()); // Observer para actualizar la vista
    }

    private void inicializarVista() {
        vista.setVisible(true);
    }

    private void agregarManejadoresDeEventos() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        for (JLabel lblMonstruo : lblMonstruosJugador) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarOpcionesCarta((JLabel) e.getSource());
                }
            });
        }
        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        for (JLabel lblMonstruo : lblMonstruosRival) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    atacarJugador((JLabel) e.getSource());
                }
            });
        }
    }

    private void mostrarOpcionesCarta(JLabel lblMonstruo) {
        CartaMounstro carta = encontrarCarta(lblMonstruo, modelo.getMonstruosJugador());
        if (carta != null) {
            atacarJugador(carta);
        }
    }

    private void cambiarPosicionCartaConClick(JLabel lblMonstruo) {
        CartaMounstro carta = encontrarCarta(lblMonstruo, modelo.getMonstruosJugador());
        if (carta != null) {
            cambiarPosicionCarta(carta);
        }
    }

    private void atacarJugador(JLabel lblMonstruo) {
        CartaMounstro carta = encontrarCarta(lblMonstruo, modelo.getMonstruosJugador());
        if (carta != null) {
            int daño = carta.getAtaque();
            rival.recibirDaño(daño);
            vista.getBarraVidaRival().setValue(rival.getPuntosVida());
            actualizarVista();
        }
    }

    private CartaMounstro seleccionarCartaParaAtacar() {
        return modelo.getMonstruosRival().isEmpty() ? null : modelo.getMonstruosRival().get(0);
    }

    private CartaMounstro encontrarCarta(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        for (CartaMounstro carta : cartas) {
            if (lblMonstruo.getIcon() != null && lblMonstruo.getIcon().equals(carta.getImagen())) {
                return carta;
            }
        }
        return null;
    }

    public void colocarCarta(CartaMounstro carta) {
        modelo.colocarCarta(carta);
        actualizarVista();
    }

    public void atacarCarta(CartaMounstro atacante, CartaMounstro defensor) {
        int daño = modelo.atacarCarta(atacante, defensor);
        rival.recibirDaño(daño); // Aplica daño al rival
        vista.getBarraVidaRival().setValue(rival.getPuntosVida()); // Actualiza la barra de vida del rival
        actualizarVista();
    }

    public void atacarJugador(CartaMounstro atacante) {
        int daño = atacante.getAtaque();
        rival.recibirDaño(daño);
        vista.getBarraVidaRival().setValue(rival.getPuntosVida()); // Actualiza la barra de vida del rival
        actualizarVista();
    }

    public void cambiarPosicionCarta(CartaMounstro carta) {
        modelo.cambiarPosicionCarta(carta);
        actualizarVista();
    }

    private void actualizarVista() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        List<CartaMounstro> monstruosJugador = modelo.getMonstruosJugador();

        for (int i = 0; i < lblMonstruosJugador.length; i++) {
            if (i < monstruosJugador.size()) {
                lblMonstruosJugador[i].setIcon(monstruosJugador.get(i).getImagen());
                lblMonstruosJugador[i].setBackground(monstruosJugador.get(i).isActivo() ? Color.GREEN : Color.RED);
            } else {
                lblMonstruosJugador[i].setIcon(null);
                lblMonstruosJugador[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        List<CartaMounstro> monstruosRival = modelo.getMonstruosRival();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                lblMonstruosRival[i].setIcon(monstruosRival.get(i).getImagen());
                lblMonstruosRival[i].setBackground(monstruosRival.get(i).isActivo() ? Color.GREEN : Color.RED);
            } else {
                lblMonstruosRival[i].setIcon(null);
                lblMonstruosRival[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public static void main(String[] args) {
        TableroModeloSamuel modelo = new TableroModeloSamuel();
        VistaTabla vista = new VistaTabla();
        Jugador jugador = new Jugador("Jugador 1", null);
        Jugador rival = new Jugador("Rival", null);
        new TableroControladorViejo(modelo, vista, jugador, rival);

        // Crear una carta y simular un ataque para probar
        CartaMounstro cartaAtacante = new CartaMounstro("Dragón", "Un poderoso dragón", 3000, 2500, 8, "Fuego");
        modelo.agregarCartaJugador(cartaAtacante);
        modelo.colocarCarta(cartaAtacante);
        modelo.agregarCartaJugador(cartaAtacante);
        modelo.colocarCarta(cartaAtacante);
        jugador.recibirDaño(8000);
        vista.getBarraVidaJugador().setValue(jugador.getPuntosVida());
        vista.getBarraVidaRival().setValue(rival.getPuntosVida()); // Actual
    }
}

