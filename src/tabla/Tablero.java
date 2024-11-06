package tabla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_datos.ConexionBD;
import jugador.Jugador;

public class Tablero {
private Jugador jugador1;
private Jugador jugador2; 
 private int idTablero;
  private String tipoTablero;
  private String Descripcion;

public  Tablero (int idTabla, String tipoTabla,String Descripcion) {
	this.idTablero= idTabla;
	this.tipoTablero =tipoTabla;
	this.Descripcion= Descripcion;
}

//esto es para bajar las tablas que estan en la base de datos. 
public static List<Tablero> obtenerTableros() throws SQLException {
    List<Tablero> tableros = new ArrayList<>();
    Connection connection = ConexionBD.getInstancia().getConexion();
    String sql = "SELECT * FROM tableros";
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Tablero tablero = new Tablero(
                rs.getInt("id"),
                rs.getString("tipo_campo"),
                rs.getString("descripcion")
            );
            tableros.add(tablero);
        }
    }
    return tableros;
}



public static void main(String[] args) {
	 try {
         List<Tablero> tableros = obtenerTableros();
         for (Tablero tablero : tableros) {
             System.out.println("Tablero ID: " + tablero.idTablero + ", Tipo: " + tablero.tipoTablero + ", descripcion: " +  tablero.Descripcion);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

}

