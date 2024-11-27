package vista; //esta vista es la que tenia Samuel en su zip

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import modelo.CartaMagica;
import modelo.CartaMagicaArmadura;
import modelo.CartaMagicaBuff;
import modelo.CartaMagicaEquipada;
import modelo.CartaMounstro;
import modelo.TableroDAO;
import modelo.TableroModelo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class VistaTabla extends JFrame {

	private JPanel panelesMonstruosRival;
	private JPanel panelesMonstruosJugador;
	private JPanel panelesHechizosRival;
	private JPanel panelesHechizosJugador;
	private JButton btnFinalizarTurno;
	private JLabel[] lblMonstruosRival;
	private JLabel[] lblMonstruosJugador;
	private JLabel[] lblHechizosRival;
	private JLabel[] lblHechizosJugador;
	private JLabel[] lblCartasJugador;
	private JLabel[] lblCartasRival;
	private JProgressBar barraVidaJugador;
	private JProgressBar barraVidaRival;
	private JTextArea areaEstadistica;
	private JLabel lblBarajaJugador;
	private JLabel lblBarajaRival;
	private JTextArea infoJugador;
	private FondoPanel fondo;

	private JTextArea infoRival;

	private JTextArea infoTablero;

	private static final long serialVersionUID = 1L;

	public VistaTabla(TableroModelo modelo) {

		setTitle("Tablero");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new GridBagLayout());

		fondo = new FondoPanel(modelo.getImagenUrlTablero());
		fondo.setLayout(new GridBagLayout());
		setContentPane(fondo);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;

		// Paneles de monstruos rivales
		JPanel panelMonstruosRival = new JPanel(new GridLayout(1, 5, 10, 0));
		lblMonstruosRival = new JLabel[5];
		panelMonstruosRival.setBackground(new Color(0, 0, 0, 0));
		for (int i = 0; i < lblMonstruosRival.length; i++) {
			lblMonstruosRival[i] = crearLabelConFondo("Monstruo " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelMonstruosRival.add(lblMonstruosRival[i]);
		}

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 0;
		add(panelMonstruosRival, gbc);

		// Paneles de monstruos del jugador
		JPanel panelMonstruosJugador = new JPanel(new GridLayout(1, 5, 10, 0));
		lblMonstruosJugador = new BackgroundLabel[5];
		panelMonstruosJugador.setOpaque(false);
		for (int i = 0; i < lblMonstruosJugador.length; i++) {
			lblMonstruosJugador[i] = crearLabelConFondo("Monstruo " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelMonstruosJugador.add(lblMonstruosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = -3;
		add(panelMonstruosJugador, gbc);

		// Paneles de hechizos rivales
		JPanel panelHechizosRival = new JPanel(new GridLayout(1, 3, 10, 0));
		lblHechizosRival = new JLabel[3];
		panelHechizosRival.setBackground(new Color(0, 0, 0, 0));
		for (int i = 0; i < lblHechizosRival.length; i++) {
			lblHechizosRival[i] = crearLabelConFondo("Hechizo " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelHechizosRival.add(lblHechizosRival[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		add(panelHechizosRival, gbc);

		// Paneles de hechizos del jugador
		JPanel panelHechizosJugador = new JPanel(new GridLayout(1, 3, 10, 0));
		lblHechizosJugador = new JLabel[3];
		panelHechizosJugador.setBackground(new Color(0, 0, 0, 0));
		for (int i = 0; i < lblHechizosJugador.length; i++) {
			lblHechizosJugador[i] = crearLabelConFondo("Hechizo " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelHechizosJugador.add(lblHechizosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 0;
		add(panelHechizosJugador, gbc);

		barraVidaJugador = new JProgressBar(0, 8000);
		barraVidaJugador.setValue(8000);
		barraVidaJugador.setStringPainted(true);
		barraVidaJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		add(barraVidaJugador, gbc);

		barraVidaRival = new JProgressBar(0, 8000);
		barraVidaRival.setValue(8000);
		barraVidaRival.setStringPainted(true);
		barraVidaRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(barraVidaRival, gbc);

		btnFinalizarTurno = new JButton("");
		btnFinalizarTurno.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnFinalizarTurno.setIcon(new ImageIcon("src\\vista\\imagenes\\FINALIZARBTN.png"));
		btnFinalizarTurno.setContentAreaFilled(false);
		btnFinalizarTurno.setBorderPainted(false);
		btnFinalizarTurno.setFocusPainted(false);
		btnFinalizarTurno.setOpaque(false);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		add(btnFinalizarTurno, gbc);

		lblBarajaJugador = new JLabel("BARAJA");
		lblBarajaJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarajaJugador.setPreferredSize(new Dimension(100, 150));
		lblBarajaJugador.setIcon(new ImageIcon("src\\vista\\imagenes\\Baraja.jpg"));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblBarajaJugador, gbc);

		lblBarajaRival = new JLabel("BARAJA RIVAL");
		lblBarajaRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarajaRival.setPreferredSize(new Dimension(100, 150));
		lblBarajaRival.setIcon(new ImageIcon("src\\vista\\imagenes\\Baraja.jpg"));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblBarajaRival, gbc);

		JPanel panelCartasJugador = new JPanel(new GridLayout(1, 5, 10, 0));
		lblCartasJugador = new JLabel[5];
		panelCartasJugador.setBackground(new Color(0, 0, 0, 0));
		for (int i = 0; i < lblCartasJugador.length; i++) {
			lblCartasJugador[i] = crearLabelConFondo("Carta " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelCartasJugador.add(lblCartasJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 0;
		add(panelCartasJugador, gbc);

		// No tengo que ver las cartas del Rival
		JPanel panelCartasRival = new JPanel(new GridLayout(1, 5, 10, 0));
		lblCartasRival = new JLabel[5];
		for (int i = 0; i < lblCartasRival.length; i++) {
			lblCartasRival[i] = crearLabelConFondo("Carta " + (i + 1), new Dimension(120, 150),
					"src\\vista\\imagenes\\fondo_carta.jpg");
			panelCartasRival.add(lblCartasRival[i]);
		}

		JButton btnSalir = new JButton("");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setOpaque(false);
		btnSalir.setIcon(new ImageIcon("src\\vista\\imagenes\\SALIRBTN.png"));
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(btnSalir, gbc);

		areaEstadistica = new JTextArea(5, 20);
		areaEstadistica.setEditable(false);
		areaEstadistica.setBorder(new LineBorder(new Color(0, 0, 0)));
		areaEstadistica.setVisible(false);
		areaEstadistica.setForeground(Color.white);
		areaEstadistica.setBackground(new Color(0, 0, 0, 0));
		gbc.gridx = 1;
		gbc.gridy = 4;

		add(areaEstadistica, gbc);

		infoJugador = new JTextArea(5, 20);
		infoJugador.setEditable(false);
		infoJugador.setOpaque(false);
		infoJugador.setForeground(Color.white);
		BackgroundPanel fondoInfoJugador = new BackgroundPanel("src\\vista\\imagenes\\info.jpg");
		fondoInfoJugador.add(infoJugador);

		gbc.gridx = 1;
		gbc.gridy = 3;
		infoJugador.setBackground(new Color(0, 0, 0, 0));

		add(fondoInfoJugador, gbc);

		infoRival = new JTextArea(5, 20);
		infoRival.setEditable(false);
		infoRival.setOpaque(false);
		infoRival.setForeground(Color.white);
		BackgroundPanel fondoInfoRival = new BackgroundPanel("src\\vista\\imagenes\\info.jpg");
		fondoInfoRival.add(infoRival);

		gbc.gridx = 2;
		gbc.gridy = 0;

		add(fondoInfoRival, gbc);

		infoTablero = new JTextArea(5, 20);
		infoTablero.setOpaque(false);
		infoTablero.setForeground(Color.white);
		BackgroundPanel fondoinfoTablero = new BackgroundPanel("src\\vista\\imagenes\\info.jpg");
		fondoinfoTablero.add(infoTablero);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;

		add(fondoinfoTablero, gbc);
	}

	private JLabel crearLabelConFondo(String nombre, Dimension dimension, String rutaImagenFondo) {
		BackgroundLabel label = new BackgroundLabel(rutaImagenFondo, nombre);
		label.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		label.setPreferredSize(dimension);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		return label;
	}

	public void mostrarEstadisticasMonstruo(CartaMounstro carta) {
		areaEstadistica.setText("Nombre: " + carta.getNombre() + "\nAtaque: " + carta.getAtaque() + "\nDefensa: "
				+ carta.getDefensa() + "\nNivel: " + carta.getNivel() + "\nAtributo: " + carta.getElemento()
				+ "\nPosicion: " + carta.getPosicion());
		areaEstadistica.setVisible(true);
		areaEstadistica.setOpaque(false);

	}

	public void mostrarEstadisticasHechizo(CartaMagica carta) {
		areaEstadistica.setText("Nombre: " + carta.getNombre() + "\nEfecto: " + carta.getCantidad_efecto() +
				"\nTipo " + carta.getClass().getSimpleName()
		// "\nDescripcion: " + carta.getDescripcion()
		);
		areaEstadistica.setVisible(true);
	}

	public void mostrarEstadisticaMonstruoBuffeado(CartaMounstro carta, CartaMagicaEquipada cartaMagica) {
		int ataqueBuff = 0;
		int defensaBuff = 0;

		if (cartaMagica instanceof CartaMagicaBuff) {
			ataqueBuff = cartaMagica.getCantidad_efecto();
		} else if (cartaMagica instanceof CartaMagicaArmadura) {
			defensaBuff = cartaMagica.getCantidad_efecto();
		}

		String ataqueMostrar = ataqueBuff > 0 ? carta.getAtaque() + " (" + carta.getAtaque() + " + " + ataqueBuff + ")"
				: String.valueOf(carta.getAtaque());
		String defensaMostrar = defensaBuff > 0
				? carta.getDefensa() + " (" + carta.getDefensa() + " + " + defensaBuff + ")"
				: String.valueOf(carta.getDefensa());

		areaEstadistica.setText("Nombre: " + carta.getNombre() +
				"\nAtaque: " + ataqueMostrar +
				"\nDefensa: " + defensaMostrar +
				"\nNivel: " + carta.getNivel() +
				"\nElemento: " + carta.getElemento() +
				"\nPosición: " + carta.getPosicion());
		areaEstadistica.setVisible(true);
	}

	

	public void mostrarMensajeDerrota(String mensaje, String rutaImagen) {
		ImageIcon icon = new ImageIcon(rutaImagen);
		JOptionPane.showMessageDialog(this, mensaje, "Fin del juego", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	public void monstrarMensajeGanador(String mensaje, String rutaImagen) {
		ImageIcon icon = new ImageIcon(rutaImagen);
		JOptionPane.showMessageDialog(this, mensaje, "Fin del juego", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	BackgroundPanel fondoInfo = new BackgroundPanel("src\\vista\\imagenes\\info.jpg");

	public void agregarAccionJugador(String accion) {
		String[] lineas = infoJugador.getText().split("\n");
		if (lineas.length >= 5) {
			infoJugador.setText("");
			for (int i = 1; i < lineas.length; i++) {
				infoJugador.append(lineas[i] + "\n");
			}
		}
		infoJugador.append(accion + "\n");
	}

	public void agregarAccionRival(String accion) {
		String[] lineas = infoRival.getText().split("\n");

		if (lineas.length >= 5) {
			infoRival.setText("");
			for (int i = 1; i < lineas.length; i++) {
				infoRival.append(lineas[i] + "\n");
			}
		}
		infoRival.append(accion + "\n");
	}

	public void agregarAccionTablero(String accion) {
		String[] lineas = infoTablero.getText().split("\n");

		if (lineas.length >= 5) {
			infoTablero.setText("");
			for (int i = 1; i < lineas.length; i++) {
				infoTablero.append(lineas[i] + "\n");
			}
		}
		infoTablero.append(accion + "\n");
	}

	public void ocultarEstadisticas() {
		areaEstadistica.setVisible(false);
	}

	public JButton getBtnFinalizarTurno() {
		return btnFinalizarTurno;
	}

	public Object getPanelMonstruosJugador() {
		return panelesMonstruosJugador;
	}

	public JLabel[] getLblMonstruosJugador() {
		return lblMonstruosJugador;
	}

	public JLabel[] getLblMonstruosRival() {
		return lblMonstruosRival;
	}

	public JProgressBar getBarraVidaJugador() {
		return barraVidaJugador;
	}

	public JProgressBar getBarraVidaRival() {
		return barraVidaRival;
	}

	public Component getLblBarajaJugador() {
		return lblBarajaJugador;
	}

	public Component getLblBarajaRival() {
		return lblBarajaRival;
	}

	public JLabel[] getLblCartasJugador() {
		return lblCartasJugador;
	}

	public JPanel getPanelesMonstruosRival() {
		return panelesMonstruosRival;
	}

	public void setPanelesMonstruosRival(JPanel panelesMonstruosRival) {
		this.panelesMonstruosRival = panelesMonstruosRival;
	}

	public JTextArea getAreaEstadistica() {
		return areaEstadistica;
	}

	public void setAreaEstadistica(JTextArea areaEstadistica) {
		this.areaEstadistica = areaEstadistica;
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//
//			public void run() {
//				TableroModelo modelo = new TableroModelo();
//				try {
//					VistaTabla frame = new VistaTabla(modelo);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public JLabel[] getLblCartasRival() {
		return lblCartasRival;
	}

	public JLabel[] getLblHechizosRival() {
		return lblHechizosRival;
	}

	public JLabel[] getLblHechizosJugador() {
		return lblHechizosJugador;
	}

	public FondoPanel getPanelFondo() {
		return fondo;
	}

}
