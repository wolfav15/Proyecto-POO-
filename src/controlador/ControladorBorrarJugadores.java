package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import modelo.JugadorDAO;
import vista.BorrarJugador;

public class ControladorBorrarJugadores {

	
	private BorrarJugador vista;
	private JugadorDAO dao;
	
	
	public ControladorBorrarJugadores() {
		vista = new BorrarJugador();
		dao = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}
	
	
	
	public void inicializarEventos() {
		
		
		vista.getBtnBorrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre, pass1 ;
				char[] pass;

				nombre = vista.getNombre().getText();
				
				// Obtener la contraseña como char[]
	            pass = vista.getPass().getPassword();
	            
	            pass1 = new String(pass);

				System.out.println(nombre);
				System.out.println(pass);
				
				
				Integer id = 0;
				try {
					id = dao.login(nombre, pass1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (id != 0) {
						try {
							dao.borrarUsuario(nombre, pass1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						vista.mostrarMensaje("Usuario borrado");
						vista.dispose();
				} else {
					vista.mostrarMensaje("Usuario no existe para ese usuario y contraseña");
				}
				
			}
		});
	}
}
