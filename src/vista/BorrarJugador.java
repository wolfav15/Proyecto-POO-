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

public class BorrarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnBorrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarJugador frame = new BorrarJugador();
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
	public BorrarJugador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setBounds(10, 70, 46, 14);
		contentPane.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(88, 27, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 67, 131, 20);
		contentPane.add(passwordField);
		
		btnBorrar = new JButton("Borrar");

		btnBorrar.setBounds(88, 115, 89, 23);
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
