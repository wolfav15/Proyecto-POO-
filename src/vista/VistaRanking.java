package vista;

import java.awt.EventQueue;
import java.util.List;
import modelo.Jugador;
import modelo.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class VistaRanking extends JFrame {

	private JPanel panel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRanking frame = new VistaRanking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRanking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		this.panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	public void mostrarRanking(List<Usuario> jugadores) {
	    panel.removeAll(); // Limpia el panel
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

	    int limite = Math.min(10, jugadores.size()); // Hasta 10 jugadores
	    for (int i = 0; i < limite; i++) {
	        Usuario jugador = jugadores.get(i);
	        JLabel jugadorLabel = new JLabel(
	            (i + 1) + ". Nombre: " + jugador.getNombre() +
	            " | Victorias: " + jugador.getContador_victorias() +
	            " | Derrotas: " + jugador.getContador_derrotas()
	        );
	        panel.add(jugadorLabel);
	    }

	    panel.revalidate(); 
	    panel.repaint();    
	}


	// Ejemplo para agregar contenido de prueba al ranking
public void agregarJugadoresDePrueba() {
    for (int i = 1; i <= 10; i++) {
        JLabel jugadorLabel = new JLabel("Jugador " + i + " - Puntos: " + (i * 10));
        panel.add(jugadorLabel);
    }
    panel.revalidate(); // Actualiza el layout del panel
    panel.repaint();    // Redibuja la vista
}



}
