package modelo;

public class CartaMagicaArmadura extends CartaMagicaEquipada {


	public CartaMagicaArmadura(int id, String nombre, String descripcion, int cantidad_efecto, String imagen) {
		super(id, nombre, descripcion, cantidad_efecto, imagen);
	}

	@Override
	public void activar_efecto(CartaMounstro carta) {
		carta.setDefensa(carta.getDefensa() + cantidad_efecto);
	}
}
