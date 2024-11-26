package modelo;

public class Tablero {
    private Integer id_tablero;
    private String tipo_elemento_tablero, imagenUrlTablero;
    
    public Tablero(Integer id, String elemento, String img){
    	this.id_tablero = id;
    	this.tipo_elemento_tablero = elemento;
    	this.imagenUrlTablero = img;
    }

	public Integer getId_tablero() {
		return id_tablero;
	}

	public String getTipo_elemento_tablero() {
		return tipo_elemento_tablero;
	}

	public String getImagenUrlTablero() {
		return imagenUrlTablero;
	}
}
