public abstract class CartaMagica extends Carta{
    
    protected String efecto;  //texto que debe ser generico, al menos en esta beta
    protected int cantidad_efecto; // se usara o para curar, o para inflijir daño, o buffar, depende del texto
    
    public abstract void activar_efecto(); //agregar a los jugadores aqui, dependiendo de lo que haga el efecto
                                           //se dara los parametros, no siempre se usaran ambos
}
