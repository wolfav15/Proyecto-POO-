package controlador;

import modelo.TableroDAO;

public class ControladorAgregarTablero {

	private TableroDAO dao;
	private AgregarTablero vista;
	
	public ControladorAgregarTablero() {
		dao = new TableroDAO();
		vista = new AgregarTablero();
		inicializarEventos();
		vista.setVisible(true);
	}

	private void inicializarEventos() {
		
		
	}
}
