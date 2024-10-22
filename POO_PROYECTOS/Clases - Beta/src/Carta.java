public abstract class Carta {
    protected String nombre, rareza, estado;
    protected boolean activo; //hara referencia ha si esta en el campo o no, para cosas como magias de equipo.

    public abstract void colocar();
    public abstract void destruirse();

}