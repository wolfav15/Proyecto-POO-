package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Color;

public class VistaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoContrasenia;
	private JButton Confirma, botonCrearCuenta;

	public VistaInicioSesion() {
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel ContenedorCampos = new JPanel();
		contentPane.add(ContenedorCampos, BorderLayout.CENTER);
		SpringLayout sl_ContenedorCampos = new SpringLayout();
		ContenedorCampos.setLayout(sl_ContenedorCampos);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, lblNewLabel_1, 78, SpringLayout.WEST, ContenedorCampos);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		ContenedorCampos.add(lblNewLabel_1);
		
		campoUsuario = new JTextField();
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, campoUsuario, 30, SpringLayout.NORTH, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, campoUsuario, 216, SpringLayout.WEST, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.EAST, campoUsuario, -65, SpringLayout.EAST, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, lblNewLabel_1, -2, SpringLayout.NORTH, campoUsuario);
		ContenedorCampos.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CONTRASEÑA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.SOUTH, lblNewLabel_1);
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, lblNewLabel, 78, SpringLayout.WEST, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.EAST, lblNewLabel, -214, SpringLayout.EAST, ContenedorCampos);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		ContenedorCampos.add(lblNewLabel);
		
		campoContrasenia = new JPasswordField();
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, campoContrasenia, 4, SpringLayout.NORTH, lblNewLabel);
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, campoContrasenia, 216, SpringLayout.WEST, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.EAST, campoContrasenia, 0, SpringLayout.EAST, campoUsuario);
		ContenedorCampos.add(campoContrasenia);
		
		Confirma = new JButton("Confirmar");
		Confirma.setForeground(new Color(255, 255, 255));
		Confirma.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, Confirma, 19, SpringLayout.SOUTH, campoContrasenia);
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, Confirma, 0, SpringLayout.WEST, campoUsuario);
		sl_ContenedorCampos.putConstraint(SpringLayout.EAST, Confirma, -115, SpringLayout.EAST, ContenedorCampos);
		ContenedorCampos.add(Confirma);
		
		JLabel lblNewLabel_3 = new JLabel("¿No tienes usuario?");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 202, SpringLayout.NORTH, ContenedorCampos);
		sl_ContenedorCampos.putConstraint(SpringLayout.SOUTH, lblNewLabel, -113, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		ContenedorCampos.add(lblNewLabel_3);
		
		botonCrearCuenta = new JButton("Crea una cuenta");
		botonCrearCuenta.setForeground(new Color(255, 255, 255));
		botonCrearCuenta.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		sl_ContenedorCampos.putConstraint(SpringLayout.SOUTH, Confirma, -69, SpringLayout.NORTH, botonCrearCuenta);
		sl_ContenedorCampos.putConstraint(SpringLayout.EAST, lblNewLabel_3, -22, SpringLayout.WEST, botonCrearCuenta);
		sl_ContenedorCampos.putConstraint(SpringLayout.NORTH, botonCrearCuenta, -1, SpringLayout.NORTH, lblNewLabel_3);
		sl_ContenedorCampos.putConstraint(SpringLayout.WEST, botonCrearCuenta, 0, SpringLayout.WEST, campoUsuario);
		ContenedorCampos.add(botonCrearCuenta);
	}
	
	public JButton getBotonLogin() {
	    return Confirma; 
	}

	public JTextField getCampoUsuario() {
	    return campoUsuario; 
	}

	public JPasswordField getCampoContra() {
	    return campoContrasenia; 
	}
	
	public JButton getBotonCrearCuenta() {
	    return botonCrearCuenta; 
	}


}
