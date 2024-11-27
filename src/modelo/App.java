package modelo;

import java.awt.EventQueue;

import controlador.ControladorMenu;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorMenu controlador = new ControladorMenu();
					controlador.getVista().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
