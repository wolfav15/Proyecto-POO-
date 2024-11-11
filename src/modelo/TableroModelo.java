package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import carta.CartaMounstro;


public class TableroModelo extends Observable {
    private List<CartaMounstro> cartasJugador;
    private List<CartaMounstro> cartasRival;
    private boolean turnoJugador; // true si es el turno del jugador, false si es el del rival
    private int vidaJugador;
    private int vidaRival;

    public TableroModelo() {
        this.cartasJugador = new ArrayList<>();
        this.cartasRival = new ArrayList<>();
        this.turnoJugador = true; // Empieza el jugador
        this.vidaJugador = 8000; // Valor inicial típico en muchos juegos de cartas
        this.vidaRival = 8000;
    }

    // Métodos de gestión de cartas
    public void agregarCartaJugador(CartaMounstro carta) {
        cartasJugador.add(carta);
        setChanged();
        notifyObservers();
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

    // Métodos para las acciones de las cartas
    public void colocarCarta(CartaMounstro carta) {
        carta.colocar();
        setChanged();
        notifyObservers();
    }

    public void cambiarPosicionCarta(CartaMounstro carta) {
        carta.cambiar_posicion();
        setChanged();
        notifyObservers();
    }

    public int atacarCarta(CartaMounstro atacante, CartaMounstro defensor) {
        int daño = atacante.atacar(defensor);
        setChanged();
        notifyObservers();
        return daño;
    }

    // Métodos para el estado del juego
    public void finalizarTurno() {
        turnoJugador = !turnoJugador;
        setChanged();
        notifyObservers();
    }

    public boolean isTurnoJugador() {
        return turnoJugador;
    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
        setChanged();
        notifyObservers();
    }

    public int getVidaRival() {
        return vidaRival;
    }

    public void setVidaRival(int vidaRival) {
        this.vidaRival = vidaRival;
        setChanged();
        notifyObservers();
    }

    public List<CartaMounstro> getCartasJugador() {
        return cartasJugador;
    }

    public List<CartaMounstro> getCartasRival() {
        return cartasRival;
    }

    public List<CartaMounstro> getMonstruosJugador() {
        return cartasJugador;
    }

    public List<CartaMounstro> getMonstruosRival() {
        return cartasRival;
    }
}
