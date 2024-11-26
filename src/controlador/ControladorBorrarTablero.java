package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import modelo.CartaDAO;
import modelo.JugadorDAO;
import modelo.TableroDAO;
import vista.BorrarTablero;

public class ControladorBorrarTablero {
	private BorrarTablero vista;
	private TableroDAO dao;
	private JugadorDAO dao2;
	
	public ControladorBorrarTablero() {
		vista = new BorrarTablero();
		dao = new TableroDAO();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
		
	}

	private void inicializarEventos() {
		vista.getBtnBorrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer id = Integer.parseInt(vista.getTextId().getText().trim());
				String usuarioAdmin = vista.getNombre().getText().trim();
	    		String passAdmin = String.valueOf(vista.getPass().getPassword()).trim();
	    		
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin)) {
						dao.borrarTablero(id);
						vista.mostrarMensaje("Tablero eliminada correctamente");
					} else {
						vista.mostrarMensaje("No tienes privilegios de administrador.");
					}
				} catch (SQLException e1) {
					vista.mostrarMensaje("No se ha podido eliminar la carta.");
					e1.printStackTrace();
				}
			}
		});
		
	}
    public static void main(String[] args) {
        new ControladorBorrarCarta();
    }
}

