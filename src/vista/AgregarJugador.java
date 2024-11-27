package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class AgregarJugador extends JFrame {



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JPasswordField pass;
	private JPasswordField passConfimar;
	private JButton btnCrear;
	private JLabel lblMensaje;

	/**
	 * Create the frame.
	 */
	public AgregarJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarJugador.class.getResource("/vista/imagenes/calavera.png")));
		setTitle("Agregar jugador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnCrear = new JButton("Crear");
		 btnCrear.setForeground(new Color(255, 255, 255));
		 btnCrear.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));

		btnCrear.setBounds(234, 197, 107, 35);
		contentPane.add(btnCrear);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(70, 44, 99, 14);
		contentPane.add(lblNewLabel);
		
		nombre = new JTextField();
		nombre.setBounds(218, 42, 123, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(70, 87, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(218, 85, 123, 20);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Repetir contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(70, 131, 123, 14);
		contentPane.add(lblNewLabel_2);
		
		passConfimar = new JPasswordField();
		passConfimar.setBounds(218, 129, 123, 20);
		contentPane.add(passConfimar);
		
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(new Color(255, 0, 0));
		lblMensaje.setBounds(10, 172, 402, 14);
		contentPane.add(lblMensaje);
	}
	
	
	
	public JTextField getNombre() {
		return nombre;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public JPasswordField getPassConfimar() {
		return passConfimar;
	}
	public JButton getBtnCrear() {
		return btnCrear;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public JLabel getMensaje() {
		return lblMensaje;
	}
}
