package carta;

public abstract class Carta {
    protected String nombre, estado, descripcion; //descripcion seria el efecto (si es que tiene) es generico a todo
    protected boolean activo; //hara referencia ha si esta en el campo o no, para cosas como magias de equipo.

    public Carta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = false;
    }
    public abstract void colocar();
    public abstract void destruirse();

}