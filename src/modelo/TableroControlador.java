package modelo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

import vista.VistaTabla;

@SuppressWarnings("deprecation")

public class TableroControlador implements Observer {
    
    private TableroModelo modelo;
    private VistaTabla vista;
//    private CartaMounstro cartaMounstruoSeleccionada; //esto se pensaba para los encontrarCarta, la clase Carta no posee todos los metodos para
//    private CartaMagica cartaMagicaSeleccionada;     //las distintas situaciones que se manejan, dejo la idea aqui
    private Carta cartaSeleccionada; //originalmente solo habia esto para mounstruos en el de Samuel
    private boolean cartaColocada = false;

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
        List<Carta> monstruosJugador = modelo.getCampoJugador().getCampoMounstruos().getCartasMounstruoEnCampo();

        for (int i = 0; i < lblMonstruosJugador.length; i++) {
            if (i < monstruosJugador.size()) {
                Carta carta = monstruosJugador.get(i);
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
        List<Carta> monstruosRival = modelo.getCampoComputadora().getCampoMounstruos().getCartasMounstruoEnCampo();

        for (int i = 0; i < lblMonstruosRival.length; i++) {
            if (i < monstruosRival.size()) {
                Carta carta = monstruosRival.get(i);
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
        cartaSeleccionada = encontrarCartaEnCampo(lblMonstruo, cartas);
        if (cartaSeleccionada != null) {
            lblMonstruo.setBackground(Color.YELLOW); // Cambiar el color de fondo de la carta seleccionada
        }
    }

    private Carta encontrarCartaEnCampo(JLabel lblMonstruo, List<Carta> cartas) {
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

    private Carta encontrarCartaEnCampoEnMano(JLabel lblCarta, List<Carta> cartas) {
        for (Carta carta : cartas) {
            if (lblCarta.getText().equals(carta.getNombre())) {
                return carta;
            }
        }
        return null;
    }

    // ver como poder diferenciar esto de abajo para el rival, aqui el colocar se lo coloca al jugador nomas

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

    @SuppressWarnings("unused")
    private void agregarManejadoresDeEventos() {
        JLabel[] lblMonstruosJugador = vista.getLblMonstruosJugador();
        for (JLabel lblMonstruo : lblMonstruosJugador) {
            lblMonstruo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    seleccionarCarta(lblMonstruo, modelo.getCampoJugador().getCampoMounstruos().getCartasMounstruoEnCampo());
                }


                //para situaciones como la de abajo mencionaba yo el cambio de los campos, a una carta mounstruo no le puedo asignar una Carta
                // tal vez con esto? ver bien que hacer ahi, en esta version cambie a cada campo para que sean listas de Carta, originalmente mi version tenia o de mounstruo o de magia
                
                //Tpadre var2 = new Tpadre(); // Ahora var2 es realmente de tipo Tpadre
                //if (var2 instanceof Thija) {
                //   Thija var1 = (Thija) var2; // Esto será seguro
                //} else {
                //   System.out.println("var2 no es una instancia de Thija");
                //}  //Nunca probe algo asi, preguntar

                @Override
                public void mouseEntered(MouseEvent e) {
                    CartaMounstro carta = encontrarCartaMounstro(lblMonstruo, modelo.getCampoJugador().getCampoMounstruos().getCartasMounstruoEnCampo());
                    if (carta != null) {
                        vista.mostrarEstadisticasMonstruo(carta);
                    }
                }

                // por si confunde, el modelo posee dos clases campos, esa clase posee a ambos campos, cada campo tiene su getCartas que devuelve
                // la lista de cartas correspondientes de cada campo, se separo por la idea inicial de tener los campos con una lista de mounstruos o magias
                // por los problemas ya mencionados, y de paso para el nombre del metodo del getCartasMounstruosEnCampo o magias

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
                        
                        // ver bien esto, como se sabria cuando es el jugador y cuando el rival?
                        modelo.atacarEnTablero(atacante, cartaAtacante, atacado, cartaAtacada);
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

}
