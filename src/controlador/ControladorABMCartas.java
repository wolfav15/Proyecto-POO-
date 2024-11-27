package controlador;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelo.CartaDAO;
import modelo.CartaMounstro;
import vista.CartasABM;

public class ControladorABMCartas {

	private CartasABM vista;
	private CartaDAO dao;
	
	
	public ControladorABMCartas() {
		vista = new CartasABM();
		dao = new CartaDAO();
		inicializarTabla();
		inicializarEventos();
		vista.setVisible(true);
	}
	
	
	private void inicializarTabla() {
		DefaultTableModel model = (DefaultTableModel) vista.getTable().getModel(); //El modelo es lo que le especifica las columnas y filas.
		model.setRowCount(0);
		try {
			ArrayList<CartaMounstro> cartas = dao.obtenerCartasMonstruos();

			for (CartaMounstro carta : cartas) {
				Object[] fila = new Object[6];
				fila[0] = carta.getId();
				fila[1] = carta.getNombre();
				fila[2] = carta.getDescripcion();
				fila[3] = carta.getAtaque();
				fila[4] = carta.getDefensa();
				fila[5] = carta.getElemento();
				
				model.addRow(fila);
			}
			
			if (model.getRowCount() == 0) {
				Object[] fila = new Object[4];
				fila[0] = "No";
				fila[1] = "hay";
				fila[2] = "cartas";
				fila[3] = "en ";
				fila[4] = "el";
				fila[5] = "sistema";


				model.addRow(fila);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	private void inicializarEventos() {
		
		vista.getTable().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				inicializarTabla();
			}
		});
		
		vista.getBtnAgregar().addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				 new ControladorAgregarCarta();
			}
		});
		
		vista.getBtnEditar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorEditarCarta();
			}
		});
		
		vista.getBtnBorrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ControladorBorrarCarta();
			}
		});
	}
	
    public static void main(String[] args) {
        new ControladorABMCartas();
    }
}
