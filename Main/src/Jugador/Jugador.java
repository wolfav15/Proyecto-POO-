package Jugador;

import java.util.List;
import Clases.*;
//No tengo idea de como jugar Yu-Gi-Oh :D
public class Jugador {
    private String nombre;
    private int puntosVida = 8000;
    private List <Carta> deck;
    private List <Carta> mano;
    private List <Carta> cementerio;
    
    public Jugador(String nombre, List <Carta> deck, List <Carta> mano, List <Carta> cementerio) {
        this.nombre = nombre;
        this.deck = deck;
        this.mano = mano;
        this.cementerio = cementerio;
    }

    public void robarCarta() {
        this.mano.add(this.deck.remove(0));
    } 

    public void jugarCarta(Carta cartaJugada) {
        
    }

    public void recibirDaño(int puntos) {
        this.puntosVida -= puntos;
    }
}
