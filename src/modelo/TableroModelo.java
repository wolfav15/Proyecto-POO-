package modelo;

import java.util.ArrayList;
import java.util.List;




public class TableroModelo {
    private Jugador jugador;
    private Jugador computadora;

    public TableroModelo(Jugador jugador) {
        jugador = new Jugador("Jugador1", this.bajarDeck());
        computadora = new Jugador("Computadora",this.bajarDeck());
        }
    public ArrayList<Carta>bajarDeck (){
        //acá debería haber una bajada de tablas.
        Carta carta1 = new CartaMounstro("Dragon", "Es un Dragon", 400, 100, 5, "Tira fuego");
        Carta carta2 = new CartaMounstro("Lobo", "Es un Lobo", 200, 200, 2, "Muerde, rasguña");
        Carta carta3 = new CartaMounstro("Toro", "Es un Toro", 250, 200, 3, "Atca con los cuernos");
        Carta carta4 = new CartaMounstro("Kratos", "Es un Semidios", 200, 100, 1, "Ataca con las esadas del caos");
        Carta carta5 = new CartaMounstro("Cracken", "Es un Cracken", 200, 100, 3, "Tira fuego, agua");
        Carta carta6 = new CartaMounstro("Vampiro", "Es un Vampiro", 200, 100, 2, "Ataca con colmillos");
        Carta carta7 = new CartaMounstro("Messi", "Es el mejor del mundo", 200, 100, 5, "Tira gambeta");
        ArrayList<Carta>  deck= new ArrayList<Carta>();
        deck.add(carta1);
        deck.add(carta2);
        deck.add(carta3);
        deck.add(carta4);
        deck.add(carta5);
        deck.add(carta6);
        deck.add(carta7);

        return deck;
    } 
    public void atacarCarta (CartaMounstro cartaAtacante, CartaMounstro CartaAtacada){
       int danio= cartaAtacante.atacar(CartaAtacada);
       if (danio < 0 ){
        this.computadora.recibirDaño(-danio);
       }
       else if ( danio > 0){
        this.jugador.recibirDaño(danio);
       }
    }
    public void AtaqueDirecto(CartaMounstro cartaAtacante){
        this.computadora.recibirDaño(cartaAtacante.getAtaque());
    }
}