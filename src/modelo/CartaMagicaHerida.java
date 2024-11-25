 package modelo;

 public class CartaMagicaHerida extends CartaMagicaArrojadiza {

	public CartaMagicaHerida(int id, String nombre, String descripcion, int cantidad_efecto, String imagen) {
		super(id, nombre, descripcion, cantidad_efecto, imagen);
	}

	
	@Override

	public void activar_efecto(Jugador jugador) {
		jugador.recibirDaño(this.cantidad_efecto);
	}

	
}
