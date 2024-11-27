package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuBatalla extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botonMostrarTabla = new JButton("Mostrar Tablas");
	private JButton botonCpuJugador = new JButton("Batalla contra CPU o Jugador");
	private JButton botonMostrarMazo = new JButton("Mostrar Mazo");
	
	
	public MenuBatalla() {
		setTitle("BIENVENIDO A LAS BATALLAS LEGENDARIAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("BIENVENIDO A LOS COMBATES");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_botonCpuJugador = new GridBagConstraints();
		gbc_botonCpuJugador.insets = new Insets(10, 0, 10, 0);
		gbc_botonCpuJugador.gridx = 0;
		gbc_botonCpuJugador.gridy = 2;
		contentPane.add(botonCpuJugador, gbc_botonCpuJugador);
		
		
		GridBagConstraints gbc_botonMostrarTabla = new GridBagConstraints();
		gbc_botonMostrarTabla.insets = new Insets(10, 0, 10, 0);
		gbc_botonMostrarTabla.gridx = 0;
		gbc_botonMostrarTabla.gridy = 1;
		contentPane.add(botonMostrarTabla, gbc_botonMostrarTabla);

		
		GridBagConstraints gbc_botonMostrarMazo = new GridBagConstraints();
		gbc_botonMostrarMazo.insets = new Insets(10, 0, 10, 0);
		gbc_botonMostrarMazo.gridx = 0;
		gbc_botonMostrarMazo.gridy = 3;
		contentPane.add(botonMostrarMazo, gbc_botonMostrarMazo);

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public JButton getBotonMostrarTablas() {
		return botonMostrarTabla;
	}
	public JButton getBotonCpuJugador() {
			return botonCpuJugador;
	}
	public JButton getBotonMostrarMazo() {
		return botonMostrarMazo;
	}
}
