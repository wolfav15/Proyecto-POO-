package modelo;

public class Campos {

	private List campoMonstruos = new Campo();
	private List campoMagias = new Campo();

	// Acá se incluye toda la logica necesaria para agregar cartas al campo de
	// batalla de cada jugador
	// Cada jugador tiene sus propios dos campos (De magia y de mosntruos)

	//Cartas monstruo
	public void agregarCartas(CartaMonstruo carta){
		campoMonstruos.agregarCarta(carta);
	}

	public void removerCarta(CartaMonstruo carta){
		campoMonstruos.removerCarta(carta);
	}

	//Cartas magia
	public void agregarCartas(CartaMagica carta){
		campoMagias.agregarCarta(carta);
	}

	public void removerCarta(CartaMagica carta){
		campoMagias.removerCarta(carta);
	}
