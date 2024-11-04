package menu;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
	
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
                ImageIcon background = new ImageIcon("C:\\Users\\samue\\Desktop\\momazos\\descargar.jpg"); // Cambia la ruta a tu imagen si quieren meter fondo
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre botones
        JButton botonBatalla = new JButton ("Batalla");
        JButton botonReglasBatalla = new JButton("Reglas de Batalla");
        JButton botonOpciones = new JButton("Opciones");
        JButton botonSalirJuego = new JButton("Salir");
      

        // Añadir los botones al panel de menú centrado
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFondo.add(botonBatalla, gbc);
    
        gbc.gridy++;
        panelFondo.add(botonReglasBatalla, gbc);

        
        gbc.gridy++;
        panelFondo.add(botonOpciones, gbc);
        
        gbc.gridy++;
        panelFondo.add(botonSalirJuego, gbc);

        getContentPane().add(panelFondo, BorderLayout.CENTER);

       //  Acción para Mostrar batalla
    
		botonBatalla.addActionListener(e -> {
			MenuBatalla menubatalla= new MenuBatalla();
			menubatalla.setVisible(true);
            dispose();
	});

        // Acción para Reglas de Batalla
        botonReglasBatalla.addActionListener(e -> mostrarMensaje("Mostrando Reglas de Batalla"));

        // Acción para Dificultad
        botonOpciones.addActionListener(e -> {
        	MenuOpciones menuopciones = new MenuOpciones();
        	menuopciones.setVisible(true);
            dispose();
        
        });

        // Acción para Salir
        botonSalirJuego.addActionListener(e -> {dispose();});
    }
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu frame =new Menu();
            frame.setVisible(true);
        });
    }
}
