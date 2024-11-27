package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.CartaDAO;
import modelo.JugadorDAO;
import vista.AgregarCarta;

public class ControladorAgregarCarta {
	
	private AgregarCarta vista;
	private CartaDAO dao;
	private JugadorDAO dao2;
	
	
	
	public ControladorAgregarCarta() {
		vista = new AgregarCarta();
		dao = new CartaDAO();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}
	
	private  void  inicializarEventos() {
	    vista.getBtnPrevisualizar().addMouseListener(new MouseAdapter() {
	       
	    	@SuppressWarnings("deprecation")
			@Override
	        public void mouseClicked(MouseEvent e) {
	        	vista.getLblImagen().setIcon(null); //Para limpiar la anterior imagen
	            Image image = null;
	            URL url = null;
	            
	            try {
	            	
	                url = new URL(vista.getTextUrl().getText()); 
	            } catch (MalformedURLException e1) {
	            	vista.mostrarMensaje("URL incorrecta, asegúrate de que lleve a una imagen.");
	                e1.printStackTrace();
	            }
	            
	            try {
	                image = ImageIO.read(url);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }

	            if (image != null) {
	                // Redimensionar la imagen a 200x300
	                Image imagenNueva = image.getScaledInstance(240, 360, Image.SCALE_SMOOTH);

	                // Poner la imagen redimensionada en el JLabel
	                vista.getLblImagen().setIcon(new ImageIcon(imagenNueva));
	            }
	        }
	    });
	    
	    vista.getBtnAgregar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		String nombre = vista.getTextNombre().getText().trim();
	    		String descripcion = vista.getTextDescripcion().getText().trim();
	    		
	    		Integer ataque = Integer.parseInt(vista.getTextAtaque().getText().trim());
	    		Integer defensa = Integer.parseInt(vista.getTextDefensa().getText().trim());
	    		Integer nivel = Integer.parseInt(vista.getBoxNivel().getSelectedItem().toString().trim());
	    		String elemento = vista.getBoxElemento().getSelectedItem().toString().trim();
	    		
	    		String url = vista.getTextUrl().getText().trim();
	    		
	    		String usuarioAdmin = vista.getTextUsuario().getText().trim();
	    		String passAdmin = String.valueOf(vista.getTextPass().getPassword()).trim();

	    	
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin))
						try {
							if (!dao.buscarCartaMonstruo(nombre)) {
								dao.crearCarta(nombre, descripcion, ataque, defensa, nivel, elemento, url);
								vista.mostrarMensaje("Carta creada.");
							} else {
								vista.mostrarMensaje("El nombre de la carta ya existe.");
							}

						} catch (SQLException e1) {
							vista.mostrarMensaje("Error en la inserción, comprueba los campos.");
							e1.printStackTrace();
						}
					else {
						vista.mostrarMensaje("Debes ser administrador para crear cartas.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	    		
	    	}
	    	
	    });
	}
	
    public static void main(String[] args) {
        new ControladorAgregarCarta();
    }
}
