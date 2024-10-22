public class CartaMagicaNormal extends CartaMagica { 

    public CartaMagicaNormal(String efecto, String nombre, String rareza) {
        this.efecto = efecto;
        this.nombre = nombre;
        this.rareza = rareza;
        this.activo = false;
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
        if (efecto == "inflijir" + cantidad_efecto + " de daño al rival") {
            this.inflijir_daño_jugador();
        } else {
            this.curar_jugador();
        }
    }

    public void destruirse() {
        this.activo = false;  //indicara que ya no estaria en el campo, para los observadores
    }

}
