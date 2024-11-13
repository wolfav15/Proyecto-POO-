package modelo;

public class CartaMagicaArmadura extends CartaMagica {


	public CartaMagicaArmadura(String nombre, String descripcion, String efecto, int cantidad_efecto) {
		super(nombre, descripcion, cantidad_efecto);

	}

	@Override
	public void colocar() {
		this.activo = true;
	}

	@Override
	public void activar_efecto(CartaMounstro carta) {
		carta.setDefensa(carta.getDefensa() + cantidad_efecto);
	}

	@Override
	public void destruirse() {
		this.activo = false; // indicara que ya no estaria en el campo, para los observadores
	}
}
