 package modelo;

public class CartaMagicaCuracion extends CartaMagicaArrojadiza {

	public CartaMagicaCuracion(String nombre, String descripcion, int cantidad_efecto, String efecto) {
		super(nombre, descripcion, cantidad_efecto, efecto);
	}

	
@Override
	public void activar_efecto(Jugador jugador) {
		jugador.recbirCuracion(this.cantidad_efecto);
	}

	

}
