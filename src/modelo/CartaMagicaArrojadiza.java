package modelo;

public abstract class CartaMagicaArrojadiza extends CartaMagica {
    public CartaMagicaArrojadiza (int id, String nombre, String descripcion, int cantidad_efecto, String imagen){
		super(id, nombre, descripcion, cantidad_efecto, imagen);
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

