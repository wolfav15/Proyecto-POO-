package modelo;

public class CartaMounstro extends Carta {

	private int ataque, defensa, nivel;
	private String atributo, posicion;

	// estado lo que indica es para verificar si esta boca arriba o colocado, para
	// el observer del campo detecte si mostrarlo o no

	public CartaMounstro(String nombre, String descripcion, int ataque, int defensa, int nivel, String atributo, Jugador jugador) {
		super(nombre, descripcion, nivel);
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = nivel;
		this.atributo = atributo;
		this.tipo = "CartaMounstro";

	}

	@Override
	public void colocar() {
		this.activo = true;
		this.estado = "colocado"; // se usara para que se verifique como se mostrara en pantalla, si oculto o boca
									// arriba
		this.posicion = "defensa";
	}

	private int devolver_estadistica(CartaMounstro carta) {
		int atributo_comparar = carta.getAtaque();
		if (carta.getPosicion() == "defensa") {
			atributo_comparar = carta.getDefensa();
		}
		return atributo_comparar; // es para ver si usar el ataque o la defensa del mounstruo atacado, en atacar.
	}

	@Override
	public void destruirse() {
		this.activo = false; // indicara que ya no estaria en el campo, para los observadores
	}

	public void cambiar_posicion() {
		if (posicion == "ataque") {
			this.posicion = "defensa";
		} else {
			this.posicion = "ataque"; // si no esta en ataque, esta en defensa, entonces se cambia.
		}
	}

	public int  atacar(CartaMounstro carta_atacada) {
		//acá se almacena el daño que recibiria el atacante, puede ser 0 o mayor que 0
		int dañoAlAtacante;
		if (carta_atacada.getPosicion() == "defensa"){
			dañoAlAtacante=carta_atacada.defender(this.ataque);
		}
		else {
			//la carta atacada está en posición de ataque
			dañoAlAtacante = carta_atacada.contraatacar(this.ataque, this);
		}
		this.danioJugador(dañoAlAtacante);
		return dañoAlAtacante;
		
	}
	//aca se incluye la lógica de defenderse de un ataque, si la carta atacada...
	//está en posición de defensa
	
	public int defender(int danio){
			if (danio > this.defensa){
				this.destruirse();
				return 0;
			}
			else if  (this.defensa == danio){
				return 0;
			}
			else {
				return this.defensa - danio;
			}
	}
	//aca se incluye la lógica de contraatacar, si la carta atacada...
	//está en posición de ataque
	//contraatacar necesita una instancia de la carta por si esta se destruye.
	public int contraatacar(int danio, Carta cartaAtacante){
		if (danio < this.ataque){
			cartaAtacante.destruirse();
			return this.ataque - danio;
		}
		else if  (this.defensa == danio){
			this.destruirse();
			cartaAtacante.destruirse();
			return 0;
		}
		else {
			this.destruirse();
			this.danioJugador(danio);
			return 0;
		}
}
	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public void danioJugador(int danio){
		this.jugador.recibirDaño(danio);
	}

}
