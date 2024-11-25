package modelo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import vista.VistaTabla;

@SuppressWarnings("deprecation")

public class TableroControlador implements Observer {

    private TableroModelo modelo;
    private VistaTabla vista;
    // private CartaMounstro cartaMounstruoSeleccionada; //esto se pensaba para los
    // encontrarCarta, la clase Carta no posee todos los metodos para
    private CartaMagica cartaMagicaSeleccionada; // las distintas situaciones que
    // se manejan, dejo la idea aqui
    private Carta cartaSeleccionada; // originalmente solo habia esto para mounstruos en el de Samuel

    private boolean turnoRival = true;
    private boolean turnoJugador = false;

    public TableroControlador(TableroModelo modelo, VistaTabla vista) {
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
        // Actualizar las cartas en el campo del jugador
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        List<CartaMounstro> monstruosJugador = modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo();
    
        for (int i = 0; i < lblMonstruosJugador.length; i++) {
            if (i < monstruosJugador.size()) {
                Carta carta = monstruosJugador.get(i);
                lblMonstruosJugador[i].setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruosJugador[i].setText(carta.getNombre());
                lblMonstruosJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblMonstruosJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                lblMonstruosJugador[i].setText("");
                lblMonstruosJugador[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblMonstruosJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblMonstruosJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            }
        }
    
        // Actualizar las cartas en el campo del rival
        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        List<CartaMounstro> monstruosRival = modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo();
    
        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                Carta carta = monstruosRival.get(i);
                lblMonstruosRival[i].setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruosRival[i].setText(carta.getNombre());
                lblMonstruosRival[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblMonstruosRival[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                lblMonstruosRival[i].setText("");
                lblMonstruosRival[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblMonstruosRival[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblMonstruosRival[i].setOpaque(true); // Para que el fondo transparente surta efecto
            }
        }
    
        JLabel[] lblCartasMagicasJugador = vista.getLblHechizosJugador();
        List<CartaMagica> cartasMagicasJugador = modelo.getCampoJugador().getCampoMagias().getCartaMagicasEnCampo();
    
        for (int i = 0; i < lblCartasMagicasJugador.length; i++) {
            if (i < cartasMagicasJugador.size()) {
                CartaMagica carta = cartasMagicasJugador.get(i);
                lblCartasMagicasJugador[i].setIcon(null); // Limpiar cualquier icono anterior
                lblCartasMagicasJugador[i].setText(carta.getNombre());
                lblCartasMagicasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasMagicasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                lblCartasMagicasJugador[i].setText("");
                lblCartasMagicasJugador[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblCartasMagicasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasMagicasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            }
        }
    
        JLabel[] lblCartasMagicasRival = vista.getLblHechizosRival();
        List<CartaMagica> cartasMagicasRival = modelo.getCampoComputadora().getCampoMagias().getCartaMagicasEnCampo();
    
        for (int i = 0; i < lblCartasMagicasRival.length; i++) {
            if (i < cartasMagicasRival.size()) {
                CartaMagica carta = cartasMagicasRival.get(i);
                lblCartasMagicasRival[i].setIcon(null); // Limpiar cualquier icono anterior
                lblCartasMagicasRival[i].setText(carta.getNombre());
                lblCartasMagicasRival[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasMagicasRival[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                lblCartasMagicasRival[i].setText("");
                lblCartasMagicasRival[i].setIcon(null); // Limpiar la imagen si no hay carta
                lblCartasMagicasRival[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasMagicasRival[i].setOpaque(true); // Para que el fondo transparente surta efecto
            }
        }
    
        // Actualizar las cartas en la mano del jugador
        JLabel[] lblCartasJugador = vista.getLblCartasJugador();
        List<Carta> manoJugador = modelo.getJugador().getMano();
        for (int i = 0; i < lblCartasJugador.length; i++) {
            if (i < manoJugador.size()) {
                lblCartasJugador[i].setText(manoJugador.get(i).getNombre());
                lblCartasJugador[i].setIcon(null);
                lblCartasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                lblCartasJugador[i].setText("");
                lblCartasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            }
        }
    
        // Actualizar la barra de vida de los jugadores
        vista.getBarraVidaJugador().setValue(modelo.getJugador().getPuntosVida());
        vista.getBarraVidaRival().setValue(modelo.getComputadora().getPuntosVida());
    }
    



/* 
    private void actualizarVista() {
        // Actualizar las cartas en el campo del jugador
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        List<CartaMounstro> monstruosJugador = modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo();

        for (int i = 0; i < lblMonstruosJugador.length; i++) {
            if (i < monstruosJugador.size()) {
                Carta carta = monstruosJugador.get(i);
                /*
                 * if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                 * lblMonstruosJugador[i].setIcon(new ImageIcon(carta.getImagen())); //
                 * Establecer la imagen si existe
                 * lblMonstruosJugador[i].setText(""); // Limpiar el texto si hay una imagen
                 * } else {
                 
                lblMonstruosJugador[i].setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruosJugador[i].setText(carta.getNombre());
            } else {
                lblMonstruosJugador[i].setText("");
                lblMonstruosJugador[i].setIcon(null); // Limpiar la imagen si no hay carta
               
            }

        }

        // Actualizar las cartas en el campo del rival
        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        List<CartaMounstro> monstruosRival = modelo.getCampoComputadora().getCampoMounstruos()
                .getCartaMounstrosEnCampo();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                Carta carta = monstruosRival.get(i);
                /*
                 * if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                 * lblMonstruosRival[i].setIcon(new ImageIcon(carta.getImagen())); // Establecer
                 * la imagen si existe
                 * lblMonstruosRival[i].setText(""); // Limpiar el texto si hay una imagen
                 * } else {
                 
                lblMonstruosRival[i].setIcon(null); // Limpiar cualquier icono anterior
                lblMonstruosRival[i].setText(carta.getNombre());

            } else {
                lblMonstruosRival[i].setText("");
                lblMonstruosRival[i].setIcon(null); // Limpiar la imagen si no hay carta
            }

        }

        JLabel[] lblCartasMagicasJugador = vista.getLblHechizosJugador();
        List<CartaMagica> cartasMagicasJugador = modelo.getCampoJugador().getCampoMagias().getCartaMagicasEnCampo();

        for (int i = 0; i < lblCartasMagicasJugador.length; i++) {
            if (i < cartasMagicasJugador.size()) {
                CartaMagica carta = cartasMagicasJugador.get(i);
                /*
                 * if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                 * lblCartasMagicasJugador[i].setIcon(new ImageIcon(carta.getImagen())); //
                 * Establecer la imagen si
                 * lblCartasMagicasJugador[i].setText(""); // Limpiar el texto si hay una imagen
                 * } else {
                 

                lblCartasMagicasJugador[i].setIcon(null); // Limpiar cualquier icono anterior
                lblCartasMagicasJugador[i].setText(carta.getNombre());
            } else {
                lblCartasMagicasJugador[i].setText("");
                lblCartasMagicasJugador[i].setIcon(null);
            }
        }

        JLabel[] lblCartasMagicasRival = vista.getLblHechizosRival();
        List<CartaMagica> cartasMagicasRival = modelo.getCampoComputadora().getCampoMagias().getCartaMagicasEnCampo();

        for (int i = 0; i < lblCartasMagicasRival.length; i++) {
            if (i < cartasMagicasRival.size()) {
                CartaMagica carta = cartasMagicasRival.get(i);
                /*
                 * if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                 * lblCartasMagicasJugador[i].setIcon(new ImageIcon(carta.getImagen())); //
                 * Establecer la imagen si
                 * lblCartasMagicasJugador[i].setText(""); // Limpiar el texto si hay una imagen
                 * } else {
                 

                lblCartasMagicasRival[i].setIcon(null); // Limpiar cualquier icono anterior
                lblCartasMagicasRival[i].setText(carta.getNombre());
            } else {
                lblCartasMagicasRival[i].setText("");
                lblCartasMagicasRival[i].setIcon(null);
            }
        }

        // Actualizar las cartas en la mano del jugador
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

        // Actualizar la barra de vida de los jugadores
        vista.getBarraVidaJugador().setValue(modelo.getJugador().getPuntosVida());
        vista.getBarraVidaRival().setValue(modelo.getComputadora().getPuntosVida());
    }
*/
    private void seleccionarCarta(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        // Restablecer el fondo de todas las cartas del jugador
        for (JLabel lbl : vista.getLblMonstruosJugador()) {
        }
        // Encontrar la carta correspondiente al JLabel
        cartaSeleccionada = encontrarCartaMounstro(lblMonstruo, cartas);
        if (cartaSeleccionada != null) {
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

    private CartaMagica encontrarCartaEnCampoMagica(JLabel lblMonstruo, List<CartaMagica> cartas) {
        for (CartaMagica carta : cartas) {
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

    private Carta encontrarCartaEnCampoEnMano(JLabel lblCarta, List<Carta> cartas) {
        for (Carta carta : cartas) {
            if (lblCarta.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    public void finalizarTurno() {

        cartaSeleccionada = null;
        modelo.reiniciarAtaqueMounstruos();
        if (turnoJugador) {
            turnoJugador = !turnoJugador;
            turnoRival = !turnoRival;
            vista.agregarAccionTablero("Turno del Rival");
        } else {
            turnoRival = !turnoRival;
            turnoJugador = !turnoJugador;
            vista.agregarAccionTablero("Turno del Jugador");
            bot();
        }

        actualizarVista();

    }

    private void bot() {
        Jugador rival = modelo.getComputadora();
        Random random = new Random();

        // Robar una carta de la BarajaRival si la mano del rival no está llena

        rival.robarCarta();

        // Colocar todas las cartas de la mano del rival en el campo si hay espacio
        List<Carta> cartasEnMano = rival.getMano();
        List<CartaMounstro> cartasMounstruosEnCampoBot = modelo.getCampoComputadora().getCampoMounstruos()
                .getCartaMounstrosEnCampo();
        JLabel[] lblMonstruosRival = vista.getLblMonstruosRival();
        JLabel[] lblHechizosRival = vista.getLblHechizosRival();

        for (int i = 0; i < cartasEnMano.size(); i++) {
            Carta carta = cartasEnMano.get(i);
            vista.agregarAccionRival("El bot saco una carta ");
            if (cartasMounstruosEnCampoBot.size() < 5) {
                // Carta carta = cartasEnMano.get(i);
                if (carta instanceof CartaMounstro) {
                    try {
                        modelo.colocarCarta((CartaMounstro) carta, modelo.getCampoComputadora());
                        // cartasMounstruosEnCampoBot =
                        // modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo();
                        cartasEnMano.remove(carta);
                        i--; // Ajustar el índice después de la eliminación
                        JLabel lblMonstruo = lblMonstruosRival[cartasMounstruosEnCampoBot.size() - 1];
                        if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                            lblMonstruo.setIcon(new ImageIcon(carta.getImagen()));
                            lblMonstruo.setText("");
                        } else {
                            lblMonstruo.setIcon(null);
                            lblMonstruo.setText(carta.getNombre());
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                break; // El campo está lleno
            }

            List<CartaMagica> cartasMagicasEnCampoBot = modelo.getCampoComputadora().getCampoMagias()
                    .getCartaMagicasEnCampo();

            if (cartasMagicasEnCampoBot.size() < 3) {
                // Carta carta = cartasEnMano.get(i);
                if (carta instanceof CartaMagica) {
                    try {
                        modelo.colocarCarta((CartaMagica) carta, modelo.getCampoComputadora());
                        cartasEnMano.remove(carta);
                        i--; // Ajustar el índice después de la eliminación
                        JLabel lblHechizo = lblHechizosRival[cartasMagicasEnCampoBot.size() - 1];
                        /*
                         * if (carta.getImagen() != null && !carta.getImagen().isEmpty()) {
                         * lblHechizo.setIcon(new ImageIcon(carta.getImagen()));
                         * lblHechizo.setText("");
                         * } else {}
                         */
                        lblHechizo.setIcon(null);
                        lblHechizo.setText(carta.getNombre());
                        Runnable usarMagiaRunnable = new Runnable() {

                            public void run() {

                                try {
                                    Thread.sleep(2000);
                                    vista.agregarAccionTablero("no se olviden suscribirse a wolfav15");
                                    if (carta instanceof CartaMagicaHerida) {

                                        modelo.usarMagia((CartaMagicaHerida) carta, modelo.getJugador(),
                                                modelo.getCampoComputadora());
                                        vista.agregarAccionRival("Utilizo la carta " + carta.getNombre());
                                    } else if (carta instanceof CartaMagicaCuracion) {

                                        modelo.usarMagia((CartaMagicaCuracion) carta, modelo.getComputadora(),
                                                modelo.getCampoComputadora());
                                        vista.agregarAccionRival("Utilizo la carta " + carta.getNombre());

                                    } else if (carta instanceof CartaMagicaEquipada) {

                                        List<CartaMounstro> cartasMounstruoBot = modelo.getCampoComputadora()
                                                .getCampoMounstruos()
                                                .getCartaMounstrosEnCampo();
                                        CartaMounstro cartaBuffada = cartasMounstruoBot
                                                .get(random.nextInt(cartasMounstruoBot.size()));
                                        modelo.usarMagia((CartaMagicaEquipada) carta, cartaBuffada,
                                                modelo.getCampoComputadora());
                                        vista.agregarAccionRival("Utilizo la carta " + carta.getNombre() + " sobre "
                                                + cartaBuffada.getNombre());

                                    }
                                    actualizarVista();
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        new Thread(usarMagiaRunnable).start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                break; // El campo está lleno
            }
        }
        List<CartaMounstro> cartasMounstruoJugador = modelo.getCampoJugador().getCampoMounstruos()
                .getCartaMounstrosEnCampo();

        if (cartasMounstruoJugador.size() > 0) {
            for (CartaMounstro carta : modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo()) {
                CartaMounstro cartaAtacada = cartasMounstruoJugador.get(random.nextInt(cartasMounstruoJugador.size()));
                try {
                    modelo.atacarEnTablero(rival, carta, modelo.getJugador(), cartaAtacada);
                    vista.agregarAccionRival("Ataco a " + cartaAtacada.getNombre());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (cartasMounstruoJugador.size() == 0) {
            for (CartaMounstro carta : modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo()) {
                try {
                    modelo.atacarJugador(carta, modelo.getComputadora(), modelo.getJugador());
                    vista.agregarAccionRival("Ataco al jugador");
                    if (modelo.getJugador().getPuntosVida() <= 0) {
                        vista.mostrarMensajeDerrota("MALDITO PERDEDOR", "C://Users//samue//Desktop//derrota.jpg");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } // Atacar directamente al jugador si no hay cartas del rival en el campo

        finalizarTurno();
        actualizarVista();
        // Actualizar la vista después de las acciones del bot// Pasar el turno al
        // jugador
    }

    private void seleccionarCartaMagicaParaBuff(CartaMagicaEquipada cartaMagica) {
        // Añadir un listener temporal a las cartas de monstruos del jugador para la
        // selección del buff
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();

        for (JLabel lblMonstruo : lblMonstruosJugador) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CartaMounstro cartaMounstro = encontrarCartaMounstro(lblMonstruo,
                            modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo());
                    if (cartaMounstro != null && cartaMagica != null) {
                        try {
                            // Aplicar el efecto de la carta mágica al monstruo seleccionado utilizando
                            // usarMagia
                            modelo.usarMagia(cartaMagica, cartaMounstro, modelo.getCampoJugador());

                            // Actualizar la vista y limpiar la selección
                            actualizarVista();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        // Remover el listener temporal después de la selección
                        lblMonstruo.removeMouseListener(this);
                    }
                }
            });
        }
    }

    @SuppressWarnings("unused")
    private void agregarManejadoresDeEventos() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        for (JLabel lblMonstruo : lblMonstruosJugador) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e) && cartaMagicaSeleccionada != null) {
                        // Aplicar el buff con clic derecho
                        CartaMounstro cartaMounstro = encontrarCartaMounstro(lblMonstruo,
                                modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo());
                        if (cartaMounstro != null) {
                            try {
                                modelo.usarMagia((CartaMagicaEquipada) cartaMagicaSeleccionada, cartaMounstro,
                                        modelo.getCampoJugador());
                                vista.agregarAccionJugador("Buff aplicado" + cartaMagicaSeleccionada.getNombre() + " a "
                                        + cartaMounstro.getNombre());
                                cartaMagicaSeleccionada = null; // Limpiar la carta mágica seleccionada después de
                                                                // aplicar el buff
                                actualizarVista();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        // Manejar selección de carta con clic izquierdo
                        seleccionarCarta(lblMonstruo,
                                modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo());
                        vista.agregarAccionJugador("Carta seleccionada: " + cartaSeleccionada.getNombre());
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMounstro carta = encontrarCartaMounstro(lblMonstruo,
                            modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo());
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
                    if (cartaSeleccionada != null) {
                        CartaMounstro cartaAtacada = encontrarCartaMounstro(lblMonstruo,
                                modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo());
                        try {
                            modelo.atacarEnTablero(modelo.getJugador(), (CartaMounstro) cartaSeleccionada,
                                    modelo.getComputadora(), cartaAtacada);
                            vista.agregarAccionJugador("Carta atacada: " + cartaAtacada.getNombre());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        cartaSeleccionada = null;
                        actualizarVista();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMounstro carta = encontrarCartaMounstro(lblMonstruo,
                            modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo());
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
                if ((modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo().size() == 0)
                        && cartaSeleccionada != null) {
                    modelo.atacarJugador((CartaMounstro) cartaSeleccionada, modelo.getJugador(),
                            modelo.getComputadora());
                    cartaSeleccionada = null;
                    vista.agregarAccionJugador("Rival atacado: " + cartaSeleccionada.getNombre());
                    if (modelo.getComputadora().getPuntosVida() <= 0) {
                        vista.monstrarMensajeGanador("FELICIDADES SHINJI", "C://Users//samue//Desktop//ganador.jpg");

                    }
                    actualizarVista();
                }
            }
        });

        JLabel[] lblCartasJugador = vista.getLblCartasJugador();
        for (JLabel lblCarta : lblCartasJugador) {
            lblCarta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Carta carta = encontrarCartaEnCampoEnMano(lblCarta, modelo.getJugador().getMano());
                    if (carta != null) {
                        if (carta instanceof CartaMounstro) {
                            vista.mostrarEstadisticasMonstruo((CartaMounstro) carta);
                        } else if (carta instanceof CartaMagica) {
                            vista.mostrarEstadisticasHechizo((CartaMagica) carta);
                        }
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    cartaSeleccionada = encontrarCartaEnCampoEnMano(lblCarta, modelo.getJugador().getMano());
                    if (cartaSeleccionada != null) {
                        if (cartaSeleccionada instanceof CartaMounstro) {
                            try {
                                modelo.colocarCarta((CartaMounstro) cartaSeleccionada, modelo.getCampoJugador());
                                modelo.getJugador().getMano().remove(cartaSeleccionada);
                                vista.agregarAccionJugador("Carta colocada: " + cartaSeleccionada.getNombre());
                                if (cartaSeleccionada.getImagen() != null && !cartaSeleccionada.getImagen().isEmpty()) {
                                    lblCarta.setIcon(new ImageIcon(cartaSeleccionada.getImagen()));
                                    lblCarta.setText("");
                                } else {
                                    lblCarta.setIcon(null); // Limpiar cualquier icono anterior
                                    lblCarta.setText(cartaSeleccionada.getNombre());
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else if (cartaSeleccionada instanceof CartaMagica) {
                            try {
                                modelo.colocarCarta((CartaMagica) cartaSeleccionada, modelo.getCampoJugador());
                                modelo.getJugador().getMano().remove(cartaSeleccionada);
                                vista.agregarAccionJugador("Carta colocada: " + cartaSeleccionada.getNombre());

                                if (cartaSeleccionada.getImagen() != null && !cartaSeleccionada.getImagen().isEmpty()) {
                                    lblCarta.setIcon(new ImageIcon(cartaSeleccionada.getImagen()));
                                    lblCarta.setText("");
                                } else {
                                    lblCarta.setIcon(null); // Limpiar cualquier icono anterior
                                    lblCarta.setText(cartaSeleccionada.getNombre());
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        actualizarVista();
                    }
                }
            });
        }

        // Manejadores de eventos para activar cartas mágicas desde el campo
        JLabel[] lblCartasMagicasJugador = vista.getLblHechizosJugador();
        for (JLabel lblCarta : lblCartasMagicasJugador) {
            lblCarta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CartaMagica cartaMagica = encontrarCartaEnCampoMagica(lblCarta,
                            modelo.getCampoJugador().getCampoMagias().getCartaMagicasEnCampo());
                    if (cartaMagica != null) {
                        if (cartaMagica instanceof CartaMagicaEquipada) {
                            // Permitir seleccionar un monstruo para buffear
                            seleccionarCartaMagicaParaBuff((CartaMagicaEquipada) cartaMagica);
                            vista.agregarAccionJugador("Hechizo utilizado " + cartaMagica.getNombre()
                                    + " para buffear a" + cartaSeleccionada.getNombre());
                        } else if (cartaMagica instanceof CartaMagicaCuracion) {
                            try {
                                modelo.usarMagia((CartaMagicaArrojadiza) cartaMagica, modelo.getJugador(),
                                        modelo.getCampoJugador());
                                vista.agregarAccionJugador("Hechizo utilizado " + cartaMagica.getNombre());

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else if (cartaMagica instanceof CartaMagicaHerida) {
                            try {
                                modelo.usarMagia((CartaMagicaArrojadiza) cartaMagica, modelo.getComputadora(),
                                        modelo.getCampoJugador());
                                vista.agregarAccionJugador("Hechizo utilizado " + cartaMagica.getNombre());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    }
                    actualizarVista();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMagica carta = encontrarCartaEnCampoMagica(lblCarta,
                            modelo.getCampoJugador().getCampoMagias().getCartaMagicasEnCampo());
                    if (carta != null) {
                        vista.mostrarEstadisticasHechizo(carta);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }
            });
        }

        JLabel[] lblCartasMagicasRival = vista.getLblHechizosRival();

        for (JLabel lblCarta : lblCartasMagicasRival) {
            lblCarta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMagica cartaMagica = encontrarCartaEnCampoMagica(lblCarta,
                            modelo.getCampoComputadora().getCampoMagias().getCartaMagicasEnCampo());
                    vista.mostrarEstadisticasHechizo(cartaMagica);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    vista.ocultarEstadisticas();
                }

            });
        }

        vista.getLblBarajaJugador().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelo.getJugador().robarCarta();
                vista.agregarAccionJugador("Carta robada: " + modelo.getJugador().getMano().get(modelo.getJugador().getMano().size() - 1).getNombre());
                actualizarVista();
            }
        });

        vista.getBtnFinalizarTurno().addActionListener(e -> {
            try {
                finalizarTurno();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {

        TableroModelo modelo = new TableroModelo();

        VistaTabla vista = new VistaTabla();
        new TableroControlador(modelo, vista);

    }

}
