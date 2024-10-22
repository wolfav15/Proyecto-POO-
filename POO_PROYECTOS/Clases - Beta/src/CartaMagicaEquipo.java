public class CartaMagicaEquipo extends CartaMagica {
    private CartaMounstro mounstruo_equipado; 

    public CartaMagicaEquipo(String nombre, String efecto, String rareza) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.activo = false;
        this.rareza = rareza;
    }

    @Override
    public void colocar() {
        this.activo = true;
        this.estado = "colocado";
    }

    private void equipar_mounstruo(CartaMounstro carta) {

        this.mounstruo_equipado = carta;
        carta.setAtaque(carta.getAtaque() + cantidad_efecto); 
    }

    @Override
    public void activar_efecto() {
        //this.equipar_mounstruo();
    }

    public void destruirse() {
        this.activo = false;  //indicara que ya no estaria en el campo, para los observadores
        this.mounstruo_equipado.setAtaque(mounstruo_equipado.getAtaque() - cantidad_efecto);
    }
}
