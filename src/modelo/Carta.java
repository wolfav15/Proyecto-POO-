package modelo;

public abstract class Carta {
	protected String nombre, descripcion, imagen; // descripcion seria el efecto (si es que tiene) es generico a todo
	protected Integer id, nivel;
	protected boolean activo; 
	//tipos: monstruo, armadura, buff, herida y curacion
	

	public Carta(Integer id, String nombre, String descripcion, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.activo = false;
	}
	public abstract void colocar();

	public void destruirse() {
		this.activo = false;
	}
	

	public boolean getActivo (){
		return this.activo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public boolean isActivo() {
		return activo;
	}

	public String getDescripcion() {
		return descripcion;
	}
}