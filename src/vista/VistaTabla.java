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
import vista.MenuBatalla;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JTextArea infoRival;
	
	private JTextArea infoTablero;


	private static final long serialVersionUID = 1L;

	public VistaTabla() {
		setTitle("Tablero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;

		// Paneles de monstruos rivales
		JPanel panelMonstruosRival = new JPanel(new GridLayout(1, 5, 10, 0));
		lblMonstruosRival = new JLabel[5];
		for (int i = 0; i < lblMonstruosRival.length; i++) {
			lblMonstruosRival[i] = crearLabel("Monstruo " + (i + 1), new Dimension(70, 105));
			panelMonstruosRival.add(lblMonstruosRival[i]);
		}

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 0;
		add(panelMonstruosRival, gbc);

		// Paneles de monstruos del jugador
		JPanel panelMonstruosJugador = new JPanel(new GridLayout(1, 5, 10, 0));
		lblMonstruosJugador = new JLabel[5];
		for (int i = 0; i < lblMonstruosJugador.length; i++) {
			lblMonstruosJugador[i] = crearLabel("Monstruo " + (i + 1), new Dimension(70, 105));
			panelMonstruosJugador.add(lblMonstruosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = -3;
		add(panelMonstruosJugador, gbc);

		// Paneles de hechizos rivales
		JPanel panelHechizosRival = new JPanel(new GridLayout(1, 3, 10, 0));
		lblHechizosRival = new JLabel[3];
		for (int i = 0; i < lblHechizosRival.length; i++) {
			lblHechizosRival[i] = crearLabel("Hechizo " + (i + 1), new Dimension(70, 105));
			panelHechizosRival.add(lblHechizosRival[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		add(panelHechizosRival, gbc);

		// Paneles de hechizos del jugador
		JPanel panelHechizosJugador = new JPanel(new GridLayout(1, 3, 10, 0));
		lblHechizosJugador = new JLabel[3];
		for (int i = 0; i < lblHechizosJugador.length; i++) {
			lblHechizosJugador[i] = crearLabel("Hechizo " + (i + 1), new Dimension(70, 105));
			panelHechizosJugador.add(lblHechizosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 0;
		add(panelHechizosJugador, gbc);

		barraVidaJugador = new JProgressBar(0, 8000);
		barraVidaJugador.setValue(8000);
		barraVidaJugador.setStringPainted(true);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		add(barraVidaJugador, gbc);

		barraVidaRival = new JProgressBar(0, 8000);
		barraVidaRival.setValue(8000);
		barraVidaRival.setStringPainted(true);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(barraVidaRival, gbc);

		btnFinalizarTurno = new JButton("Finalizar turno");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		add(btnFinalizarTurno, gbc);

		lblBarajaJugador = new JLabel("BARAJA");
		lblBarajaJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarajaJugador.setPreferredSize(new Dimension(100, 150));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblBarajaJugador, gbc);

		lblBarajaRival = new JLabel("BARAJA RIVAL");
		lblBarajaRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarajaRival.setPreferredSize(new Dimension(100, 150));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblBarajaRival, gbc);

		JPanel panelCartasJugador = new JPanel(new GridLayout(1, 5, 10, 0));
		lblCartasJugador = new JLabel[5];
		for (int i = 0; i < lblCartasJugador.length; i++) {
			lblCartasJugador[i] = crearLabel("Carta " + (i + 1), new Dimension(70, 105));
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
			lblCartasRival[i] = crearLabel("Carta " + (i + 1), new Dimension(70, 105));
			panelCartasRival.add(lblCartasRival[i]);
		}

		JButton btnSalir = new JButton("Salir Batalla");
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(btnSalir, gbc);

		areaEstadistica = new JTextArea(5, 20);
		areaEstadistica.setEditable(false);
		areaEstadistica.setBorder(new LineBorder(new Color(0, 0, 0)));
		areaEstadistica.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 4;

		add(areaEstadistica, gbc);
		btnSalir.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuBatalla menuBatalla = new MenuBatalla();
				menuBatalla.setVisible(true);
			}
		});

		infoJugador = new JTextArea(5, 20);
		infoJugador.setEditable(false);
	
		gbc.gridx = 1;
		gbc.gridy = 3;

	add(infoJugador, gbc);

		infoRival = new JTextArea(5, 20);
		infoRival.setEditable(false);
	
		gbc.gridx = 2;
		gbc.gridy = 0;

		add(infoRival, gbc);

		infoTablero = new JTextArea(5, 20);
		infoTablero.setEditable(false);
	
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;

		add(infoTablero, gbc);
	}

	private JLabel crearLabel(String nombre, Dimension dimension) {
		JLabel label = new JLabel(nombre);
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(dimension);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		return label;
	}

	public void mostrarEstadisticasMonstruo(CartaMounstro carta) {
		areaEstadistica.setText("Nombre: " + carta.getNombre() + "\nAtaque: " + carta.getAtaque() + "\nDefensa: "
				+ carta.getDefensa() + "\nNivel: " + carta.getNivel() + "\nAtributo: " + carta.getAtributo()
				+ "\nPosicion: " + carta.getPosicion());
		areaEstadistica.setVisible(true);
	}

	public void mostrarEstadisticasHechizo(CartaMagica carta) {
		areaEstadistica.setText("Nombre: " + carta.getNombre() + "\nEfecto: " + carta.getCantidad_efecto() +
				"\nTipo " + carta.getClass().getSimpleName() +
				"\nDescripcion: " + carta.getDescripcion());
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
				"\nAtributo: " + carta.getAtributo() +
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					VistaTabla frame = new VistaTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JLabel[] getLblCartasRival() {
		return lblCartasRival;
	}

	public JLabel[] getLblHechizosRival() {
		return lblHechizosRival;
	}

	public JLabel[] getLblHechizosJugador() {
		return lblHechizosJugador;
	}

}
