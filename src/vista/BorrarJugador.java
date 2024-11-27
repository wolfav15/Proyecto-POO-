package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class BorrarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnBorrar;

	public BorrarJugador() {
		setTitle("Borrar jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BorrarJugador.class.getResource("/vista/imagenes/calavera.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(66, 57, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setForeground(new Color(255, 255, 255));
		lblPass.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		lblPass.setBounds(67, 100, 106, 14);
		contentPane.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(211, 56, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 99, 131, 20);
		contentPane.add(passwordField);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));

		btnBorrar.setBounds(242, 159, 100, 32);
		contentPane.add(btnBorrar);
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	public JTextField getNombre() {
		return textField;
	}
	public JPasswordField getPass() {
		return passwordField;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
