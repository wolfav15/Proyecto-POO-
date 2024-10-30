package Carta;
public class CartaMagicaNormal extends CartaMagica { 

    private String tipo_efecto; //nuevo atributo para evitar tener que tener textos especificos, tiene dos opciones
                                // que el string sea "inflijir" o "curar", se usa para el activar_efecto.

    public CartaMagicaNormal(String nombre, String descripcion, int cantidad_efecto, String tipo_efecto) {
        super(nombre, descripcion, cantidad_efecto);
        this.tipo_efecto = tipo_efecto;
    }

    @Override
    public void colocar() {
        this.activo = true;
        this.estado = "colocado";
    }

    public void curar_jugador() {   //aqui se debe recibir a la clase jugador, para curarnos a nosotros
    }

    public void inflijir_daño_jugador() { //para inflijir daño, a los rivales
    }

    @Override
    public void activar_efecto() {
        if (tipo_efecto == "inflijir") {
            this.inflijir_daño_jugador();
        } else { //aca si va al else, quiere decir que seria tipo_magia == "curar"
            this.curar_jugador();
        }
    }

    @Override
    public void destruirse() {
        this.activo = false;  //indicara que ya no estaria en el campo, para los observadores
    }

}
