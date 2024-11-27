package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class EditarCarta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDefensa;
	private JTextField textAtaque;
	private JTextField textUrl;
	private JTextField textUsuario;
	private JPasswordField textPass;
	private JPanel ImagenPanel;
	private JTextArea textArea;
	
	private JComboBox boxNivel;
	private JComboBox boxElemento;
	private JButton btnEditar;
	private JButton btnPrevisualizar;
	private JButton btnBuscar;
	private JLabel lblImagen;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textId;
	
	public EditarCarta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarCarta.class.getResource("/vista/imagenes/calavera.png")));
		setTitle("Ver/Editar carta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		ImagenPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, ImagenPanel, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, ImagenPanel, 19, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ImagenPanel, -36, SpringLayout.SOUTH, contentPane);
		ImagenPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ImagenPanel.setBackground(Color.WHITE);
		contentPane.add(ImagenPanel);
		ImagenPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.EAST, ImagenPanel, -27, SpringLayout.WEST, panel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -15, SpringLayout.EAST, contentPane);
		
		lblImagen = new JLabel("");
		lblImagen.setBackground(new Color(255, 255, 255));
		lblImagen.setIcon(null);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(0, 0, 240, 360);
		ImagenPanel.add(lblImagen);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, -333, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel);
		
		textNombre = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textNombre, -3, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, textNombre, 82, SpringLayout.EAST, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.EAST, textNombre, -10, SpringLayout.EAST, panel_1);
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblDescripcion, 28, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblDescripcion, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblDescripcion);
		
		JLabel lblAtaque = new JLabel("ATK");
		lblAtaque.setForeground(new Color(255, 255, 255));
		lblAtaque.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblAtaque, 76, SpringLayout.SOUTH, lblDescripcion);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblAtaque, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblAtaque);
		
		textDefensa = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textDefensa, -3, SpringLayout.NORTH, lblAtaque);
		sl_panel_1.putConstraint(SpringLayout.EAST, textDefensa, -178, SpringLayout.EAST, panel_1);
		textDefensa.setColumns(10);
		panel_1.add(textDefensa);
		
		JLabel lblDefensa = new JLabel("DEF");
		lblDefensa.setForeground(new Color(255, 255, 255));
		lblDefensa.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.WEST, textDefensa, 6, SpringLayout.EAST, lblDefensa);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblDefensa, 0, SpringLayout.NORTH, lblAtaque);
		panel_1.add(lblDefensa);
		
		textAtaque = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, lblDefensa, 6, SpringLayout.EAST, textAtaque);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textAtaque, 73, SpringLayout.SOUTH, lblDescripcion);
		sl_panel_1.putConstraint(SpringLayout.WEST, textAtaque, 6, SpringLayout.EAST, lblAtaque);
		sl_panel_1.putConstraint(SpringLayout.EAST, textAtaque, 43, SpringLayout.EAST, lblAtaque);
		textAtaque.setColumns(10);
		panel_1.add(textAtaque);
		
		JLabel lblUrlImagen = new JLabel("URL imagen");
		lblUrlImagen.setForeground(new Color(255, 255, 255));
		lblUrlImagen.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblUrlImagen, 188, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textAtaque, -29, SpringLayout.NORTH, lblUrlImagen);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblUrlImagen, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblUrlImagen);
		
		textUrl = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textUrl, -3, SpringLayout.NORTH, lblUrlImagen);
		sl_panel_1.putConstraint(SpringLayout.WEST, textUrl, 0, SpringLayout.WEST, textNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, textUrl, 0, SpringLayout.EAST, textNombre);
		textUrl.setColumns(10);
		panel_1.add(textUrl);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));

		sl_panel_1.putConstraint(SpringLayout.WEST, btnEditar, -104, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnEditar, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnEditar, 0, SpringLayout.EAST, textNombre);
		panel_1.add(btnEditar);
		
		textUsuario = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnEditar, 53, SpringLayout.SOUTH, textUsuario);
		sl_panel_1.putConstraint(SpringLayout.WEST, textUsuario, 0, SpringLayout.WEST, textNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, textUsuario, 0, SpringLayout.EAST, textNombre);
		panel_1.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 315, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textUsuario, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 17, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Solo administradores pueden editar.");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -112, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ELM");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblAtaque);
		panel_1.add(lblNewLabel_4);
		
		boxElemento = new JComboBox();
		boxElemento.setForeground(new Color(255, 255, 255));
		boxElemento.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.WEST, boxElemento, 236, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, boxElemento, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_4, -6, SpringLayout.WEST, boxElemento);
		sl_panel_1.putConstraint(SpringLayout.NORTH, boxElemento, -3, SpringLayout.NORTH, lblAtaque);
		boxElemento.setModel(new DefaultComboBoxModel(new String[] {"DARK", "LIGHT", "FIRE", "WATER", "EARTH", "WIND"}));
		panel_1.add(boxElemento);
		
		btnPrevisualizar = new JButton("Previsualizar");
		btnPrevisualizar.setForeground(new Color(255, 255, 255));
		btnPrevisualizar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));

		sl_panel_1.putConstraint(SpringLayout.NORTH, btnPrevisualizar, 11, SpringLayout.SOUTH, textUrl);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnPrevisualizar, -128, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnPrevisualizar, -10, SpringLayout.EAST, panel_1);
		panel_1.add(btnPrevisualizar);
		
		textPass = new JPasswordField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textPass, 14, SpringLayout.SOUTH, textUsuario);
		sl_panel_1.putConstraint(SpringLayout.WEST, textPass, 0, SpringLayout.WEST, textNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, textPass, 0, SpringLayout.EAST, textNombre);
		panel_1.add(textPass);
		
		textArea = new JTextArea();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textArea, 25, SpringLayout.SOUTH, textNombre);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		sl_panel_1.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, textNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, panel_1);
		textArea.setTabSize(4);
		textArea.setRows(10);
		panel_1.add(textArea);
		
		lblNewLabel_5 = new JLabel("LVL");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblAtaque);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 6, SpringLayout.EAST, textDefensa);
		panel_1.add(lblNewLabel_5);
		
		boxNivel = new JComboBox();
		boxNivel.setForeground(new Color(255, 255, 255));
		boxNivel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		boxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textArea, -25, SpringLayout.NORTH, boxNivel);
		sl_panel_1.putConstraint(SpringLayout.NORTH, boxNivel, -4, SpringLayout.NORTH, lblAtaque);
		sl_panel_1.putConstraint(SpringLayout.WEST, boxNivel, -43, SpringLayout.WEST, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, boxNivel, -6, SpringLayout.WEST, lblNewLabel_4);
		panel_1.add(boxNivel);
		
		lblNewLabel_6 = new JLabel("Carta ID");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, ImagenPanel);
		contentPane.add(lblNewLabel_6);
		
		textId = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textId, -3, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, textId, 6, SpringLayout.EAST, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.EAST, textId, 47, SpringLayout.EAST, lblNewLabel_6);
		contentPane.add(textId);
		textId.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBuscar, 0, SpringLayout.NORTH, textId);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBuscar, 6, SpringLayout.EAST, textId);
		contentPane.add(btnBuscar);
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextArea getTextDescripcion() {
		return textArea;
	}

	public JTextField getTextDefensa() {
		return textDefensa;
	}

	public JTextField getTextAtaque() {
		return textAtaque;
	}
	public JTextField getTextId() {
		return textId;
	}

	public JTextField getTextUrl() {
		return textUrl;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public JPasswordField getTextPass() {
		return textPass;
	}
	public JComboBox getBoxElemento() {
		return boxElemento;
	}
	public JComboBox getBoxNivel() {
		return boxNivel;
	}
	public JPanel getImagenPanel() {
		return ImagenPanel;
	}
	public JButton getBtnEditar() {
		return  btnEditar;
	}
	
	public  JButton getBtnPrevisualizar() {
		return btnPrevisualizar;
	}
	public JButton getBtnBuscar () {
		return btnBuscar;
	}
	public JLabel getLblImagen() {
		return lblImagen;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}

