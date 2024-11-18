package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.MenuOpciones;

public class ControladorOpciones {
	private MenuOpciones vista;
	
	public ControladorOpciones ()  {
		this.vista = new MenuOpciones();
		
		this.vista.getBotonDificultad().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarMensaje("Seleccionando dificultad...");
			}
		});
		this.vista.getBotonReproducirMusica().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarMensaje("Reproduciendo...");
			}
		});
		this.vista.getBotonPararMusica().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarMensaje("Deteniendo...");
			}
		});
		
		this.vista.getBotonABMJugadores().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControladorABMJugadores();
			}
		});
		
		this.vista.getBotonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarMensaje("Saliendo...");
			}
		});
	}
	public MenuOpciones getVista() {
		return this.vista;
	}
}
