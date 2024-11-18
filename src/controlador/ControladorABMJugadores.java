package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import modelo.JugadorDAO;
import modelo.Usuario;
import vista.JugadoresABM;

public class ControladorABMJugadores {
	
	protected JugadoresABM vista;
	protected JugadorDAO dao;
	

	public ControladorABMJugadores () {
		
		
		dao = new JugadorDAO();
		vista = new JugadoresABM();
		agregarEventos();
		inicializarTabla();
		vista.setVisible(true);
		
	}
		

	
	private void agregarEventos() {
		
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
				new ControladorAgregarJugadores();
			}
		});
		
		this.vista.getBotonBorrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorBorrarJugadores();
			}
		});
		
		this.vista.getBtnEditar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorEditarJugadores();
			}
			
		});
	}
	
	
	private void inicializarTabla() {
		
		DefaultTableModel model = (DefaultTableModel) vista.getTabla().getModel(); //El modelo es lo que le especifica las columnas y filas.
		model.setRowCount(0);
		try {
			List<Usuario> usuarios = dao.obtenerUsuarios();
			for (Usuario usuario : usuarios) {
				Object[] fila = new Object[4];
				fila[0] = usuario.getId();
				fila[1] = usuario.getNombre();
				fila[2] = usuario.getContador_victorias();
				fila[3] = usuario.getContador_derrotas();
				

				model.addRow(fila);
			}
			
			if (model.getRowCount() == 0) {
				Object[] fila = new Object[4];
				fila[0] = "No";
				fila[1] = "hay";
				fila[2] = "usuarios";
				fila[3] = "en el sistema";
				

				model.addRow(fila);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
    public static void main(String[] args) {
        new ControladorABMJugadores();
    }
	
}

