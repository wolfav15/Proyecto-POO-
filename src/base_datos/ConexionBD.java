import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;
    private String url = "jdbc:postgresql://localhost:5432/Proyecto_POO"; // o "jdbc:mysql://localhost:3306/tu_base_de_datos"
    private String usuario = "postgres";
    private String contraseña = "26072002";

    private ConexionBD() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // o "com.mysql.cj.jdbc.Driver" para MySQL
            this.conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de la base de datos: " + ex.getMessage());
        }
    }

    public static ConexionBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        } else if (instancia.getConexion().isClosed()) {
            instancia = new ConexionBD();
        }

        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
