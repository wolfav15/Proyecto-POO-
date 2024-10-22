import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ModeloTabla extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeloTabla frame = new ModeloTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ModeloTabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 568);
		getContentPane().setLayout(null);
		
	
		
		JLabel lblMonstruoRival_1 = new JLabel("Monstruo 1");
		lblMonstruoRival_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruoRival_1.setBounds(245, 70, 70, 101);
		getContentPane().add(lblMonstruoRival_1);
		
		JLabel lblMonstruoRival_2 = new JLabel("Monstruo 2");
		lblMonstruoRival_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruoRival_2.setBounds(165, 70, 70, 101);
		getContentPane().add(lblMonstruoRival_2);
		
		JLabel lblMonstruoRival_3 = new JLabel("Monstruo 3");
		lblMonstruoRival_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruoRival_3.setBounds(325, 70, 70, 101);
		getContentPane().add(lblMonstruoRival_3);
		
		JLabel lblMonstruoRival_4 = new JLabel("Monstruo 4");
		lblMonstruoRival_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruoRival_4.setBounds(405, 70, 70, 101);
		getContentPane().add(lblMonstruoRival_4);
		
		JLabel lblMonstruoRival_5 = new JLabel("Monstruo 5");
		lblMonstruoRival_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruoRival_5.setBounds(495, 70, 70, 101);
		getContentPane().add(lblMonstruoRival_5);
		
		JLabel lblMonstruo = new JLabel("Monstruo 1");
		lblMonstruo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruo.setBounds(200, 332, 70, 104);
		getContentPane().add(lblMonstruo);
		
		JLabel lblMonstruo_1 = new JLabel("Monstruo 2");
		lblMonstruo_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruo_1.setBounds(289, 332, 70, 104);
		getContentPane().add(lblMonstruo_1);
		
		JLabel lblMonstruo_2 = new JLabel("Monstruo 3");
		lblMonstruo_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruo_2.setBounds(375, 332, 70, 104);
		getContentPane().add(lblMonstruo_2);
		
		JLabel lblMonstruo_3 = new JLabel("Monstruo 4");
		lblMonstruo_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruo_3.setBounds(471, 332, 70, 104);
		getContentPane().add(lblMonstruo_3);
		
		JLabel lblMonstruo_5 = new JLabel("Monstruo 5");
		lblMonstruo_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonstruo_5.setBounds(562, 332, 70, 104);
		getContentPane().add(lblMonstruo_5);
		
		JLabel lblHechizo_1 = new JLabel("Hechizo");
		lblHechizo_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizo_1.setBounds(590, 426, 76, 100);
		getContentPane().add(lblHechizo_1);
		
		JLabel lblHechizo_2 = new JLabel("Hechizo");
		lblHechizo_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizo_2.setBounds(752, 426, 76, 100);
		getContentPane().add(lblHechizo_2);
		
		JLabel lblHechizo_3 = new JLabel("Hechizo");
		lblHechizo_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizo_3.setBounds(946, 426, 76, 100);
		getContentPane().add(lblHechizo_3);
		
		JLabel lblHechizoRival_1 = new JLabel("Hechizo rival");
		lblHechizoRival_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizoRival_1.setBounds(606, 196, 76, 100);
		getContentPane().add(lblHechizoRival_1);
		
		
		JLabel lblVidaJugador = new JLabel("");
		lblVidaJugador.setIcon(new ImageIcon("C:\\Users\\samue\\Downloads\\barra vidapng (1).png"));
		lblVidaJugador.setBounds(10, 477, 150, 41);
		getContentPane().add(lblVidaJugador);
		
		JButton btnFinalizarTurno = new JButton("Finalizar turno\r\n");
		btnFinalizarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinalizarTurno.setBounds(47, 243, 123, 23);
		getContentPane().add(btnFinalizarTurno);
		
		JLabel lblBaraja = new JLabel("BARAJA");
		lblBaraja.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBaraja.setForeground(new Color(0, 0, 0));
		lblBaraja.setBounds(637, 198, 81, 113);
		getContentPane().add(lblBaraja);
		
		JLabel lblCartasJugador = new JLabel("Cartas del Jugador");
		lblCartasJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartasJugador.setBounds(336, 451, 184, 67);
		getContentPane().add(lblCartasJugador);
		
		JLabel lblVidaJugador_1 = new JLabel("");
		lblVidaJugador_1.setIcon(new ImageIcon("C:\\Users\\samue\\Downloads\\barra vidapng (1).png"));
		lblVidaJugador_1.setBounds(644, 70, 150, 41);
		getContentPane().add(lblVidaJugador_1);

		JLabel lblBarajaRival = new JLabel("BARAJA RIVAL");
		lblBarajaRival.setForeground(Color.BLACK);
		lblBarajaRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarajaRival.setBounds(239, 66, 81, 113);
		getContentPane().add(lblBarajaRival);
		
		JLabel lblHechizoRival_1_1 = new JLabel("Hechizo rival");
		lblHechizoRival_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizoRival_1_1.setBounds(750, 200, 76, 100);
		getContentPane().add(lblHechizoRival_1_1);
		
		JLabel lblHechizoRival_1_2 = new JLabel("Hechizo rival");
		lblHechizoRival_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHechizoRival_1_2.setBounds(912, 196, 76, 100);
		getContentPane().add(lblHechizoRival_1_2);
		
                JButton btnSalir= new JButton("Salir Batalla");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(1176, 363, 89, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblCementerio = new JLabel("Cementerio");
		lblCementerio.setBounds(217, 420, 131, 113);
		lblCementerio.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lblCementerio);
		
		JLabel lblCementerioRival = new JLabel("Cementerio Rival");
		lblCementerioRival.setBounds(239, 186, 131, 110);
		lblCementerioRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lblCementerioRival);
		
		JLabel lblCartaRival = new JLabel("Carta Rival");
		lblCartaRival.setForeground(new Color(0, 0, 0));
		lblCartaRival.setBounds(700, 11, 89, 41);
		lblCartaRival.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lblCartaRival);
		
	}
}
