package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class EditarTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUrl;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JLabel ImagenLbl;
	private JComboBox boxElemento;
	
	private JButton btnPrevisualizar;
	private JButton btnEditar;
	private JButton btnBuscar;
	private JTextField textId;
	
	public EditarTablero() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarTablero.class.getResource("/vista/imagenes/calavera.png")));
		setTitle("Editar tablero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -406, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -21, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 659, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 100, 327, 274);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		ImagenLbl = new JLabel("");
		ImagenLbl.setBounds(0, 5, 327, 258);
		panel_2.add(ImagenLbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 11, 265, 363);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Elemento");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -300, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -211, SpringLayout.EAST, panel_1);
		panel_1.add(lblNewLabel);
		
		boxElemento = new JComboBox();
		boxElemento.setForeground(new Color(255, 255, 255));
		boxElemento.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, boxElemento, -3, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, boxElemento, 6, SpringLayout.EAST, lblNewLabel);
		boxElemento.setModel(new DefaultComboBoxModel(new String[] {"WATER", "EARTH", "WIND", "FIRE", "DARK", "LIGHT"}));
		panel_1.add(boxElemento);
		
		JLabel lblNewLabel_1 = new JLabel("URL");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_1);
		
		textUrl = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textUrl, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, textUrl, 0, SpringLayout.WEST, boxElemento);
		sl_panel_1.putConstraint(SpringLayout.EAST, textUrl, -23, SpringLayout.EAST, panel_1);
		panel_1.add(textUrl);
		textUrl.setColumns(10);
		
		btnPrevisualizar = new JButton("Previsualizar");
		btnPrevisualizar.setForeground(new Color(255, 255, 255));
		btnPrevisualizar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnPrevisualizar, 6, SpringLayout.SOUTH, textUrl);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnPrevisualizar, 137, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnPrevisualizar, 0, SpringLayout.EAST, textUrl);
		panel_1.add(btnPrevisualizar);
		
		JLabel lblNewLabel_2 = new JLabel("Solo administradores pueden agregar taleros");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 27, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pass");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3_1, 17, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3_1, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_3_1);
		
		textUsuario = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -24, SpringLayout.NORTH, textUsuario);
		sl_panel_1.putConstraint(SpringLayout.WEST, textUsuario, 0, SpringLayout.WEST, boxElemento);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textUsuario, -69, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textUsuario, 86, SpringLayout.WEST, boxElemento);
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);
		
		textPass = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textPass, 11, SpringLayout.SOUTH, textUsuario);
		sl_panel_1.putConstraint(SpringLayout.WEST, textPass, 0, SpringLayout.WEST, boxElemento);
		sl_panel_1.putConstraint(SpringLayout.EAST, textPass, -119, SpringLayout.EAST, panel_1);
		panel_1.add(textPass);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnEditar, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnEditar, -23, SpringLayout.EAST, panel_1);
		panel_1.add(btnEditar);
		
		JLabel lblNewLabel_4 = new JLabel("Buscar por ID");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 11, 80, 14);
		panel.add(lblNewLabel_4);
		
		textId = new JTextField();
		textId.setBounds(97, 8, 86, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		btnBuscar.setBounds(97, 36, 89, 23);
		panel.add(btnBuscar);
	}
	
	public JComboBox getBoxElemento() {
		return boxElemento;
	}
	public JTextField getTextUrl() {
		return textUrl;
		
	}
	public JTextField getTextId() {
		return textId;
		
	}
	public JTextField getTextUsuario() {
		return textUsuario;
	}
	public JPasswordField getPasswordField() {
		return textPass;
	}

	public JLabel getImagenLbl() {
		return ImagenLbl;
	}


	public JButton getBtnPrevisualizar() {
		return btnPrevisualizar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}



}
