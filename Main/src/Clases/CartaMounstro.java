public class CartaMounstro extends Carta {
    
    private int ataque, defensa, nivel;
    private String tipo, atributo, posicion;

    // estado lo que indica es para verificar si esta boca arriba o colocado, para el observer del campo detecte si mostrarlo o no

    public CartaMounstro(String nombre, String rareza, String descripcion, int ataque, int defensa, int nivel, String tipo, String atributo) {
        super(nombre, rareza, descripcion);
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.tipo = tipo;
        this.atributo = atributo;
    }

    @Override
    public void colocar() {
        this.activo = true;
        this.estado = "colocado"; // se usara para que se verifique como se mostrara en pantalla, si oculto o boca arriba
        this.posicion = "defensa";
    }

    private int devolver_estadistica(CartaMounstro carta) {
        int atributo_comparar = carta.getAtaque();
        if (carta.getPosicion() == "defensa") {
            atributo_comparar = carta.getDefensa();
        }
        return atributo_comparar;  //es para ver si usar el ataque o la defensa del mounstruo atacado, en atacar.
    }

    @Override
    public void destruirse() {
        this.activo = false;  //indicara que ya no estaria en el campo, para los observadores
    }

    public void cambiar_posicion() {
        if (posicion == "ataque") {
            this.posicion = "defensa";
        } else {
            this.posicion = "ataque"; //si no esta en ataque, esta en defensa, entonces se cambia.
        }
    }

    public int atacar(CartaMounstro carta_atacada) {

        int valor_usado = devolver_estadistica(carta_atacada);
        int daño_batalla = 0;

        if (ataque > valor_usado) {
            daño_batalla = ataque - valor_usado;
            carta_atacada.destruirse();
        } else { 
            if (carta_atacada.getPosicion() == "defensa") { //si esta en defensa no se destruye mi mounstruo, solo recibo daño
                daño_batalla = valor_usado - ataque;
            } else {
                this.destruirse();   //como ataque a un mounstruo con mayor ataque en posicion de ataque, se destruye
                daño_batalla = valor_usado - ataque;  // y esa diferencia de daño ahora se intercambia
            }
        } //si el ataque o defensa del atacado es igual al ataque del que mounstruo que ataca, no pasa nada
        //por eso daño de batalla esta en cero, y pasa el return con normalidad.

        return daño_batalla;   //el daño de batalla puede ser para mi o para el rival, depende quien tuvo mayor ataque
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

}
