package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")

public class TableroModelo extends Observable {

    private Jugador jugador;
    private Jugador computadora;

    private Campos campoJugador;
    private Campos campoComputadora;

    private Integer id_tablero;
    private String tipo_elemento_tablero;
    private String imagenUrlTablero;
    private TableroDAO dao;


    private Random random = new Random();

    private Map<String, String> imagenes;

    private List<CartaMounstro> mounstruosQueAtacaron;

    public TableroModelo(Integer id_tablero, String tipo_elemento_tablero, String imagenUrlTablero) {
        this.id_tablero = id_tablero;
        this.tipo_elemento_tablero = tipo_elemento_tablero;
        this.imagenUrlTablero = imagenUrlTablero;
    }

    public TableroModelo( ) {
        this.dao = new TableroDAO();
        imagenes = new HashMap<>(); 
        imagenes.put("WATER", "src//modelo//Tablero_Water.png");
         imagenes.put("WIND", "src//modelo//Tablero_Wind.jpg");
         imagenes.put("FIRE", "src//modelo//Tablero_Fire.png");
         imagenes.put("EARTH", "src//modelo//Tablero_Tierra.jpg");
         imagenes.put("LIGHT", "src//modelo//Tablero_Light.png");
         imagenes.put("DARK", "src//modelo//Tablero_Dark.jpg");
         imagenes.put("Default", "src//modelo//tontos todos.jpg");
         setAtributosTableroModelo();
    }

    public void setAtributosTableroModelo() {
        jugador = new Jugador("Jugador1", this.bajarDeck());
        computadora = new Jugador("Computadora", this.bajarDeck());
        this.campoComputadora = new Campos();
        this.campoJugador = new Campos();
        this.mounstruosQueAtacaron = new ArrayList<>();

        try {
            // Obtener la lista de tableros una sola vez
            List<Tablero> tableros = dao.obtenerTableros();
            if (!tableros.isEmpty()) {
                int randomIndex = new Random().nextInt(tableros.size());
                // Seleccionar un tablero aleatoriamente y obtener su tipo de elemento
                this.tipo_elemento_tablero = tableros.get(randomIndex).getTipo_elemento_tablero();
                this.imagenUrlTablero = imagenes.getOrDefault(this.tipo_elemento_tablero, imagenes.get("Default"));
                System.out.println("Tablero seleccionado: " + this.tipo_elemento_tablero);
            } else {
                System.out.println("No hay tableros disponibles en la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public ArrayList<Carta> bajarDeck() {
        ArrayList<Carta> deck = new ArrayList<>();
        CartaDAO dao = new CartaDAO();
        try {
            deck = dao.obtenerCartas();
            Collections.shuffle(deck);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deck;
    }

    public void atacarEnTablero(Jugador atacante, CartaMounstro cartaAtacante, Jugador atacado,
            CartaMounstro cartaAtacada) throws Exception {
        if (!cartaAtacante.realizoAtaque()) {
            atacante.atacarCarta(cartaAtacante, cartaAtacada, atacado);
            cartaAtacante.yaAtacoEnTurno();
            mounstruosQueAtacaron.add(cartaAtacante);
        }
        if (!cartaAtacante.getActivo()) {
            campoJugador.removerCarta(cartaAtacante);
            campoComputadora.removerCarta(cartaAtacante);
        }
        if (!cartaAtacada.getActivo()) {
            campoComputadora.removerCarta(cartaAtacada);
            campoJugador.removerCarta(cartaAtacada);
        }
        notifyObservers();
        setChanged();
    }

    public void atacarJugador(CartaMounstro cartaAtacante, Jugador jugador_atacante, Jugador jugador_atacado) {
        if (!cartaAtacante.realizoAtaque()) {
            jugador_atacante.atacarJugador(cartaAtacante, jugador_atacado);
            cartaAtacante.yaAtacoEnTurno();
            mounstruosQueAtacaron.add(cartaAtacante);
        }

        notifyObservers();
        setChanged();
    }

    public void reiniciarAtaqueMounstruos() {
        for (CartaMounstro carta : mounstruosQueAtacaron) {
            carta.resetearAtaqueEnTurno();
            mounstruosQueAtacaron.remove(carta);
        }

        notifyObservers();
        setChanged();
    }

    public void jugarCartaEnTablero(CartaMounstro carta_jugada) throws Exception {
        if (carta_jugada.getElemento() == tipo_elemento_tablero) {
            carta_jugada.setAtaque(carta_jugada.getAtaque() + 600);
        }
        jugador.jugarCarta(carta_jugada, this, campoJugador);
        notifyObservers();
        setChanged();
    }

    public void jugarCartaEnTablero(CartaMagica carta_jugada) throws Exception {
        computadora.jugarCarta(carta_jugada, this, campoComputadora);
        notifyObservers();
        setChanged();
    }

    public void colocarCarta(CartaMagica carta, Campos campo) throws Exception {
        campo.agregarCartas(carta);
        carta.colocar();
        notifyObservers();
        setChanged();
    }

    public void colocarCarta(CartaMounstro carta, Campos campo) throws Exception {
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

    // Para hechizos
    public void usarMagia(CartaMagicaArrojadiza carta, Jugador jugador, Campos campo) throws Exception {
        carta.activar_efecto(jugador);
        campo.removerCarta(carta);
        notifyObservers();
        setChanged();
    }

    // Para equipamento
    public void usarMagia(CartaMagicaEquipada carta, CartaMounstro monstruo, Campos campo) throws Exception {
        carta.activar_efecto(monstruo);
        campo.removerCarta(carta);
        notifyObservers();
        setChanged();
    }

    public Boolean TerminarBatalla(Jugador jugaLag) {
        if (jugaLag.getPuntosVida() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Campos getCampoJugador() {
        return this.campoJugador;
    }

    public Campos getCampoComputadora() {
        return this.campoComputadora;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Jugador getComputadora() {
        return computadora;
    }

    public String getTipo_elemento_tablero() {
        return tipo_elemento_tablero;
    }

    public void setTipo_elemento_tablero(String tipo_elemento_tablero) {
        this.tipo_elemento_tablero = tipo_elemento_tablero;
    }

    public String getImagenUrlTablero() {
        return imagenUrlTablero;
    }

    public void setImagenUrlTablero(String imagenUrlTablero) {
        this.imagenUrlTablero = imagenUrlTablero;
    }

}