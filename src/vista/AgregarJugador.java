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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnCrear = new JButton("Crear");

		btnCrear.setBounds(10, 227, 89, 23);
		btnCrear.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(btnCrear);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		nombre = new JTextField();
		nombre.setBounds(143, 23, 99, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(10, 67, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBounds(143, 64, 99, 20);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Repetir contraseña");
		lblNewLabel_2.setBounds(10, 115, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		passConfimar = new JPasswordField();
		passConfimar.setBounds(143, 112, 99, 20);
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
