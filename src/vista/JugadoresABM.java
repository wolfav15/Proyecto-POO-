package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;



public class JugadoresABM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;

	public JugadoresABM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JugadoresABM.class.getResource("/vista/imagenes/calavera.png")));
		setResizable(false);
		setTitle("Jugadores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setEnabled(false);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nombre", "victorias", "derrotas"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		panel.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		panel.add(btnEditar);
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return  btnEditar;
	}

	public JButton getBotonBorrar() {
		return btnBorrar;
	}
	public JTable getTabla() {
		return table;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}


	
	
}
