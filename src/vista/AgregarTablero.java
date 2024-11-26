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

public class AgregarTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUrl;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JLabel ImagenLbl;
	private JComboBox boxElemento;
	
	public JComboBox getBoxElemento() {
		return boxElemento;
	}
	public JTextField getTextUrl() {
		return textUrl;
		
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



	public JButton getBtnAgregar() {
		return btnAgregar;
	}



	private JButton btnPrevisualizar;
	private JButton btnAgregar;
	


	public AgregarTablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		panel_2.setBounds(10, 45, 327, 274);
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
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -300, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -211, SpringLayout.EAST, panel_1);
		panel_1.add(lblNewLabel);
		
		boxElemento = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, boxElemento, -3, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, boxElemento, 6, SpringLayout.EAST, lblNewLabel);
		boxElemento.setModel(new DefaultComboBoxModel(new String[] {"WATER", "EARTH", "WIND", "FIRE", "DARK", "LIGHT"}));
		panel_1.add(boxElemento);
		
		JLabel lblNewLabel_1 = new JLabel("URL");
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnPrevisualizar, 6, SpringLayout.SOUTH, textUrl);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnPrevisualizar, 137, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnPrevisualizar, 0, SpringLayout.EAST, textUrl);
		panel_1.add(btnPrevisualizar);
		
		JLabel lblNewLabel_2 = new JLabel("Solo administradores pueden agregar taleros");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 27, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pass");
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
		
		btnAgregar = new JButton("Agregar");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnAgregar, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnAgregar, -23, SpringLayout.EAST, panel_1);
		panel_1.add(btnAgregar);
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
}
