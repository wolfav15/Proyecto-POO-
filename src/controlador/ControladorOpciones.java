package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.MenuOpciones;

public class ControladorOpciones {
	private MenuOpciones vista;
	
	public ControladorOpciones ()  {
		this.vista = new MenuOpciones();
		
		
		this.vista.getBotonABMJugadores().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControladorABMJugadores();
			}
		});
		
		this.vista.getBotonABMCartas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControladorABMCartas();
			}
		});
		
		this.vista.getBotonABMTableros().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControladorABMTablero();
			}
		});
		
		this.vista.getBotonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.dispose();
			}
		});
	}
	public MenuOpciones getVista() {
		return this.vista;
	}
}
