package modelo;

import java.awt.EventQueue;

import javax.swing.UIManager;

import controlador.ControladorMenu;

public class App {
    public static void main(String[] args) {
    	
    	try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
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
