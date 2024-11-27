package vista;

import javax.swing.border.EmptyBorder;

//import modelo.ReproductorMusica;

import javax.swing.*;
import java.awt.*;

public class MenuOpciones extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton botonDificultad = new JButton("Dificultad");
	private JButton botonSalir = new JButton("Salir");
	private JButton botonReproducirMusica = new JButton("Reproducir Música");
	private JButton botonPararMusica = new JButton("Parar Música");
	
	private JButton botonABMJugadores = new JButton("Jugadores");
	private JButton botonABMCartas = new JButton("Cartas");
	private JButton botonABMTableros = new JButton("Tableros");
	
	
	public MenuOpciones() {
		setTitle("Opciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon background = new ImageIcon("src\\vista\\imagenes\\fondoOpciones.jpg"); // Cambia la
																											// ruta a tu
																											// imagen si
																											// quieren
																											// meter
																											// fondo
				g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Margen entre botones

		// Añadir los botones al panel de menú centrado
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridy++;
		contentPane.add(botonABMJugadores, gbc);
		
		gbc.gridy++;
		contentPane.add(botonABMCartas, gbc);
		
		gbc.gridy++;
		contentPane.add(botonABMTableros, gbc);

		gbc.gridy++;
		contentPane.add(botonSalir, gbc);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}


	public JButton getBotonSalir() {
		return botonSalir;
	}

	public JButton getBotonPararMusica() {
		return botonPararMusica;
	}
	
	public JButton getBotonReproducirMusica() {
		return botonReproducirMusica;
	}
	
	public JButton getBotonDificultad() {
		return botonDificultad;
	}
	
	public JButton getBotonABMJugadores() {
		return botonABMJugadores;
	}

	public JButton getBotonABMCartas() {
		return botonABMCartas;
	}
	public JButton getBotonABMTableros() {
		return botonABMTableros;
	}

}
