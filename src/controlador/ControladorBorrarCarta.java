package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import modelo.CartaDAO;
import modelo.JugadorDAO;
import vista.BorrarCarta;

public class ControladorBorrarCarta {
	private BorrarCarta vista;
	private CartaDAO dao;
	private JugadorDAO dao2;
	
	public ControladorBorrarCarta() {
		vista = new BorrarCarta();
		dao = new CartaDAO();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
		
	}

	private void inicializarEventos() {
		vista.getBtnEliminar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer id = Integer.parseInt(vista.getTextId().getText().trim());
				String usuarioAdmin = vista.getTextUsuario().getText().trim();
	    		String passAdmin = String.valueOf(vista.getTextPass().getPassword()).trim();
	    		
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin)) {
						dao.borrarCarta(id);
						vista.mostrarMensaje("Carta eliminada correctamente");
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
