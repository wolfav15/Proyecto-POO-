package Jugador;

import java.util.List;
import Clases.*;

public class Jugador {
    private String nombre;
    private int puntosVida = 8000;
    private List <Carta> deck;
    private List <Carta> mano;
    private Campo campoJugador;

    //private List <Carta> cementerio; //No se usará por el momento
    
    public Jugador(String nombre, List <Carta> deck) {
        this.nombre = nombre;
        this.deck = deck;
        //this.cementerio = cementerio;
    }

    public void robarCarta() {
        this.mano.add(this.deck.remove(0));
    } 

    public void jugarCarta(Carta cartaJugada) { 
        String jugada =    cartaJugada.getClass().toString();


        switch (jugada) {
            case "CartaMonstruo":
                this.campoJugador.agregarMonstruo(cartaJugada);
                break;
                
            case "CartaMagicaEquipo":
                this.campoJugador.agregarCartaMagicaEquipo(cartaJugada);
                break;
                
            case "CartaMagicaNormal":
                    this.campoJugador.agregarCartaMagica(cartaJugada);
                    cartaJugada.activar_efecto();
                break;
                
        
            default:
                break;
        }

        if (jugada.equals("CartaMonstruo")) {
            this.campoJugador.agregarMonstruo(cartaJugada);
         }
    }

    public void robarManoInicial()  {
        for (int i = 0; i < 5; i++) {
            this.robarCarta();
    } }

    public void recibirDaño(int puntos) {
        this.puntosVida -= puntos;
    }
}
