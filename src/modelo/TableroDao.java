package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableroDao {
	public static List<Tablero> obtenerTableros() throws SQLException {
		List<Tablero> tableros = new ArrayList<>();
		Connection connection = ConexionBD.getInstancia().getConexion();
		String sql = "SELECT * FROM tableros";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Tablero tablero = new Tablero(rs.getInt("id"), rs.getString("tipo_campo"), rs.getString("descripcion"));
				tableros.add(tablero);
			}
		}
		return tableros;
	}

}
