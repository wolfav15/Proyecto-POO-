package modelo;

public class Tablero {
    private Integer id_tablero;
    private String tipo_elemento_tablero, imagenUrlTablero, fondoCartas;

    public Tablero(Integer id, String elemento, String img, String img2) {
        this.id_tablero = id;
        this.tipo_elemento_tablero = elemento;
        this.imagenUrlTablero = img;
        this.fondoCartas = img2;
    }

    public Integer getId_tablero() {
        return id_tablero;
    }

    public String getTipo_elemento_tablero() {
        return tipo_elemento_tablero;
    }

    public void setTipo_elemento_tablero(String tipo_elemento_tablero) {
        this.tipo_elemento_tablero = tipo_elemento_tablero;
    }

    public String getImagenUrlTablero() {
        return imagenUrlTablero;
    }

    public void setImagenUrlTablero(String imagenUrlTablero) {
        this.imagenUrlTablero = imagenUrlTablero;
    }

    public String getFondoCartas() {
        return fondoCartas;
    }

}
