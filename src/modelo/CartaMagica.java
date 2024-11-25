package modelo;

public abstract class CartaMagica extends Carta {

	protected int cantidad_efecto; // se usara o para curar, o para inflijir daño, o buffar, depende del texto

	public CartaMagica(int id, String nombre, String descripcion, int cantidad_efecto, String imagen) {
		super(id, nombre, descripcion, imagen) ;
		this.cantidad_efecto = cantidad_efecto;
	}

        @Override
	public void colocar() {
		activo = true;
	}
// agregar a los jugadores aqui, dependiendo de lo que haga el efecto
// se dara los parametros, no siempre se usaran ambos

	public int getCantidad_efecto() {
		return cantidad_efecto;
	}


}															
