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

public class BorrarCarta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JTextField textId;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarCarta frame = new BorrarCarta();
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
	public BorrarCarta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("ID carta");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 68, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario administrador");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña administrador");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 24, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_2);
		
		textUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textUsuario, -3, SpringLayout.NORTH, lblNewLabel_1);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textPass = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textPass, 15, SpringLayout.SOUTH, textUsuario);
		sl_contentPane.putConstraint(SpringLayout.EAST, textUsuario, 0, SpringLayout.EAST, textPass);
		sl_contentPane.putConstraint(SpringLayout.WEST, textUsuario, 0, SpringLayout.WEST, textPass);
		sl_contentPane.putConstraint(SpringLayout.WEST, textPass, 11, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textPass, 109, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(textPass);
		
		textId = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textId, 0, SpringLayout.WEST, textUsuario);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textId, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textId, 0, SpringLayout.EAST, textUsuario);
		textId.setColumns(10);
		contentPane.add(textId);
		
		btnEliminar = new JButton("Eliminar");

		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 32, SpringLayout.SOUTH, textPass);
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
