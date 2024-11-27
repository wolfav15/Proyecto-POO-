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
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class EditarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNuevoNombre;
	private JPasswordField passField;
	private JPasswordField passFieldNuevo;
	private JButton btnEditar;
	private JButton btnEditarAlternativo;
	
	public EditarJugador() {
		setTitle("Editar jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarJugador.class.getResource("/vista/imagenes/calavera.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));

		btnEditar.setBounds(62, 216, 89, 23);
		contentPane.add(btnEditar);
		
		btnEditarAlternativo = new JButton("Editar y reiniciar contadores");
		btnEditarAlternativo.setForeground(new Color(255, 255, 255));
		btnEditarAlternativo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		btnEditarAlternativo.setBounds(174, 216, 205, 23);
		contentPane.add(btnEditarAlternativo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 43, 89, 14);
		contentPane.add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(191, 40, 188, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo nombre");
		lblNuevoNombre.setForeground(new Color(255, 255, 255));
		lblNuevoNombre.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lblNuevoNombre.setBounds(62, 74, 119, 14);
		contentPane.add(lblNuevoNombre);
		
		textNuevoNombre = new JTextField();
		textNuevoNombre.setColumns(10);
		textNuevoNombre.setBounds(191, 71, 188, 20);
		contentPane.add(textNuevoNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lblContrasea.setBounds(62, 105, 119, 14);
		contentPane.add(lblContrasea);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(191, 102, 188, 20);
		contentPane.add(passField);
		
		JLabel lblContraseaNueva = new JLabel("Contraseña nueva");
		lblContraseaNueva.setForeground(new Color(255, 255, 255));
		lblContraseaNueva.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lblContraseaNueva.setBounds(62, 140, 119, 14);
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
