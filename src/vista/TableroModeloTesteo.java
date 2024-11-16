package vista;

import modelo.Carta;
import modelo.CartaMounstro;
import modelo.Jugador;
import modelo.Campos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class TableroModeloTesteo extends Observable {
    

    private Campos CartasJugador;
    private Campos CartasComputadora;

    private boolean turnoJugador; 
    private Jugador jugador; //cada jugador posee su vida, su mazo y su mano, se borro por ello
    private Jugador Computadora;

    public TableroModeloTesteo() {
        this.cartasJugador = new Campos();
        this.cartasRival = new Campos();
        this.turnoJugador = true; // Empieza el jugador
        inicializarBaraja();
    }

        // Métodos de gestión de cartas
        public void agregarMounstruoJugador(CartaMounstro carta) {
            if (CartasJugador.getCampoMounstruos().size() < 5) {
                cartasJugador.add(carta);
                setChanged();
                notifyObservers();
            }
        }
    
        public void agregarCartaRival(CartaMounstro carta) {
            cartasRival.add(carta);
            setChanged();
            notifyObservers();
        }
    
        public void eliminarCartaJugador(CartaMounstro carta) {
            cartasJugador.remove(carta);
            setChanged();
            notifyObservers();
        }
    
        public void eliminarCartaRival(CartaMounstro carta) {
            cartasRival.remove(carta);
            setChanged();
            notifyObservers();
        }
    



}