package carta;

public abstract class CartaTrampa extends Carta{

	protected Integer efectos;
	
	public CartaTrampa(String nombre, String descripcion, Integer efectos) {
		super(nombre, descripcion);
		this.efectos = efectos;
	}
	
	public abstract void activar_efecto();
}
