package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Menu;

public class ControladorMenu {
		private Menu vista;

		public ControladorMenu () {
			this.vista = new Menu();
		
			this.vista.getBotonBatalla().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorMenuBatalla menubatalla = new ControladorMenuBatalla();
					menubatalla.getVista().setVisible(true);
				}
			});
			this.vista.getBotonReglas().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vista.mostrarMensaje("Mostar reglas...");
				}
			});
			this.vista.getBotonOpciones().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControladorOpciones opciones = new ControladorOpciones();
					opciones.getVista().setVisible(true);
				}
			});
			

		}
		public Menu getVista() {
			return this.vista;
		}
}
