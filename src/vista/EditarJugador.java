package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNuevoNombre;
	private JPasswordField passField;
	private JPasswordField passFieldNuevo;
	private JButton btnEditar;
	private JButton btnEditarAlternativo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarJugador frame = new EditarJugador();
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
	public EditarJugador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEditar = new JButton("Editar");

		btnEditar.setBounds(78, 216, 89, 23);
		contentPane.add(btnEditar);
		
		btnEditarAlternativo = new JButton("Editar y reiniciar contadores");
		btnEditarAlternativo.setBounds(201, 216, 178, 23);
		contentPane.add(btnEditarAlternativo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(78, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(191, 40, 188, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo nombre");
		lblNuevoNombre.setBounds(78, 74, 103, 14);
		contentPane.add(lblNuevoNombre);
		
		textNuevoNombre = new JTextField();
		textNuevoNombre.setColumns(10);
		textNuevoNombre.setBounds(191, 71, 188, 20);
		contentPane.add(textNuevoNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(78, 105, 103, 14);
		contentPane.add(lblContrasea);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(191, 102, 188, 20);
		contentPane.add(passField);
		
		JLabel lblContraseaNueva = new JLabel("Contraseña nueva");
		lblContraseaNueva.setBounds(78, 140, 103, 14);
		contentPane.add(lblContraseaNueva);
		
		passFieldNuevo = new JPasswordField();
		passFieldNuevo.setColumns(10);
		passFieldNuevo.setBounds(191, 137, 188, 20);
		contentPane.add(passFieldNuevo);
	}
	
	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEditarAlternativo() {
		return btnEditarAlternativo;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public JTextField getNombre() {
		return textNombre;
	}
	public JTextField getNombreNuevo() {
		return textNuevoNombre;
	}
	public JPasswordField getPass() {
		return passField;
	}
	public JPasswordField getPassNuevo() {
		return passFieldNuevo;
	}
}
