package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class BorrarCarta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JTextField textId;
	private JButton btnEliminar;

	public BorrarCarta() {
		setTitle("Borrar carta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BorrarCarta.class.getResource("/vista/imagenes/calavera.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("ID carta");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 68, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario administrador");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 14, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña administrador");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_2);
		
		textUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUsuario, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUsuario, -61, SpringLayout.EAST, contentPane);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textPass = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPass, 26, SpringLayout.SOUTH, textUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPass, 33, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPass, -61, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, -4, SpringLayout.NORTH, textPass);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUsuario, 0, SpringLayout.WEST, textPass);
		contentPane.add(textPass);
		
		textId = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textId, 4, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textId, 0, SpringLayout.WEST, textUsuario);
		sl_contentPane.putConstraint(SpringLayout.EAST, textId, 0, SpringLayout.EAST, textUsuario);
		textId.setColumns(10);
		contentPane.add(textId);
		
		btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, -91, SpringLayout.EAST, textUsuario);
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 16, SpringLayout.SOUTH, textPass);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 55, SpringLayout.SOUTH, textPass);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 0, SpringLayout.EAST, textUsuario);
		contentPane.add(btnEliminar);
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JTextField getTextId() {
		return textId;
	}
	public JTextField getTextUsuario() {
		return textUsuario;
	}
	public JPasswordField getTextPass() {
		return textPass;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
