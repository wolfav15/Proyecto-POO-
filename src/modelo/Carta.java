package modelo;

public abstract class Carta {
	protected String nombre, descripcion, tipo, imagen; // descripcion seria el efecto (si es que tiene) es generico a todo
	protected Integer nivel;


	protected boolean activo; 
	//tipos: monstruo, armadura, buff, herida y curacion
	

	public Carta(String nombre, String descripcion, Integer nivel, String tipo, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.tipo = tipo;
		this.imagen = imagen;
		this.activo = false;
	}

	public abstract void colocar();

	public abstract void destruirse();
	

	public Integer getNivel() {
		return nivel;
	}
	public String getTipo() {
		return tipo;
	}

	public boolean getActivo (){
		return this.activo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public String getImagen() {
		return imagen;
	}
}