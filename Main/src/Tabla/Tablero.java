
public class Tablero {
	private Jugador jugador1;
	private Jugador jugador2; 
    private int idTablero;
    private String tipoTablero;

    public Tabla (int idTabla, String tipoTabla) {
	    this.idTablero = idTabla;
	    this.tipoTablero =tipoTabla; 
    }

    public static List<Tablero> obtenerTableros(Connection connection) throws SQLException {
        List<Tablero> tableros = new ArrayList<>();
        String sql = "SELECT * FROM tableros";
    try (PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Tablero tablero = new Tablero(
                rs.getInt("tablero_id"),
                rs.getString("tipo_tablero")
            );
            tableros.add(tablero);
        }
    }
    return tableros;
    }
}
