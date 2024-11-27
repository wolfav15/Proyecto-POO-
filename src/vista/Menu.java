package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame {

	
	private static final long serialVersionUID = 1L;
	public JButton botonBatalla = new JButton("Batalla");
	public JButton botonReglasBatalla = new JButton("Reglas");
	public JButton botonOpciones = new JButton("Opciones");
	public JButton botonSalirJuego = new JButton("Salir");
	
	
	
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/vista/imagenes/calavera.png")));
		JFrame.setDefaultLookAndFeelDecorated(true);
		setTitle("Monster Attack");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon background = new ImageIcon("src\\vista\\imagenes\\fondoMenu.jpg"); // Cambia la
																											// ruta a tu
																											// imagen si
																											// quieren
																											// meter
																											// fondo
				g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Margen entre botones


		// Añadir los botones al panel de menú centrado
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelFondo.setLayout(null);
		botonBatalla.setForeground(new Color(255, 255, 255));
		botonBatalla.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		botonBatalla.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		botonBatalla.setBounds(328, 159, 115, 55);
		panelFondo.add(botonBatalla);

		gbc.gridy++;
		botonReglasBatalla.setForeground(new Color(255, 255, 255));
		botonReglasBatalla.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		botonReglasBatalla.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		botonReglasBatalla.setBounds(328, 236, 115, 55);
		panelFondo.add(botonReglasBatalla);

		gbc.gridy++;
		botonOpciones.setForeground(new Color(255, 255, 255));
		botonOpciones.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		botonOpciones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		botonOpciones.setBounds(328, 310, 115, 64);
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
