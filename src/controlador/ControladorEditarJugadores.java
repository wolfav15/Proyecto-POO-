package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import modelo.JugadorDAO;
import vista.EditarJugador;

public class ControladorEditarJugadores {
	
	private EditarJugador vista;
	private JugadorDAO dao;
	
	
	
	public ControladorEditarJugadores() {
		vista = new EditarJugador();
		dao = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}
	
	private void inicializarEventos() {
		
		vista.getBtnEditar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nombre, nombreNuevo, pass1, passConfirmar1;
				char[] pass;
				char[] passConfirmar;
				nombre = vista.getNombre().getText();
				nombreNuevo = vista.getNombreNuevo().getText();
				
				
				// Obtener la contraseña como char[]
	            pass = vista.getPass().getPassword();
	            passConfirmar = vista.getPassNuevo().getPassword();
	            
	            pass1 = new String(pass);
	            passConfirmar1 = new String(passConfirmar);
				System.out.println(pass);
				System.out.println(passConfirmar);
				
				
				//Verifico si son correctas las credenciales
				Integer id = 0;
				try {
					id = dao.login(nombre, pass1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				if (id != 0) {
					try{
						dao.actualizarUsuario(nombre, nombreNuevo, pass1, passConfirmar1, false);
						vista.mostrarMensaje("Usuario modificado.");
						vista.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					vista.mostrarMensaje("El usuario y contraseña anteriores no coinciden.");
				}
			}
		});
		
		vista.getBtnEditarAlternativo().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre, nombreNuevo, pass1, passConfirmar1;
				char[] pass;
				char[] passConfirmar;
				nombre = vista.getNombre().getText();
				nombreNuevo = vista.getNombreNuevo().getText();
				
				
				// Obtener la contraseña como char[]
	            pass = vista.getPass().getPassword();
	            passConfirmar = vista.getPassNuevo().getPassword();
	            
	            pass1 = new String(pass);
	            passConfirmar1 = new String(passConfirmar);
				System.out.println(pass);
				System.out.println(passConfirmar);
				
				
				//Verifico si son correctas las credenciales
				Integer id = 0;
				try {
					id = dao.login(nombre, pass1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				if (id != 0) {
					try{
						dao.actualizarUsuario(nombre, nombreNuevo, pass1, passConfirmar1, true);
						vista.mostrarMensaje("Usuario modificado.");
						vista.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					vista.mostrarMensaje("El usuario y contraseña anteriores no coinciden.");
				}
			}
			
		});
	}
}
