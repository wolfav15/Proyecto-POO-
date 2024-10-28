package Carta;

public abstract class Carta {
    protected String nombre, rareza, estado, descripcion; //descripcion seria el efecto (si es que tiene) es generico a todo
    protected boolean activo; //hara referencia ha si esta en el campo o no, para cosas como magias de equipo.

    public Carta(String nombre, String rareza, String descripcion) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.descripcion = descripcion;
        this.activo = false;
    }
    public abstract void colocar();
    public abstract void destruirse();

}