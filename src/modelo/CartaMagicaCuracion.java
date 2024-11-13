 package modelo;

public class CartaMagicaCuracion extends CartaMagica {

	public CartaMagicaCuracion(String nombre, String descripcion, int cantidad_efecto, String tipo_efecto) {
		super(nombre, descripcion, cantidad_efecto);
	}

	@Override
	public void colocar() {
		this.activo = true;
	}

	@Override
	public void activar_efecto(Juagador jugador) {
		jugador.recbirCuracion(this.cantidad_efecto);
	}

	@Override
	public void destruirse() {
		this.activo = false; // indicara que ya no estaria en el campo, para los observadores
	}

}
