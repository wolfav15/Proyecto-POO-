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
		
		return (carta_atacada.getDefensa()-this.ataque);
		
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
