package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int puntosVida = 8000;
    private List<Carta> deck;
    private List<Carta> mano;
    // private List <Carta> cementerio; //No se usará por el momento

    public Jugador(String nombre, List<Carta> deck) {
        this.nombre = nombre;
        this.deck = deck;
        mano = new ArrayList<>();
    }

    public void robarCarta() {

        // maximo de 6 cartas en la mano
        if (this.mano.size() <= 5) {
            this.mano.add(this.deck.remove(0));
        } else {
            // este mensaje debería mostrarse en pantalla

            // maximo de 5 cartas en la mano
            if (this.mano.size() <= 5) {
                this.mano.add(this.deck.remove(0));
            } else {
                // este mensaje debería mostrarse en pantalla

                System.out.println("Mano llena, juegue una carta para vaciar un lugar");

            }

        }
    }

    public void jugarCarta(CartaMounstro cartaJugada, TableroModelo tablero, Campos campo) throws Exception {
        // Toda la lógica de agregar cartas al campo está incluida en la clase Campos.
        tablero.colocarCarta(cartaJugada, campo);
    }

    public void jugarCarta(CartaMounstro cartaJugada) throws Exception { // Se utiliza para remover la carta, también se
                                                                         // puede cambiar el nombre
        mano.remove(cartaJugada);
    }

    public void jugarCarta(CartaMagica cartaJugada) throws Exception {
        mano.remove(cartaJugada);
    }

    public void jugarCarta(CartaMagica cartaJugada, TableroModelo tablero, Campos campo) throws Exception {
        // Toda la lógica de agregar cartas al campo está incluida en la clase Campos.
        tablero.colocarCarta(cartaJugada, campo);
    }

    public void robarManoInicial() {
        for (int i = 0; i < 5; i++) {
            this.robarCarta();
        }
    }

    public void recibirDaño(int puntos) {
        this.puntosVida -= puntos;
    }

    public void recbirCuracion(int puntos) {
        this.puntosVida += puntos;
    }

    public void atacarCarta(CartaMounstro cartaAtacante, CartaMounstro CartaAtacada, Jugador oponente) {
        int danio = cartaAtacante.atacar(CartaAtacada);
        if (danio < 0) {
            oponente.recibirDaño(-danio);
        } else if (danio > 0) {
            this.recibirDaño(danio);
        }
    }

    public void atacarJugador(CartaMounstro cartaAtacante, Jugador oponente) {
        oponente.recibirDaño(cartaAtacante.getAtaque());
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public List<Carta> getMano() {
        return mano;
    }

}
