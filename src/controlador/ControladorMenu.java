package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.JugadorDAO;
import vista.Menu;
import vista.VistaInicioSesion;

public class ControladorMenu {
		private Menu vista;
        private musica.ReproductorMusica song;
		public ControladorMenu () {
			song = new musica.ReproductorMusica();
			song.reproducir("src\\musica\\Rata Blanca - La Leyenda del Hada y el Mago (En Vivo).mp3");
			
			
			this.vista = new Menu();
		
		
			this.vista.getBotonBatalla().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					song.detener();
					VistaInicioSesion vista = new VistaInicioSesion();
					JugadorDAO dao = new JugadorDAO();
					new ControladorInicioSesion(vista, dao);
				}
			});
			this.vista.getBotonReglas().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vista.mostrarMensaje("En Yu-Gi-Oh, al atacar a una carta en posición de ataque, el resultado depende de la comparación entre el ataque (ATK) de ambas cartas:\r\n"
							+ "\r\n"
							+ "Tu ATK es mayor que el ATK de la carta atacada: oponente recibe daño igual a la diferencia entre ambos valores de ATK.\r\n"
							+ "\r\n"
							+ "Tu ATK es igual al ATK de la carta atacada: Ambas cartas son destruidas, y ninguno de los jugadores recibe daño.\r\n"
							+ "\r\n"
							+ "Tu ATK es menor que el ATK de la carta atacada: Tu carta es destruida, y tú recibes daño igual a la diferencia entre ambos valores de ATK.\r\n"
							+ "\r\n"
							+ "Además las cartas mágicas obtenidas aleatoriamente son Daño, Curación y Ataque+.");
				}
			});
			this.vista.getBotonOpciones().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			 
					ControladorOpciones opciones = new ControladorOpciones();
					opciones.getVista().setVisible(true);
					//song.detener();
					
				}
			});
			

		}
		public Menu getVista() {
			return this.vista;
		}
}
