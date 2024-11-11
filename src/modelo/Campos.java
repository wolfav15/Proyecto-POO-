package modelo;

public class Campos {
	private CampoMonstruos campoMonstruos = new CampoMonstruos();
	private CampoMagias campoMagias = new CampoMagias();

	// Acá se incluye toda la logica necesaria para agregar cartas al campo de
	// batalla de cada jugador
	// Cada jugador tiene sus propios dos campos (De magia y de mosntruos)
	public void agregarCartas(Carta carta) {
		try {
			switch (carta.getClass().toString()) {
			case "CartaMagicaEquipo":
				campoMagias.agregarCarta(carta);
				break;
			case "CartaMonstruos":
				campoMonstruos.agregarCarta(carta);
				break;
			case "CartaMagicaNormal":
				// Acá habria que hacer que se arroje la magia, ya que no queda fija en el
				// campo.
				// Ej: Lanzar hechizo
				campoMonstruos.agregarCarta(carta);
				break;
			default:
				System.out.println("Este tipo de carta no puede ser agregada al campo");
				break;
			}
		} catch (Exception e) {
			System.out.println("El campo se encuentra lleno");
		}

	}

}
