package ViejoSamuel;

import modelo.Carta;
import modelo.CartaMounstro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class TableroModeloSamuel extends Observable {
    private List<CartaMounstro> cartasJugador;
    private List<CartaMounstro> cartasRival;
    private boolean turnoJugador; // true si es el turno del jugador, false si es el del rival
    private int vidaJugador;
    private int vidaRival;
    private List<CartaMounstro> baraja;
    private List<Carta> manoJugador;

    public TableroModeloSamuel() {
        this.cartasJugador = new ArrayList<>();
        this.cartasRival = new ArrayList<>();
        this.baraja = new ArrayList<>();
        this.manoJugador = new ArrayList<>();
        this.turnoJugador = true; // Empieza el jugador
        this.vidaJugador = 8000; // Valor inicial típico en muchos juegos de cartas
        this.vidaRival = 8000;
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        // Añadir cartas a la baraja con imágenes
        baraja.add(new CartaMounstro("Dragón Blanco de Ojos Azules", "Un poderoso dragón", 3000, 2500, 8, "Luz", "src//ImagenesJuego//dragon_blanco.jpg"));
        baraja.add(new CartaMounstro("Caballero de la Luz", "Un caballero valiente y noble", 1500, 1000, 6, "Luz", "ruta/a/la/imagen/caballero_luz.jpg"));
        baraja.add(new CartaMounstro("Mago del Fuego", "Un mago que controla el fuego", 1200, 800, 4, "Fuego", "src//ImagenesJuego//mago.jpg"));
        baraja.add(new CartaMounstro("Goblin", "Un pequeño y astuto goblin", 800, 600, 2, "Tierra", "src//ImagenesJuego//duende.jpg"));
        baraja.add(new CartaMounstro("Ángel de la Muerte", "Un ángel que trae la muerte", 2000, 1500, 9, "Oscuridad", "src//ImagenesJuego//angel_muerte.jpg"));
        baraja.add(new CartaMounstro("Dios del Trueno", "Un dios que controla el trueno", 2500, 2000, 10, "Trueno", "src//ImagenesJuego//dios_muerte.jpg"));
        baraja.add(new CartaMounstro("Vampiro", "Un vampiro sediento de sangre", 1000, 800, 3, "Oscuridad", "src//ImagenesJuego//vampiro.jpg"));
        baraja.add(new CartaMounstro("Hombre Lobo", "Un hombre que se transforma en lobo", 1200, 1000, 5, "Tierra", "src//ImagenesJuego//hombre_lobo.jpg"));
        baraja.add(new CartaMounstro("Bruja del Mar", "Una bruja que controla el mar", 1500, 1200, 7, "Agua", "src//ImagenesJuego//bruja_mar.jpg"));
        baraja.add(new CartaMounstro("Demonio del Infierno", "Un demonio que trae la destrucción", 3000, 2500, 12, "Oscuridad", "src//ImagenesJuego//demonio.jpg"));
        // Barajar las cartas
        Collections.shuffle(baraja);
    }
    

    public Carta robarCarta() {
        if (!baraja.isEmpty()) {
            return baraja.remove(0);
        }
        return null;
    }

    public void añadirCartaAMano(Carta carta) {
        if (manoJugador.size() < 5) { // Asegurarse de que la mano no tenga más de 5 cartas
            manoJugador.add(carta);
            setChanged();
            notifyObservers();
        }
    }

    // Métodos de gestión de cartas
    public void agregarCartaJugador(CartaMounstro carta) {
        if (cartasJugador.size() < 5) {
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

    public List<Carta> getManoJugador() {
        return manoJugador;
    }
}
