package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;

import modelo.JugadorDAO;
import vista.AgregarJugador;

public class ControladorAgregarJugadores {
	
	private AgregarJugador vista;
	private JugadorDAO dao;
	
	
	public ControladorAgregarJugadores() {
		vista = new AgregarJugador();
		inicializarEventos();
		dao = new JugadorDAO();
		vista.setVisible(true);
		
	}
	
	
	private void inicializarEventos() {
		vista.getBtnCrear().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				String nombre, pass1;
				char[] pass;
				char[] passConfirmar;
				nombre = vista.getNombre().getText();
				
				// Obtener la contraseña como char[]
	            pass = vista.getPass().getPassword();
	            passConfirmar = vista.getPassConfimar().getPassword();
	            
	            pass1 = new String(pass);//convertir char a string
	            
				System.out.println(pass);
				System.out.println(passConfirmar);
				
				
				if (Arrays.equals(pass, passConfirmar)) {
					try{
						dao.crearUsuario(nombre, pass1);
							vista.mostrarMensaje("Usuario creado");
							vista.dispose();
						} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					vista.mostrarMensaje("Contraseñas no coinciden");
				}
			}
		});
	}
	
	
}
