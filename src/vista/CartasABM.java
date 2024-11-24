package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CartasABM extends JFrame {



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar ;
	private JTable table;
	
	public CartasABM() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(559, 211, 94, 75);
		btnEditar = new JButton("Ver/Editar");
		btnEditar.setBounds(559, 113, 94, 75);
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(559, 15, 94, 75);
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		contentPane.add(btnEditar);
		contentPane.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 539, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"id", "nombre", "descripcion", "ataque", "defensa", "elemento"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Long.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(153);
		table.getColumnModel().getColumn(2).setPreferredWidth(212);
		table.getColumnModel().getColumn(2).setMinWidth(23);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		scrollPane.setViewportView(table);
		
		
		
	}
	
	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() {
		return this.btnBorrar;
	}
}
