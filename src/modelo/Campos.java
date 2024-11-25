package modelo;

import java.util.concurrent.TimeUnit;

public class Campos {

	private CampoMounstruos campoMonstruos ;
	private CampoMagias campoMagias ;

	public Campos (){
		this.campoMonstruos = new CampoMounstruos();
		this.campoMagias = new CampoMagias();

	}
	// Acá se incluye toda la logica necesaria para agregar cartas al campo de
	// batalla de cada jugador
	// Cada jugador tiene sus propios dos campos (De magia y de mosntruos)

	//Cartas monstruo
	public void agregarCartas(CartaMounstro carta)throws Exception{
		campoMonstruos.agregarCarta(carta);
	}

	public void removerCarta(CartaMounstro carta)throws Exception{
		campoMonstruos.removerCarta(carta);
	}

	//Cartas magia
	public void agregarCartas(CartaMagica carta)throws Exception{
		campoMagias.agregarCarta(carta);
	}

	public void removerCarta(CartaMagica carta)throws Exception{
		campoMagias.removerCarta(carta);
	}

	public CampoMounstruos getCampoMounstruos() {
		return campoMonstruos;
	}

	public CampoMagias getCampoMagias() {
		return campoMagias;
	}
}
