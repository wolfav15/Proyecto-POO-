package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableroDAO {
    
    protected Connection conexion;

    public TableroDAO(){
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

    public Boolean buscarTablero (String tipo_elemento_tablero) throws SQLException{
        String query = "SELECT * FROM Tableros WHERE Tableros.tipo_elemento_tablero = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)){
            consulta.setString(1, tipo_elemento_tablero);
            ResultSet resultado = consulta.executeQuery();
            // Si hay al menos una fila en el resultado, el tablero fue encontrado
            if (resultado.next()) {
            	System.out.println("Tablero encontrado.");
            	return true;	
            }
            return false;
        } catch(SQLException e){
            System.out.println("No se pudo buscar el tablero.");
            throw e;
        }
    }

    public void crearTablero(String tipo_elemento_tablero, String url) throws SQLException {
        if (!buscarTablero(tipo_elemento_tablero)){
            String query = "INSERT INTO Tableros (tipo_elemento_tablero, imagenUrlTablero) VALUES (?, ?)";
            try (PreparedStatement consulta = conexion.prepareStatement(query)) {
                consulta.setString(1, tipo_elemento_tablero);
                consulta.setString(2, url);
                consulta.executeUpdate();
                System.out.println("Tablero ingresado.");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar query.");
                e.printStackTrace();
            }
        } else {
                System.out.println("El Tablero ya existe con ese elemento.");
        }
    }

    public void actualizarTablero (Integer id_tablero, String tipo_elemento_tablero, String url) throws SQLException{

        String query = "UPDATE Tableros SET tipo_elemento_tablero = ?, imagenUrlTablero = ? where Tableros.id_tablero = ?";
        try (PreparedStatement consulta = conexion.prepareStatement(query)){
            consulta.setString(1, tipo_elemento_tablero);
            consulta.setString(2, url);
            consulta.setInt(3, id_tablero);
            int filasAfectadas = consulta.executeUpdate();
            if (filasAfectadas == 0) {
                System.out.println("Error: Tablero no editado.");
            } else {
                System.out.println("Tablero actualizado correctamente para el id: " + id_tablero + ".");
            }
        } catch(SQLException e){
            System.out.println("No se pudo buscar el Tablero.");
            throw e;
        }
    }

    public void borrarTablero (Integer id_tablero) throws SQLException{
        try {
            String query = "DELETE FROM Tableros WHERE id_tablero = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id_tablero);
            Integer rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Error: Tablero no encontrado.");
            } else {
                System.out.println("Tablero eliminado correctamente para el id: " + id_tablero + ".");
            }
        } catch (SQLException e){
            throw e;
        }
    }
    
    public ArrayList<TableroModelo> obtenerTableros() throws SQLException{
            ArrayList<TableroModelo> tableros = new ArrayList<>();
            String query = "SELECT * FROM Tableros";
            PreparedStatement statement = conexion.prepareStatement(query);
            try(ResultSet res = statement.executeQuery()){   
                while (res.next()) {
                TableroModelo tableroHecho = new TableroModelo(
                    res.getInt("id_tablero"),
                    res.getString("tipo_eslento_tablero"),
                    res.getString("imagenUrlTablero"));
                        tableros.add(tableroHecho);
                    }
                } catch (SQLException e) {
                    System.out.println("Error al traer los tableros de la db.");
                    throw e;
                }
                return tableros;
            }
}