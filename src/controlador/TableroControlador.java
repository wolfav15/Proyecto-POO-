package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import modelo.Carta;
import modelo.CartaMagica;
import modelo.CartaMagicaArrojadiza;
import modelo.CartaMagicaCuracion;
import modelo.CartaMagicaEquipada;
import modelo.CartaMagicaHerida;
import modelo.CartaMounstro;
import modelo.Jugador;
import modelo.JugadorDAO;
import modelo.TableroModelo;
import vista.VistaTabla;

@SuppressWarnings("deprecation")

public class TableroControlador implements Observer {
	private JugadorDAO daoJugador;
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
        this.daoJugador = new JugadorDAO();
        inicializarVista();
        agregarManejadoresDeEventos();
        vista.agregarAccionTablero("El Tablero Es tipo " + modelo.getTablero().getTipo_elemento_tablero());
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
            if (i < monstruosJugador.size() && monstruosJugador.get(i) != null) {
                Carta carta = monstruosJugador.get(i);
                visualizarImagen(lblMonstruosJugador[i], carta.getImagen());
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
        List<CartaMounstro> monstruosRival = modelo.getCampoComputadora().getCampoMounstruos()
                .getCartaMounstrosEnCampo();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size() && monstruosRival.get(i) != null) {
                Carta carta = monstruosRival.get(i);
                visualizarImagen(lblMonstruosRival[i], carta.getImagen());
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
            if (i < cartasMagicasJugador.size() && cartasMagicasJugador.get(i) != null) {
                CartaMagica carta = cartasMagicasJugador.get(i);
                lblCartasMagicasJugador[i].setIcon(new ImageIcon(carta.getImagen()));

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
            if (i < cartasMagicasRival.size() && cartasMagicasRival.get(i) != null) {
                CartaMagica carta = cartasMagicasRival.get(i);
                lblCartasMagicasRival[i].setText(carta.getNombre());
                lblCartasMagicasRival[i].setIcon(new ImageIcon(carta.getImagen()));
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
            if (i < manoJugador.size() && manoJugador.get(i) != null && manoJugador.get(i) instanceof CartaMounstro) {
                lblCartasJugador[i].setText(manoJugador.get(i).getNombre());
                lblCartasJugador[i].setHorizontalAlignment(JLabel.CENTER);
                lblCartasJugador[i].setVerticalTextPosition(JLabel.BOTTOM);
                visualizarImagen(lblCartasJugador[i], manoJugador.get(i).getImagen());
                lblCartasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                lblCartasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
            } else {
                if (i < manoJugador.size() && manoJugador.get(i) != null && manoJugador.get(i) instanceof CartaMagica) {
                    lblCartasJugador[i].setText(manoJugador.get(i).getNombre());
                    lblCartasJugador[i].setHorizontalAlignment(JLabel.CENTER);
                    lblCartasJugador[i].setVerticalTextPosition(JLabel.BOTTOM);
                    lblCartasJugador[i].setIcon(new ImageIcon(manoJugador.get(i).getImagen()));
                } else {
                    lblCartasJugador[i].setText("");
                    lblCartasJugador[i].setIcon(null); // Limpiar la imagen si no hay carta
                    lblCartasJugador[i].setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                    lblCartasJugador[i].setOpaque(true); // Para que el fondo transparente surta efecto
                }
            }
        }
        // Actualizar la barra de vida de los jugadores
        vista.getBarraVidaJugador().setValue(modelo.getJugador().getPuntosVida());
        vista.getBarraVidaRival().setValue(modelo.getComputadora().getPuntosVida());
        if (modelo.getComputadora().getPuntosVida() <= 0) {
            try {
                daoJugador.sumarVictoria(modelo.getIdUsuario());
                vista.monstrarMensajeGanador("FELICIDADES SHINJI", "src\\vista\\imagenes\\trofeo.png");
                vista.dispose();
                ControladorMenu controlador = new ControladorMenu();
				controlador.getVista().setVisible(true);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private CartaMounstro encontrarCartaMounstro(JLabel lblMonstruo, List<CartaMounstro> cartas) {
        for (CartaMounstro carta : cartas) {
            if (lblMonstruo.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    private CartaMagica encontrarCartaEnCampoMagica(JLabel lblMonstruo, List<CartaMagica> cartas) {
        for (CartaMagica carta : cartas) {
            if (lblMonstruo.getText().equals(carta.getNombre())) {
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

    public void finalizarTurno() throws SQLException {
        cartaSeleccionada = null;
        modelo.reiniciarAtaqueMounstruos();

        vista.agregarAccionTablero("Turno Finalizado");

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
                        vista.agregarAccionRival("El bot jugo la carta " + carta.getNombre());
                        if (((CartaMounstro) carta).getElemento().equals(modelo.getTablero().getTipo_elemento_tablero())) {
                            vista.agregarAccionRival("Carta Buffeada por la tabla " + ((CartaMounstro) carta).getElemento());
                            ((CartaMounstro) carta).setAtaque(((CartaMounstro) carta).getAtaque() + 1000);
                            ((CartaMounstro) carta).setBuffTabla(1000);
                        }
                        cartasEnMano.remove(carta);
                        i--; // Ajustar el índice después de la eliminación
                        
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
                if (modelo.getJugador().getPuntosVida() > 0) {
                CartaMounstro cartaAtacada = cartasMounstruoJugador.get(random.nextInt(cartasMounstruoJugador.size()));
                try {             
        
                    Runnable esperarMounstruo = new Runnable() {

                    public void run() {

                        try {
                            Thread.sleep(5000);
                            modelo.atacarEnTablero(rival, carta, modelo.getJugador(), cartaAtacada);
                            vista.agregarAccionRival("Ataco a " + cartaAtacada.getNombre());
                            actualizarVista();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                new Thread(esperarMounstruo).start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }}
            }
        }
        if (cartasMounstruoJugador.size() == 0) {

            for (CartaMounstro carta : modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo()) {
                if (modelo.getJugador().getPuntosVida() > 0) {
                try {
                    modelo.atacarJugador(carta, modelo.getComputadora(), modelo.getJugador());
                    vista.agregarAccionRival("Ataco al jugador");
                    if (modelo.getJugador().getPuntosVida() <= 0) {
                    	daoJugador.sumarDerrota(modelo.getIdUsuario());
                        vista.mostrarMensajeDerrota("MALDITO PERDEDOR", "src\\vista\\imagenes\\calavera.png");
                        vista.dispose();
                        ControladorMenu controlador = new ControladorMenu();
        				controlador.getVista().setVisible(true);
                        
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } }
            }
        } // Atacar directamente al jugador si no hay cartas del rival en el campo

        try {
            finalizarTurno();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private void visualizarImagen(JLabel jLabel, String link) {
        jLabel.setIcon(null); // Para limpiar la anterior imagen
        Image image = null;
        URL url = null;

        try {

            url = new URL(link);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        try {
            image = ImageIO.read(url);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if (image != null) {
            // Redimensionar la imagen a 200x300
            Image imagenNueva = image.getScaledInstance(90, 110, Image.SCALE_FAST);

            // Poner la imagen redimensionada en el JLabel

            jLabel.setIcon(new ImageIcon(imagenNueva));
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
                        cartaSeleccionada = encontrarCartaMounstro(lblMonstruo,
                                modelo.getCampoJugador().getCampoMounstruos().getCartaMounstrosEnCampo());
                        if (cartaSeleccionada != null) {
                            vista.agregarAccionJugador("Carta seleccionada: " + cartaSeleccionada.getNombre());
                        }

                    }
                    actualizarVista();
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
                if (cartaSeleccionada != null) {
                    vista.agregarAccionTablero("pendejo");
                }

                if ((modelo.getCampoComputadora().getCampoMounstruos().getCartaMounstrosEnCampo().size() == 0)
                        && cartaSeleccionada != null) {
                    modelo.atacarJugador((CartaMounstro) cartaSeleccionada, modelo.getJugador(),
                            modelo.getComputadora());
                    cartaSeleccionada = null;
                    vista.agregarAccionJugador("Rival atacado: " + cartaSeleccionada.getNombre());
                    
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
                                if (((CartaMounstro) cartaSeleccionada).getElemento()
                                        .equals(modelo.getTablero().getTipo_elemento_tablero())) {
                                    vista.agregarAccionJugador(
                                            "Carta Buffeada por elemento " + modelo.getTablero().getTipo_elemento_tablero());
                                    ((CartaMounstro) cartaSeleccionada)
                                            .setAtaque(((CartaMounstro) cartaSeleccionada).getAtaque() + 1000);
                                            ((CartaMounstro)cartaSeleccionada).setBuffTabla(1000);
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else if (cartaSeleccionada instanceof CartaMagica) {
                            try {
                                modelo.colocarCarta((CartaMagica) cartaSeleccionada, modelo.getCampoJugador());
                                modelo.getJugador().getMano().remove(cartaSeleccionada);
                                vista.agregarAccionJugador("Carta colocada: " + cartaSeleccionada.getNombre());

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
                    vista.agregarAccionJugador("Hechizo seleccionado" + cartaMagica.getNombre());

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
        //
        vista.getLblBarajaJugador().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelo.getJugador().robarCarta();
                vista.agregarAccionJugador("Carta robada: "
                        + modelo.getJugador().getMano().get(modelo.getJugador().getMano().size() - 1).getNombre());
                actualizarVista();
            }

        });

        vista.getBtnFinalizarTurno().addActionListener(e ->

        {
            try {
                finalizarTurno();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        TableroModelo modelo = new TableroModelo(null);

      VistaTabla vista = new VistaTabla(modelo);

		new TableroControlador(modelo, vista);

		

	}
//
   }


