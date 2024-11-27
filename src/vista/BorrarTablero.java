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

public class BorrarTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnBorrar;
	private JLabel lblNewLabel_1;
	private JTextField textId;


	public BorrarTablero() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(33, 67, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblPass.setHorizontalAlignment(SwingConstants.LEFT);
		lblPass.setBounds(33, 107, 103, 14);
		contentPane.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(171, 66, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 106, 131, 20);
		contentPane.add(passwordField);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));

		btnBorrar.setBounds(171, 148, 103, 39);
		contentPane.add(btnBorrar);
		
		lblNewLabel_1 = new JLabel("ID Tablero");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 28, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(171, 27, 53, 20);
		contentPane.add(textId);
	}

	public JTextField getTextId() {
		return textId;
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
