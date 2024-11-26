
/*
 * Esta clase utiliza en patron Singleton para individualizar el acceso a las cartas.
 *      En la URL pido que me traiga un archivo JSON con solo las cartas normales de monstruos y que sean de nivel 3.
 * 
 *      Una vez obtenido el JSON necesitamos convertirlo a objetos Carta para que sea usable. De eso se encarga la dependencia "json-20200518.jar" de la carpeta lib.
 * 
 *      
 * 
 * 
 */



package modelo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class ConexionAPI {

    private CartaDAO dao;
    protected static ConexionAPI instancia;
    protected static List<CartaMounstro> listaCartaMounstros = new ArrayList<>();
        
        public ConexionAPI() throws Exception {
            try {
                URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?type=Normal%20Monster");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
    
                conn.connect();
    
                int codigoRespuesta = conn.getResponseCode();
    
                if (codigoRespuesta != 200) {
                    //No fue establecida la conexion.
                    throw new RuntimeException("Ocurrio un error:  " + codigoRespuesta);
                } else {
                    //Leer los datos recibidos de la correcta conexion
                    StringBuilder info = new StringBuilder();
                    Scanner scanner = new Scanner(url.openStream());
    
                    while(scanner.hasNext()){
                        info.append(scanner.nextLine());
                    }
    
                    scanner.close();
    
                    JSONObject respuesta = new JSONObject(info.toString());
                    JSONArray data = respuesta.getJSONArray("data");
                    
    
    
                    //Con la conexion establecida y las miles de cartas obtenidas. Filtro para que solo guardemos 60.
                    for (int contador = 0; contador < 60; contador++) {
    
                        JSONObject objeto = data.getJSONObject(contador); //Contiene la carta, de la cual solo nos interesan los siguientes atributos:
  
                        dao.crearCarta(
                            objeto.getString("name"),
                            objeto.getString("desc"),
                            objeto.getInt("atk"),
                            objeto.getInt("def"),
                            objeto.getInt("level"),
                            objeto.getString("attribute"), //Atributo significa elemento
                            objeto.getJSONArray("card_images").getJSONObject(0).getString("image_url"));

                        //Cartas agregadas
                    }
                }
            } catch (MalformedURLException e) {
                System.out.println(e);
            }
        }
    
        public static ConexionAPI getInstancia() throws Exception {
            if (instancia == null) {
                instancia = new ConexionAPI();
            }
        return instancia;
	    }

    public List<CartaMounstro> getCartas() {
		return listaCartaMounstros;
	}





    //ESTE MAIN GENERA Y AGREGA CARTAS A LA DB ( USAR SOLO UNA VEZ PARA EVITAR CARTAS DUPLICADAS ). 
    public static void main(String[] args) throws Exception {
        try {
            ConexionAPI conexion = ConexionAPI.getInstancia(); //Obtengo la instancia con la conexion establecida.
            List<CartaMounstro> cartasObtenidas = conexion.getCartas(); //Obtengo las cartas de esa conexion.

            for (CartaMounstro cartaMounstro : cartasObtenidas) {

                    String nombre = cartaMounstro.getNombre();
                     String descripcion = cartaMounstro.getDescripcion();
                     Integer ataque = cartaMounstro.getAtaque();
                     Integer defensa = cartaMounstro.getDefensa();
                      Integer nivel = cartaMounstro.getNivel();
                        String img = cartaMounstro.getImagen();
                          String elem = cartaMounstro.getElemento();

                CartaDAO dao = new CartaDAO();

                dao.crearCarta(nombre, descripcion, ataque, defensa, nivel, img, elem);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



