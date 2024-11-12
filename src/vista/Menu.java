package vista;

import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton botonBatalla = new JButton("Batalla");
	public JButton botonReglasBatalla = new JButton("Reglas de Batalla");
	public JButton botonOpciones = new JButton("Opciones");
	public JButton botonSalirJuego = new JButton("Salir");
	
	
	
	public Menu() {
		setTitle("Juego de Cartas de Monstruos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon background = new ImageIcon("src\\archivos\\MenuPantalla.png"); // Para que la ruta sea realativa y los archivos
																								  // se debe ingresar de esa forma, imagen de ejemplo 

				g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelFondo.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Margen entre botones


		// Añadir los botones al panel de menú centrado
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelFondo.add(botonBatalla);

		gbc.gridy++;
		panelFondo.add(botonReglasBatalla);

		gbc.gridy++;
		panelFondo.add(botonOpciones);

		getContentPane().add(panelFondo, BorderLayout.CENTER);


	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Menu frame = new Menu();
			frame.setVisible(true);
		});
	}
	public JButton getBotonBatalla() {
		return botonBatalla;
	}

	public JButton getBotonReglas() {
		return botonReglasBatalla;
	}

	public JButton getBotonOpciones() {
		return botonOpciones;
	}
	
}
