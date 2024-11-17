package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class VistaRanking extends JFrame {

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
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	public void mostrarRanking(List<Jugador> jugadores) {
	    panel.removeAll(); // Limpia el panel
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

	    int limite = Math.min(10, jugadores.size()); // Hasta 10 jugadores
	    for (int i = 0; i < limite; i++) {
	        Jugador jugador = jugadores.get(i);
	        JLabel jugadorLabel = new JLabel(
	            (i + 1) + ". Nombre: " + jugador.getNombre() +
	            " | Victorias: " + jugador.getVictorias() +
	            " | Derrotas: " + jugador.getDerrotas()
	        );
	        panel.add(jugadorLabel);
	    }

	    panel.revalidate(); 
	    panel.repaint();    
	}


}
