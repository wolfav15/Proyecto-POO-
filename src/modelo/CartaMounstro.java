package modelo;

public class CartaMounstro extends Carta {

	private int ataque, defensa, nivel;
	private boolean ataque_realizado = false;
	private String posicion = "en mano";
	private String elemento;
	private int buffTabla = 0;

	// estado lo que indica es para verificar si esta boca arriba o colocado, para
	// el observer del campo detecte si mostrarlo o no

	public CartaMounstro(int id, String nombre, String descripcion, int ataque, int defensa, int nivel, String imagen, String elemento) {
		super(id, nombre, descripcion, imagen);
		this.ataque = ataque;
		this.defensa = defensa;
		this.elemento = elemento;
		this.nivel = nivel;
	}

	@Override
	public void colocar() {
		this.activo = true;                                                                                
		this.posicion = "ataque";
	}

	public void invocarEnAtaque() {
		activo = true;
		posicion = "ataque";
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
			
			return (-danio);
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

	public int getBuffTabla() {
		return buffTabla;
	}

	public void setBuffTabla(int val) {
		this.buffTabla = val;
	}
	
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public boolean realizoAtaque() {
		return ataque_realizado;
	}

	public void resetearAtaqueEnTurno() {
		ataque_realizado = false;
	}

	public void yaAtacoEnTurno() {
		ataque_realizado = true;
	}

	public int getNivel() {
		return nivel;
	}
	public String getElemento() {
		return elemento;
	}
	
}
