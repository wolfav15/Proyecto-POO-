package modelo;

public class CartaMagicaArmadura extends CartaMagicaEquipada {


	public CartaMagicaArmadura(String nombre, String descripcion, String efecto, int cantidad_efecto, String imagen) {
		super(nombre, descripcion, cantidad_efecto, efecto, imagen);

	}

	@Override
	public void activar_efecto(CartaMounstro carta) {
		carta.setDefensa(carta.getDefensa() + cantidad_efecto);
	}

	
}
