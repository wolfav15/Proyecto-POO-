package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaDAO {
    
    protected Connection conexion;

    public CartaDAO(){
        try {
			conexion = ConexionBD.getInstancia().getConexion();
			if (conexion != null) {

				System.out.println("Conexión establecida correctamente DESDE DAO");
			} else {
				System.out.println("Error al establecer la conexión DESDE DAO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }



    public Boolean buscarCartaMonstruo (String nombre) throws SQLException{
        String query = "select * from Cartas where Cartas.nombre = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)){
            consulta.setString(1, nombre);
            ResultSet resultado = consulta.executeQuery();
            // Si hay al menos una fila en el resultado, la carta fue encontrada
            if (resultado.next()) {
            	System.out.println("Carta encontrada");
            	return true;	
            }
            return false;
        } catch(SQLException e){
            System.out.println("No se pudo buscar la carta");
            throw e;
        }
    }

    public CartaMounstro buscarCartaMonstruo (Integer id) throws SQLException{
        String query = "select * from Cartas where Cartas.id_carta = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)){
            consulta.setInt(1, id);
            ResultSet res = consulta.executeQuery();
            // Si hay al menos una fila en el resultado, la carta fue encontrada
            if(res.next()){
                return new CartaMounstro(
                		res.getInt("id_carta"),
                    res.getString("nombre"),
                    res.getString("descripcion"),
                    res.getInt("nivel"),
                    res.getString("id_tipo_carta"),
                    res.getString("imagenUrl"),
                    res.getInt("ataque"),
                    res.getInt("defensa"),
                    res.getString("tipo_elemento")
                );
            } else {
                System.out.println("No encontro carta con ese id");
            }
        } catch(SQLException e){
            System.out.println("No se pudo buscar la carta");
            throw e;
        }
        return null;
    }


    public void crearCarta( String nombre, String descripcion, Integer ataque, Integer defensa, Integer nivel, String elemento, String url ) throws SQLException {
        if (!buscarCartaMonstruo(nombre)){
            String query = "INSERT INTO Cartas (nombre, descripcion, id_tipo_carta, cantidad_efecto, ataque, defensa, nivel, tipo_elemento, imagenUrl) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement consulta = conexion.prepareStatement(query)) {
                consulta.setString(1, nombre);
                consulta.setString(2, descripcion);
                consulta.setInt(3, 1); // tipo_carta  --> 1 = monstruo
                consulta.setNull(4, 0); //cantidad_efecto --> null
                consulta.setInt(5, ataque);
                consulta.setInt(6, defensa);
                consulta.setInt(7, nivel);
                consulta.setString(8, elemento);
                consulta.setString(9, url);
                consulta.executeUpdate();
                System.out.println("Carta ingresada.");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar query");
                e.printStackTrace();;
            }
        } else {
                System.out.println("Carta existe con ese nombre");
        }
    }
    public void actualizarCarta (Integer id, String nombre, String descripcion, Integer ataque, Integer defensa, Integer nivel, String elemento, String url) throws SQLException{

        String query = "update Cartas set nombre = ?, descripcion = ?, id_tipo_carta = ?, cantidad_efecto = ?, ataque = ?, defensa = ?, nivel = ?, tipo_elemento = ?, imagenUrl = ? where Cartas.id_carta = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)){
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setInt(3, 1);
            consulta.setNull(4, 0);
            consulta.setInt(5, ataque);
            consulta.setInt(6, defensa);
            consulta.setInt(7, nivel);
            consulta.setString(8, elemento);
            consulta.setString(9, url);
            consulta.setInt(10, id);
            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas == 0) {
                System.out.println("Error: Carta no editada.");
            } else {
                System.out.println("Carta actualizada correctamente para el id: " + id);
            }
        } catch(SQLException e){
            System.out.println("No se pudo buscar la carta");
            throw e;
        }
    }

    public List<CartaMounstro> obtenerCartas() throws SQLException{
    	List<CartaMounstro> cartas = new ArrayList<>();
    	String query = "SELECT * FROM Cartas where id_tipo_carta = 1";
    	PreparedStatement statement = conexion.prepareStatement(query);
        try(ResultSet res = statement.executeQuery()){   
            while (res.next()) {
                CartaMounstro cartaHecha = new CartaMounstro(
                	res.getInt("id_carta"),
                    res.getString("nombre"),
                    res.getString("descripcion"),
                    res.getInt("nivel"),
                    res.getString("id_tipo_carta"),
                    res.getString("imagenUrl"),
                    res.getInt("ataque"),
                    res.getInt("defensa"),
                    res.getString("tipo_elemento"));
                    cartas.add(cartaHecha);
                }
            } catch (SQLException e) {
                System.out.println("Error al traer las cartas de la db");
                throw e;
            }
            return cartas;
        }

        public void borrarCarta (Integer id) throws SQLException{
            try {
                String query = "DELETE FROM Cartas WHERE id_carta = ?";
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, id);
                Integer rowsAffected = statement.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Error: Carta no encontrada.");
                } else {
                    System.out.println("Carta eliminada correctamente para el id: " + id);
                }
            } catch (SQLException e){
                throw e;
            }
        }

        public static void main(String[] args) throws SQLException {
            CartaDAO dao = new CartaDAO();
            // List<CartaMounstro> cartas = new ArrayList<>();
            // cartas = dao.obtenerCartas();
            System.out.println(dao.buscarCartaMonstruo(21).toString());
            // for (CartaMounstro cartaMounstro : cartas) {
            //     System.out.println(cartaMounstro.toString());
            // }
            
        }
}
