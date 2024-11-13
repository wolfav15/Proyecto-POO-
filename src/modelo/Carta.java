package modelo;

public abstract class Carta {
	protected String nombre, descripcion; // descripcion seria el efecto (si es que tiene) es generico a todo
	protected boolean activo; 
	//tipos: monstruo, armadura, buff, herida y curacion
	

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

	public boolean getActivo (){
		return this.activo;
	}
}