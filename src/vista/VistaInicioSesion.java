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

public class VistaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoContrasenia;
	private JButton Confirma, botonCrearCuenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicioSesion frame = new VistaInicioSesion();
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
	public VistaInicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel ContenedorCampos = new JPanel();
		contentPane.add(ContenedorCampos, BorderLayout.CENTER);
		GridBagLayout gbl_ContenedorCampos = new GridBagLayout();
		gbl_ContenedorCampos.columnWidths = new int[]{118, 46, 0, 0, 86, 46, 0};
		gbl_ContenedorCampos.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ContenedorCampos.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_ContenedorCampos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ContenedorCampos.setLayout(gbl_ContenedorCampos);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		ContenedorCampos.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.anchor = GridBagConstraints.NORTH;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 1;
		ContenedorCampos.add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CONTRASEÑA");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		ContenedorCampos.add(lblNewLabel, gbc_lblNewLabel);
		
		campoContrasenia = new JPasswordField();
		GridBagConstraints gbc_campoContrasenia = new GridBagConstraints();
		gbc_campoContrasenia.gridwidth = 2;
		gbc_campoContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_campoContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContrasenia.gridx = 2;
		gbc_campoContrasenia.gridy = 2;
		ContenedorCampos.add(campoContrasenia, gbc_campoContrasenia);
		
		Confirma = new JButton("Confirmar");
		GridBagConstraints gbc_Confirma = new GridBagConstraints();
		gbc_Confirma.anchor = GridBagConstraints.WEST;
		gbc_Confirma.insets = new Insets(0, 0, 5, 5);
		gbc_Confirma.gridx = 2;
		gbc_Confirma.gridy = 4;
		ContenedorCampos.add(Confirma, gbc_Confirma);
		
		JLabel lblNewLabel_3 = new JLabel("¿No tienes usuario?");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		ContenedorCampos.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		botonCrearCuenta = new JButton("Crea una cuenta");
		GridBagConstraints gbc_BotonCrearCuenta = new GridBagConstraints();
		gbc_BotonCrearCuenta.insets = new Insets(0, 0, 0, 5);
		gbc_BotonCrearCuenta.gridx = 2;
		gbc_BotonCrearCuenta.gridy = 7;
		ContenedorCampos.add(botonCrearCuenta, gbc_BotonCrearCuenta);
		
		JLabel lblNewLabel_2 = new JLabel("INICIO SESION");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2, BorderLayout.NORTH);
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
