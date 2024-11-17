
package ViejoSamuel;

import modelo.Carta;
import modelo.CartaMounstro;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.*;
import modelo.Jugador;

@SuppressWarnings("deprecation")
public class TableroCntroldrSamuel implements Observer {
    private TableroModeloSamuel modelo;
    private VistaTabla vista;
    private Jugador jugador;
    private Jugador rival;
    private CartaMounstro cartaSeleccionada;
    private boolean cartaColocada = false;
    private boolean AtaqueRealizado = false;
    private boolean turnoRival = false;
    private boolean turnoJugador = true;

    public TableroCntroldrSamuel(TableroModeloSamuel modelo, VistaTabla vista, Jugador jugador, Jugador rival) {
        this.modelo = modelo;
        this.vista = vista;
        this.jugador = jugador;
        this.rival = rival;
        this.modelo.addObserver(this);
        inicializarVista();
        agregarManejadoresDeEventos();
    }

    private void inicializarVista() {
        vista.setVisible(true);
    }

    @SuppressWarnings("unused")
    private void agregarManejadoresDeEventos() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        for (JLabel lblMonstruo : lblMonstruosJugador) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    seleccionarCartaMonstruo(lblMonstruo, modelo.getMonstruosJugador());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMounstro carta = encontrarCartaMounstro(lblMonstruo, modelo.getMonstruosJugador());
                    if (carta != null) {
                        vista.mostrarEstadisticasMonstruo(carta);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }
            });
        }

        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        for (JLabel lblMonstruo : lblMonstruosRival) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (cartaSeleccionada != null && !AtaqueRealizado) {
                        atacarCarta(cartaSeleccionada, encontrarCartaMounstro(lblMonstruo, modelo.getMonstruosRival()),
                                lblMonstruo, true);
                        cartaSeleccionada = null;
                        actualizarVista();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMounstro carta = encontrarCartaMounstro(lblMonstruo, modelo.getMonstruosRival());
                    if (carta != null) {
                        vista.mostrarEstadisticasMonstruo(carta);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }
            });
        }

        vista.getBarraVidaRival().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cartaSeleccionada != null && !AtaqueRealizado) {
                    atacarJugador(cartaSeleccionada,true);
                    cartaSeleccionada = null;
                    actualizarVista();
                }
            }
        });

        JLabel[] lblCartasJugador = vista.getLblCartasJugador();
        for (JLabel lblCarta : lblCartasJugador) {
            lblCarta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Carta carta = encontrarCartaEnMano(lblCarta, jugador.getMano());
                    if (carta != null) {
                        vista.mostrarEstadisticasMonstruo((CartaMounstro) carta);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    cartaSeleccionada = (CartaMounstro) encontrarCartaEnMano(lblCarta, jugador.getMano());
                    if (cartaSeleccionada != null && cartaSeleccionada instanceof CartaMounstro) {
                        colocarCartaJugador(cartaSeleccionada, lblCarta);
                    }
                }
            });
        }

        vista.getLblBaraja().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Carta cartaRobada = modelo.robarCarta();
                if (cartaRobada != null) {
                    jugador.añadirCarta(cartaRobada);
                }
                actualizarVista();
            }
        });

        vista.getBtnFinalizarTurno().addActionListener(e -> finalizarTurno());
    }

    public void finalizarTurno() {
        cartaColocada = false;
        AtaqueRealizado = false;
        cartaSeleccionada = null;

        if (turnoJugador) {
            turnoJugador = false;
            turnoRival = true;
        } else if (turnoRival) {
            turnoRival = false;
            turnoJugador = true;
        }
        actualizarVista();
        // Si es el turno del rival, llamar al método bot
        if (turnoRival) {
            bot(rival); // Asegúrate de que el método bot acepte el jugador como parámetro
        }
    }

    private void seleccionarCartaMonstruo(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        // Restablecer el fondo de todas las cartas del jugador
        for (JLabel lbl : vista.getLblMonstruosJugador()) {
            lbl.setBackground(Color.LIGHT_GRAY);
        }
        // Encontrar la carta correspondiente al JLabel
        cartaSeleccionada = encontrarCartaMounstro(lblMonstruo, cartas);
        if (cartaSeleccionada != null) {
            lblMonstruo.setBackground(Color.YELLOW); // Cambiar el color de fondo de la carta seleccionada
        }
    }

    private CartaMounstro encontrarCartaMounstro(JLabel lblMonstruo, List<CartaMounstro> cartas) {
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

    private void colocarCartaJugador(CartaMounstro carta, JLabel lblMonstruo) {
        if (carta != null && modelo.getCartasJugador().size() < 5 && !cartaColocada) {
            modelo.agregarCartaJugador(carta);
            modelo.colocarCarta(carta);
            jugador.getMano().remove(carta); // Quitar la carta de la mano del jugador
            if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                lblMonstruo.setIcon(new ImageIcon(carta.getImagen())); // Establecer la imagen si existe
                lblMonstruo.setText(""); // Limpiar el texto si hay una imagen
            } else {
                lblMonstruo.setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruo.setText(carta.getNombre());
            }
            cartaColocada = true;
            actualizarVista();
        }
    }

    private void colocarCartaRival(CartaMounstro carta, JLabel lblMonstruo) {
        if (carta != null && modelo.getCartasRival().size() < 5 && !cartaColocada) {
            modelo.agregarCartaRival(carta);
            modelo.colocarCarta(carta);
            rival.getMano().remove(carta);

            if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                lblMonstruo.setIcon(new ImageIcon(carta.getImagen()));
                lblMonstruo.setText("");
            } else {
                lblMonstruo.setIcon(null);
                lblMonstruo.setText(carta.getNombre());
            }
            cartaColocada = true;
            actualizarVista();
        }
    }

    private Carta encontrarCartaEnMano(JLabel lblCarta, List<Carta> cartas) {
        for (Carta carta : cartas) {
            if (lblCarta.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    private void atacarCarta(CartaMounstro atacante, CartaMounstro defensor, JLabel lblDefensor,
            boolean esJugadorAtacando) {
        if (defensor != null && !AtaqueRealizado) {
            int ataque = atacante.getAtaque();
            int defensa = defensor.getDefensa();
            if (ataque > defensa) { // Si el ataque es mayor que la defensa
                lblDefensor.setText("");
                lblDefensor.setBackground(Color.LIGHT_GRAY);
                if (esJugadorAtacando) {
                    modelo.eliminarCartaRival(defensor); // Eliminar la carta del modelo del rival
                    rival.recibirDaño(ataque - defensa);
            modelo.setVidaRival(rival.getPuntosVida()); 
                } else {
                    modelo.eliminarCartaJugador(defensor); // Eliminar la carta del modelo del jugador
                    jugador.recibirDaño(ataque-defensa);
                    modelo.setVidaRival(jugador.getPuntosVida());
                }
            }
           
            AtaqueRealizado = true;
            actualizarVista();
        }
    }

    private void atacarJugador(CartaMounstro atacante, boolean esJugadorAtacando) {
        int daño = atacante.getAtaque();
        
        if (esJugadorAtacando) {
            // Si es el jugador atacando, se reduce la vida del rival
            rival.recibirDaño(daño);
            modelo.setVidaRival(rival.getPuntosVida());
            System.out.println("El jugador ha atacado al rival.");
        } else {
            // Si es el rival atacando, se reduce la vida del jugador
            jugador.recibirDaño(daño);
            modelo.setVidaJugador(jugador.getPuntosVida());
            System.out.println("El rival ha atacado al jugador.");
        }
        
        AtaqueRealizado = true;
        actualizarVista();
    }
    

    @Override
    public void update(Observable o, Object arg) {
        if (o == modelo) {
            actualizarVista();
        }
    }

    private void actualizarVista() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        List<CartaMounstro> monstruosJugador = modelo.getMonstruosJugador();

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
        List<CartaMounstro> monstruosRival = modelo.getMonstruosRival();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                CartaMounstro carta = monstruosRival.get(i);
                if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                    lblMonstruosRival[i].setIcon(new ImageIcon(carta.getImagen())); // Establecer la imagen si existe
                    lblMonstruosRival[i].setText(""); // Limpiar el texto si hay una imagen
                } else {

                    lblMonstruosRival[i].setText(carta.getNombre().toString());
                }
                lblMonstruosRival[i].setBackground(carta.isActivo() ? Color.GREEN : Color.RED);
            } else {
                lblMonstruosRival[i].setText("");
                lblMonstruosRival[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblMonstruosRival[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        JLabel[] lblCartasJugador = vista.getLblCartasJugador();
        List<Carta> manoJugador = jugador.getMano();
        for (int i = 0; i < lblCartasJugador.length; i++) {
            if (i < manoJugador.size()) {
                lblCartasJugador[i].setText(manoJugador.get(i).getNombre().toString());
                lblCartasJugador[i].setIcon(null);
            } else {
                lblCartasJugador[i].setText("");
            }
        }

        vista.getBarraVidaJugador().setValue(jugador.getPuntosVida());
        vista.getBarraVidaRival().setValue(rival.getPuntosVida());
    }

    public void bot(Jugador botJugador) {
        Random rand = new Random();

        // Si el bot no tiene cartas en la mano, roba una carta del mazo
        if (botJugador.getMano().isEmpty()) {
            Carta cartaRobada = modelo.robarCarta();
            if (cartaRobada != null) {
                botJugador.añadirCarta(cartaRobada);
                System.out.println("El bot ha robado una carta del mazo.");
            } else {
                System.out.println("No quedan cartas en el mazo para que el bot robe.");
            }
        }

        if (!cartaColocada && rand.nextDouble() < 0.8) {
            if (!botJugador.getMano().isEmpty()) {
                CartaMounstro carta = (CartaMounstro) botJugador.getMano()
                        .get(rand.nextInt(botJugador.getMano().size()));
                int index = modelo.getCartasRival().size();
                if (index >= 0 && index < vista.getLblMonstruosRival().length) {
                    JLabel lblRival = vista.getLblMonstruosRival()[index];
                    colocarCartaRival(carta, lblRival);
                    System.out.println("El bot ha colocado una carta en el tablero.");
                }
            }
        }
     
              if (modelo.getCartasRival().size() > 0 && modelo.getCartasJugador().size() > 0) {
                  // Ataca una carta del jugador si hay alguna en el tablero
                  CartaMounstro cartaAtacante = modelo.getCartasRival().get(rand.nextInt(modelo.getCartasRival().size()));
                  CartaMounstro cartaJugador = modelo.getCartasJugador().get(rand.nextInt(modelo.getCartasJugador().size()));
                  atacarCarta(cartaAtacante, cartaJugador, vista.getLblMonstruosJugador()[modelo.getCartasJugador().indexOf(cartaJugador)], false);
                  System.out.println("El bot ha atacado una carta del jugador.");
              } else if (modelo.getCartasRival().size() > 0) {
                  // Si no hay cartas del jugador, atacar directamente al jugador
                  CartaMounstro cartaAtacante = modelo.getCartasRival().get(rand.nextInt(modelo.getCartasRival().size()));
                  atacarJugador(cartaAtacante, false); // El bot ataca directamente al jugador
                  System.out.println("El bot ha atacado directamente al jugador.");
              }
          

        // Finalizar el turno siempre
        finalizarTurno();
    }

    public void setTurnoRival(boolean turnoRival) {
        this.turnoRival = turnoRival;
    }

    public void setTurnoJugador(boolean turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador 1", null);
        Jugador rival = new Jugador("Rival", null);

        // Crear modelo y vista
        TableroModeloSamuel modelo = new TableroModeloSamuel();
        VistaTabla vista = new VistaTabla();

        CartaMounstro monstruo = new CartaMounstro("Ángel de la Muerte", "Un ángel que trae la muerte", 2000, 1500, 9,
                "Oscuridad", "C://Users//samue//Desktop//angel_muerte.jpg");
        modelo.agregarCartaRival(monstruo);
        modelo.colocarCarta(monstruo);

        // Crear controlador
        TableroCntroldrSamuel controlador = new TableroCntroldrSamuel(modelo, vista, jugador, rival);
        if (controlador.turnoJugador) {
            System.out.println("Turno del jugador.");
        } else {
            System.out.println("Turno del bot.");
            controlador.bot(rival);
        }

    }
}
