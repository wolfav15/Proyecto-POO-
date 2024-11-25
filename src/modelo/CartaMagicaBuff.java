package modelo;

public class CartaMagicaBuff extends CartaMagicaEquipada {


	public CartaMagicaBuff(int id, String nombre, String descripcion, int cantidad_efecto, String imagen) {
		super(id, nombre, descripcion, cantidad_efecto, imagen);
	}

	
	@Override
	public void activar_efecto(CartaMounstro carta) {
		carta.setAtaque(carta.getAtaque() + cantidad_efecto);
	}

	
}
