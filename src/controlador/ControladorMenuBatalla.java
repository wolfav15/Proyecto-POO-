package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.MenuBatalla;

public class ControladorMenuBatalla {
	private MenuBatalla vista;
	
	public ControladorMenuBatalla ()  {
		this.vista = new MenuBatalla();
		
		this.vista.getBotonMostrarTablas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Crear un controlador que obtenga una lista de tableros y luego arme una Vista donde se listen.
				vista.mostrarMensaje("Mostrando Tablas");
	
			}
		});
		
		
		this.vista.getBotonCpuJugador().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vista.mostrarMensaje("Iniciar combate");
	
			}
		});
		this.vista.getBotonMostrarMazo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Crear un controlador que obtenga una lista de cartas y luego arme una Vista donde se vea cada una.
				vista.mostrarMensaje("Mostrando Mazo");
	
			}
		});
		
		
	}
		
		
	public MenuBatalla getVista() {
		return this.vista;
	}
}
	