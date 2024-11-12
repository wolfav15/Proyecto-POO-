package modelo;

public abstract class Carta {
	protected String nombre, estado, descripcion; // descripcion seria el efecto (si es que tiene) es generico a todo
	protected boolean activo; 
	protected String tipo;
	protected Jugador jugador; // jugador dueño de la carta
	//se incluye al jugador como atributo para poder encapsular el codigo de la batalla
	//solo en la carta

	public Carta(String nombre, String descripcion, int cantidad_efecto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = false;
	}

	public abstract void colocar();

	public abstract void destruirse();
	public String getTipo (){
		return this.tipo;
	}

}