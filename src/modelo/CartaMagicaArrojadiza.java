package modelo;

public abstract class CartaMagicaArrojadiza extends CartaMagica {
    public CartaMagicaArrojadiza (String nombre, String descripcion, int cantidad_efecto, String efecto){
		super(nombre, descripcion, cantidad_efecto);
	}
	@Override
	public void colocar() {
		this.activo = true;
	}

	
	public abstract void activar_efecto(Jugador jugador) ;

	@Override
	public void destruirse() {
		this.activo = false; // indicara que ya no estaria en el campo, para los observadores
	}
}

