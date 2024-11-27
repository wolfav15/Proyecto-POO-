package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    protected Connection conexion;

    public JugadorDAO (){
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

    // Autenticar usuario
    public Integer login(String nombre, String pass) throws SQLException {
        String query = "SELECT * FROM Jugadores WHERE nombre = ? AND contrasenia = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, pass);
            try (ResultSet resultSet = statement.executeQuery()) {
                System.out.println("ID IDENTIFICADO: " + resultSet.getInt("id_jugador"));
                return resultSet.getInt("id_jugador"); // Retorna su id si encuentra un registro con el nombre y constraseña. Este id identifica al jugador.
            }catch (SQLException e) {
                System.out.println("Usuario no existe");
                return 0;
            }
        }
    
	public boolean esAdmin(String usuarioAdmin, String passAdmin) throws SQLException {
		
        String query = "SELECT * FROM Jugadores WHERE nombre = ? AND contrasenia = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, usuarioAdmin);
            statement.setString(2, passAdmin);
            try (ResultSet resultSet = statement.executeQuery()) {
                System.out.println("ID IDENTIFICADO: " + resultSet.getInt("id_jugador"));
                if  (resultSet.getInt("es_admin") == 1) {
                	return true;
                } else {
                	return false;
                }
            }catch (SQLException e) {
                System.out.println("Usuario no existe");
                return false;
            }
	}

    // Crear usuario
    public void  crearUsuario(String nombre, String pass) throws SQLException{
        String query = "INSERT INTO Jugadores (nombre, contrasenia) VALUES (?, ?)";
        try (PreparedStatement consulta = conexion.prepareStatement(query)) {
            consulta.setString(1, nombre);
            consulta.setString(2, pass);
            consulta.executeUpdate();
            System.out.println("Usuario creado.");
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE")) {
                System.out.println("Error: El nombre de usuario ya existe.");
            } else {
                System.out.println("Error en el else de crearUsuario");
                throw e;
            }
        }
        
    }

    // Actualizar un usuario existente
    public void actualizarUsuario(String nombre, String nuevoNombre, String pass, String nuevoPass, Boolean resetear) throws SQLException {
    	System.out.println(nombre);
    	System.out.println(nuevoNombre);
    	System.out.println(pass);
    	System.out.println(nuevoPass);
    	
    	Integer existeUsuario = login(nombre, pass);
    	int rowsAffected;
    	if (existeUsuario != 0) {
    		if (resetear = false) {
            	String query = "UPDATE Jugadores SET nombre = ?, contrasenia = ? WHERE nombre = ? and contrasenia = ?";
            	PreparedStatement statement = conexion.prepareStatement(query);
            	statement.setString(1, nuevoNombre);
                statement.setString(2, nuevoPass);
                statement.setString(3, nombre);
                statement.setString(4, pass);
                rowsAffected = statement.executeUpdate();
                
    		} else {
            	String query = "UPDATE Jugadores SET nombre = ?, contrasenia = ?, contador_victorias = ?, contador_derrotas = ? WHERE nombre = ? and contrasenia = ?";
            	PreparedStatement statement = conexion.prepareStatement(query);
            	statement.setString(1, nuevoNombre);
                statement.setString(2, nuevoPass);
                statement.setInt(3, 0);
                statement.setInt(4, 0);
                statement.setString(5, nombre);
                statement.setString(6, pass);
                rowsAffected = statement.executeUpdate();
    		}
                
                if (rowsAffected == 0) {
                    System.out.println("Error: Usuario no encontrado.");
                } else {
                    System.out.println("Contraseña actualizada correctamente para el usuario: " + nombre);
                }
            } else {
    		System.out.println("Error: Contraseña anterior incorrecta.");
    	}

    }

    // Eliminar un usuario existente
    public void borrarUsuario(String nombre, String pass) throws SQLException {
        String query = "DELETE FROM Jugadores WHERE nombre = ? and contrasenia = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, nombre);
        statement.setString(2, pass);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 0) {
                System.out.println("Error: Usuario no encontrado.");
            } else {
                System.out.println("Usuario eliminado correctamente: " + nombre);
        }
     }
    
    // Sumar 1 victoria
    public void sumarVictoria(Integer id) throws SQLException {
    	String query = "UPDATE Jugadores SET contador_victorias = contador_victorias + 1 WHERE id_jugador = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 0) {
        	System.out.println("Error: Usuario no encontrado.");
        } else {
        	System.out.println("Victorias aumentadas correctamente para el usuario con id: " + id);
        }
     }

    // Sumar 1 derrota
    public void sumarDerrota(Integer id) throws SQLException {
    	String query = "UPDATE Jugadores SET contador_derrotas = contador_derrotas + 1 WHERE id_jugador = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 0) {
        	System.out.println("Error: Usuario no encontrado.");
        } else {
        	System.out.println("Derrotas aumentadas correctamente para el usuario con id: " + id);
        }
     }
    
    public List<Usuario> obtenerUsuarios() throws SQLException{
    	
    	List<Usuario> usuarios = new ArrayList<>();
    	
    	String query = "SELECT * FROM Jugadores ORDER BY Jugadores.contador_victorias DESC";
    	PreparedStatement statement = conexion.prepareStatement(query);
        try(ResultSet resultSet = statement.executeQuery()){
                
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id_jugador");
                    String nombre = resultSet.getString("nombre");
                    Integer victorias = resultSet.getInt("contador_victorias");
                    Integer derrotas = resultSet.getInt("contador_derrotas");
                    usuarios.add(new Usuario(id, nombre, victorias, derrotas));
                }
        } catch (SQLException e){
            System.out.println("Error al obtener usuarios");
            throw e;
        }
        return usuarios;
    }
    
    public static void main(String[] args) throws SQLException {
        JugadorDAO dao = new JugadorDAO();
        dao.sumarVictoria(1);
    	
//        dao.borrarUsuario("pedro");
    }


}



