package modelo;

public abstract class Carta {
	protected String nombre, descripcion; // descripcion seria el efecto (si es que tiene) es generico a todo
	protected boolean activo; 
	protected String imagen;
	//tipos: monstruo, armadura, buff, herida y curacion
	

	public Carta(String nombre, String descripcion, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.activo = false;
	}

	public abstract void colocar();

	public abstract void destruirse();
	

	public boolean getActivo (){
		return this.activo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
	}
}