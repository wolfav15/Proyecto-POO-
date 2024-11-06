package base_datos;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.getInstancia().getConexion();
            if (conexion != null) {
                System.out.println("Conexión establecida correctamente");
            } else {
                System.out.println("Error al establecer la conexión");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}