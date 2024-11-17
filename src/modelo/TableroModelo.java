package modelo;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")

public class TableroModelo extends Observable {

    private Jugador jugador;
    private Jugador computadora;

    private Campos campoJugador;
    private Campos campoComputadora;

    public TableroModelo(Jugador jugador) {
        jugador = new Jugador("Jugador1", this.bajarDeck());
        computadora = new Jugador("Computadora",this.bajarDeck());
        this.campoComputadora = new Campos();
        this.campoJugador = new Campos();
        }
    public ArrayList<Carta>bajarDeck (){
        //acá debería haber una bajada de tablas.
        Carta carta1 = new CartaMounstro("Dragon", "Es un Dragon", 400, 100, 5, "Tira fuego", "urlImagen");
        Carta carta2 = new CartaMounstro("Lobo", "Es un Lobo", 200, 200, 2, "Muerde, rasguña", "urlImagen");
        Carta carta3 = new CartaMounstro("Toro", "Es un Toro", 250, 200, 3, "Atca con los cuernos", "urlImagen");
        Carta carta4 = new CartaMounstro("Kratos", "Es un Semidios", 200, 100, 1, "Ataca con las esadas del caos", "urlImagen");
        Carta carta5 = new CartaMounstro("Cracken", "Es un Cracken", 200, 100, 3, "Tira fuego, agua", "urlImagen");
        Carta carta6 = new CartaMounstro("Vampiro", "Es un Vampiro", 200, 100, 2, "Ataca con colmillos", "urlImagen");
        Carta carta7 = new CartaMounstro("Messi", "Es el mejor del mundo", 200, 100, 5, "Tira gambeta", "urlImagen");
        ArrayList<Carta>  deck= new ArrayList<Carta>();
        deck.add(carta1);
        deck.add(carta2);
        deck.add(carta3);
        deck.add(carta4);
        deck.add(carta5);
        deck.add(carta6);
        deck.add(carta7);
        // Hay que hacer al menos un shuffle, estaría bueno que las cartas puedan ser distintas
        //No sé si esto era una preuba no más
        return deck;
    } 

    public void atacarEnTablero (Jugador atacante, CartaMounstro cartaAtacante, Jugador atacado, CartaMounstro cartaAtacada)throws Exception{
        atacante.atacarCarta( cartaAtacante,  cartaAtacada,  atacado);
        if (!cartaAtacante.getActivo()){
            campoJugador.removerCarta(cartaAtacante);
        }
        if (!cartaAtacada.getActivo()){
            campoComputadora.removerCarta(cartaAtacada);
        }
        notifyObservers();
        setChanged();
    }

    public void jugarCartaEnTablero(CartaMounstro carta_jugada) throws Exception {
        jugador.jugarCarta(carta_jugada, this, campoJugador);
        notifyObservers();
        setChanged();
    }

    public void jugarCartaEnTablero(CartaMagica carta_jugada) throws Exception {
        computadora.jugarCarta(carta_jugada, this, campoComputadora);
        notifyObservers();
        setChanged();
    }

    public void colocarCarta(CartaMagica carta, Campos campo)throws Exception{
        campo.agregarCartas(carta);
        carta.colocar();
        notifyObservers();
        setChanged();
    }

    public void colocarCarta(CartaMounstro carta, Campos campo)throws Exception{
        campo.agregarCartas(carta);
        carta.colocar();
        notifyObservers();
        setChanged();
    }

    public void removerCartaDeTablero(CartaMounstro carta, Campos campo) throws Exception {
        campo.removerCarta(carta);
        notifyObservers();
        setChanged();
    }

    //Para hechizos
    public void usarMagia (CartaMagicaArrojadiza carta, Jugador jugador, Campos campo) throws Exception{
        carta.activar_efecto(jugador);
        campo.removerCarta(carta);
        notifyObservers();
        setChanged();
    } 

    //Para equipamento
    public void usarMagia (CartaMagicaEquipada carta, CartaMounstro monstruo,Campos campo)throws Exception{
        carta.activar_efecto(monstruo);
        campo.removerCarta(carta);
        notifyObservers();
        setChanged();
    }

    public Campos getCampoJugador(){
        return this.campoJugador;
    }
    public Campos getCampoComputadora(){
        return this.campoComputadora;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Jugador getComputadora() {
        return computadora;
    }

}