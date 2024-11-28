package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelo.Tablero;
import modelo.TableroDAO;
import vista.TablerosABM;

public class ControladorABMTablero {

	private TablerosABM vista;
	private TableroDAO dao;

	
	public ControladorABMTablero () {
		vista = new TablerosABM();
		dao = new TableroDAO();
		inicializarEventos();
		vista.setVisible(true);
	}

	private void inicializarEventos() {

		this.vista.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				inicializarTabla();
			}
			@Override
			public void windowLostFocus(WindowEvent e) { //Este metodo es necesario para el WindowsFocusListeners aunque esté vacio.
			}
		});
		
		
		vista.getBtnAgregar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorAgregarTablero();
			}
		});
		
		this.vista.getBotonBorrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorBorrarTablero();
			}
		});
		
		this.vista.getBtnEditar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorEditarTablero();
			}
		});
	}
	private void inicializarTabla() {
		
		DefaultTableModel model = (DefaultTableModel) vista.getTabla().getModel(); //El modelo es lo que le especifica las columnas y filas.
		model.setRowCount(0);
		try {
			ArrayList<Tablero> tablas = dao.obtenerTableros();
			for (Tablero tabla : tablas) {
				Object[] fila = new Object[4];
				fila[0] = tabla.getId_tablero();
				fila[1] = tabla.getTipo_elemento_tablero();
				fila[2] = tabla.getImagenUrlTablero();
				fila[3] = tabla.getFondoCartas();
				model.addRow(fila);
			}
			
			if (model.getRowCount() == 0) {
				Object[] fila = new Object[4];
				fila[0] = "No";
				fila[1] = "hay";
				fila[2] = "tableros en el sistema";

				

				model.addRow(fila);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
        new ControladorABMTablero();
    }
}
