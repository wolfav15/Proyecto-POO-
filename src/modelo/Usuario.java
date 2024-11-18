package modelo;

public class Usuario {
	
	protected Integer id;
	protected String nombre;
	protected Integer contador_victorias;
	protected Integer contador_derrotas;
	
	public Usuario(Integer id, String nombre, Integer contador_victorias, Integer contador_derrotas) {
		this.id = id;
		this.nombre = nombre;
		this.contador_victorias = contador_victorias;
		this.contador_derrotas = contador_derrotas;
	}
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getContador_victorias() {
		return contador_victorias;
	}

	public Integer getContador_derrotas() {
		return contador_derrotas;
	}
	
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contadorVictorias=" + contador_victorias +
                ", contadorDerrotas=" + contador_derrotas +
                '}';
    }
}
