package tabla;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class VistaTabla extends JFrame {
	private JPanel[] panelesMonstruosRival;
	private JPanel[] panelesMonstruosJugador;
	private JPanel panelesHechizosRival;
	private JPanel panelesHechizosJugador;
	private JButton btnFinalizarTurno;
	private JLabel[] lblMonstruosRival;
	private JLabel[] lblMonstruosJugador;
	private JLabel[] lblHechizosRival;
	private JProgressBar barraVidaJugador;
	private JProgressBar barraVidaRival;
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
			lblMonstruosRival[i] = crearLabel("Monstruo " + (i + 1), new Dimension(70, 101));
			panelMonstruosRival.add(lblMonstruosRival[i]);
		}

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelMonstruosRival, gbc);

		// Paneles de monstruos del jugador
		JPanel panelMonstruosJugador = new JPanel(new GridLayout(1, 5, 10, 0));
		lblMonstruosJugador = new JLabel[5];
		for (int i = 0; i < lblMonstruosJugador.length; i++) {
			lblMonstruosJugador[i] = crearLabel("Monstruo " + (i + 1), new Dimension(200, 400));
			panelMonstruosJugador.add(lblMonstruosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = -3;
		add(panelMonstruosJugador, gbc);

		// Paneles de hechizos rivales
		JPanel panelHechizosRival = new JPanel(new GridLayout(1, 3, 10, 0));
		lblHechizosRival = new JLabel[3];
		for (int i = 0; i < lblHechizosRival.length; i++) {
			lblHechizosRival[i] = crearLabel("Monstruo " + (i + 1), new Dimension(70, 101));
			panelHechizosRival.add(lblHechizosRival[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		add(panelHechizosRival, gbc);

		// Paneles de hechizos del jugador
		JPanel panelHechizosJugador = new JPanel(new GridLayout(1, 3, 10, 0));
		JLabel[] lblHechizosJugador = new JLabel[3];
		for (int i = 0; i < lblHechizosJugador.length; i++) {
			lblHechizosJugador[i] = crearLabel("Hechizo " + (i + 1), new Dimension(70, 101));
			panelHechizosJugador.add(lblHechizosJugador[i]);
		}
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 0;
		add(panelHechizosJugador, gbc);

		JProgressBar barraVidaJugador = new JProgressBar(0, 8000);
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

		JButton btnFinalizarTurno = new JButton("Finalizar turno");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		add(btnFinalizarTurno, gbc);

		JLabel lblBaraja = new JLabel("BARAJA");
		lblBaraja.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBaraja.setPreferredSize(new Dimension(100, 150));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblBaraja, gbc);

		JLabel lblCartasJugador = new JLabel("Cartas del Jugador");
		lblCartasJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartasJugador.setPreferredSize(new Dimension(100, 150));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 0;
		add(lblCartasJugador, gbc);

		JButton btnSalir = new JButton("Salir Batalla");
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(btnSalir, gbc);

		JLabel lblCementerio = new JLabel("Cementerio");
		lblCementerio.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCementerio.setPreferredSize(new Dimension(100, 100));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblCementerio, gbc);
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

	public Object getBtnFinalizarTurno() {
		return btnFinalizarTurno;
	}

	public Object[] getPanelMonstruosJugador() {
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

}

