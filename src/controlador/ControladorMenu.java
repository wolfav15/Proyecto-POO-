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
					vista.mostrarMensaje("Baraja y mano: El jugador tiene disponible una baraja compuesta por cartas aleatorias de tipo monstruo y de tipo magia. Haciendo click sobre la baraja, el usuario puede agregar una carta a su mano, en la cual puede guardar un máximo de 5 cartas. Las cartas que tenga en su mano son las que podrá jugar en el turno. Durante cada turno, puede sacar de la baraja las cartas que desee. \r\n"
							+ "\r\n"
							+ "Tablero y campos: El tablero está compuesto por un campo para cartas mágicas y otro para cartas montruo. Haciendo click en alguna de las cartas que tenga en su mano, ésta se colocará en su campo correspondiente. Solo las cartas que están en el campo pueden ser activadas para usar en la batalla.\r\n"
							+ "\r\n"
							+ "Cartas: Las cartas pueden ser tipo monstruo o de tipo magia.\r\n"
							+ "\r\n"
							+ "Cartas monstruo: Tienen los atributos ataque, defensa y elemento. \r\n"
							+ "\r\n"
							+ "Cuando una carta monstruo ataca a otra, esta usará su ataque para atacar a la defensa de la carta rival. Si el ataque es mayor a la defensa de la carta rival, la carta rival se destruye y lo que reste del daño irá al jugador rival. \r\n"
					+ "\r\n"
					+ "Si el ataque es menor a la defensa, la carta atacante se destruye, y la la diferencia entre la defensa y el ataque la recibe el jugador atacante. \r\n"
			+ "\r\n"
			+ "Si ambas cartas tienen mismo daño y misma defensa, ambas se destruyen, y ningun jugador recibe daño.\r\n"
			+ "\r\n"
			+ "Si el rival no tiene ninguna carta en su campo, se puede atacar de forma directa a la vida del rival haciendo click sobre la barra de la vida del mismo.\r\n"
			+ "\r\n"
			+ "Cartas mágicas: Las cartas mágicas pueden ser de dos tipos. \r\n"
			+ "\r\n"
			+ "----- Equipadas: Funcionan en conjunto con las cartas monstruo. Haciendo click en estas y luego sobre una carta monstruo, se puede aumentar el ataque o la defensa de la carta mosntruo.\r\n"
			+ " \r\n"
			+ "----- Arrojadizas: Cuando se hace click sobre estas, pueden reducir la vida del rival, o aumentar la vida del jugador que la invoca.  \r\n"
			+ "\r\n"
			+ "Si el jugador logra reducir la vida del rival a cero, este gana la partida. Por el contrario, si su vida llega a cero, pierde la partida.   \r\n");
				
				
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
