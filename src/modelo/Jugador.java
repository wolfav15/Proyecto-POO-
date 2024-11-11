package modelo;
import java.util.List;
public class Jugador {
    private String nombre;
    private int puntosVida = 8000;
    private List <Carta> deck;
    private List <Carta> mano;
    private Campos campoJugador;

    //private List <Carta> cementerio; //No se usará por el momento
    
    public Jugador(String nombre, List <Carta> deck) {
        this.nombre = nombre;
        this.deck = deck;
        //this.cementerio = cementerio;
    }

    public void robarCarta() {
        //maximo de 6 cartas en la mano 
        if (this.mano.size() <= 5){
        this.mano.add(this.deck.remove(0));
        }
        else {
            //este mensaje debería mostrarse en pantalla 
            System.out.println("Mano llena, juegue una carta para vaciar un lugar");
        }
    } 

    public void jugarCarta(Carta cartaJugada) { 
        //Toda la lógica de agregar cartas al campo está incluida en la clase Campos.
        this.campoJugador.agregarCartas(cartaJugada);
    }

    public void robarManoInicial()  {
        for (int i = 0; i < 5; i++) {
            this.robarCarta();
    } }

    public void recibirDaño(int puntos) {
        this.puntosVida -= puntos;
    }
   
}
