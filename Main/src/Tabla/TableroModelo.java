import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Carta.Carta;
import Jugador.Jugador;

public class TableroModelo {
   Tablero tablero = new Tablero(0, "Fuego", "Hace mas calor ");
    ArrayList<Carta> Cartas1 = new ArrayList<>();
    ArrayList<Carta> Cartas2 = new ArrayList<>();
    ArrayList<Carta> cementerio = new ArrayList<>();
    ArrayList<Carta> cementerio2 = new ArrayList<>();
    ArrayList<Carta> mano1= new ArrayList<>();
    ArrayList<Carta> mano2= new ArrayList<>();
   Jugador jugador1 = new Jugador("Jugador1",mano1, Cartas1,cementerio);
   Jugador jugador2 = new Jugador("Jugador2",mano2,Cartas2,cementerio2)
		  
		   


}



