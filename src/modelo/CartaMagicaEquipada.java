package modelo;

public abstract class CartaMagicaEquipada extends CartaMagica{
    
	public CartaMagicaEquipada (int id, String nombre, String descripcion, int cantidad_efecto, String imagen){
		super(id, nombre, descripcion, cantidad_efecto, imagen);
	}
	
	@Override
	public void colocar() {
		this.activo = true;
	}
	
	public abstract void activar_efecto(CartaMounstro carta) ;

	@Override
	public void destruirse() {
		this.activo = false; // indicara que ya no estaria en el campo, para los observadores
	}
}

