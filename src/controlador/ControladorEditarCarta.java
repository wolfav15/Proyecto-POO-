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
import modelo.CartaMounstro;
import modelo.JugadorDAO;
import vista.EditarCarta;

public class ControladorEditarCarta {
	
	private EditarCarta vista;
	private CartaDAO dao;
	private JugadorDAO dao2;
	
	
	
	public ControladorEditarCarta() {
		vista = new EditarCarta();
		dao = new CartaDAO();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}
	
	private void  inicializarEventos() {
	    vista.getBtnPrevisualizar().addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		visualizarImagen(vista.getTextUrl().getText());
	    	}
	    	
	        
	    });
	    
	    vista.getBtnEditar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		Integer id = Integer.parseInt(vista.getTextId().getText().trim());
	    		
	    		String nombre = vista.getTextNombre().getText().trim();
	    		String descripcion = vista.getTextDescripcion().getText().trim();
	    		
	    		Integer ataque = Integer.parseInt(vista.getTextAtaque().getText().trim());
	    		Integer defensa = Integer.parseInt(vista.getTextDefensa().getText().trim());
	    		Integer nivel = Integer.parseInt(vista.getBoxNivel().getSelectedItem().toString().trim());
	    		String elemento = vista.getBoxElemento().getSelectedItem().toString().trim();
	    		
	    		String url = vista.getTextUrl().getText().trim();
	    		
	    		String usuarioAdmin = vista.getTextUsuario().getText().trim();
	    		String passAdmin = String.valueOf(vista.getTextPass().getPassword()).trim();

	    		
//	    		System.out.println("\nNombre: " + nombre + 
//	    				"\nDescripcion: " + descripcion +
//	    				"\nAtaque: " + ataque +
//	    				"\nDefensa: " + defensa +
//	    				"\nElemento: " + elemento +
//	    				"\nURL: " + url +
//	    				"\nUsuario ADMIN: " + usuarioAdmin + 
//	    				"\nPass ADMIN: " + passAdmin
//	    				);
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin))
						try {
							if (dao.buscarCartaMonstruo(nombre) == false) {
								dao.actualizarCarta(id, nombre, descripcion, ataque, defensa, nivel, elemento, url);
								vista.mostrarMensaje("Carta editada para el id: " + id);
							} else {
								vista.mostrarMensaje("El nombre de la carta ya existe.");
							}

						} catch (SQLException e1) {
							vista.mostrarMensaje("Error en la EDICION, comprueba los campos.");
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
	    
	    vista.getBtnBuscar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Integer id = Integer.parseInt(vista.getTextId().getText().trim());
	    		CartaMounstro cartaBuscada = null;
	    		try {
					cartaBuscada = dao.buscarCartaMonstruo(id);
				} catch (SQLException e1) {
					vista.mostrarMensaje("No se encontró la carta");
					e1.printStackTrace();
				}
	    		
	    		if (cartaBuscada == null) {
	    			vista.mostrarMensaje("No se encontró la carta");
	    		}
	    		
	    		vista.getTextNombre().setText(cartaBuscada.getNombre());
	    		vista.getTextDescripcion().setText(cartaBuscada.getDescripcion());
	    		
	    		vista.getTextAtaque().setText(String.valueOf(cartaBuscada.getAtaque()));
	    		vista.getTextDefensa().setText(String.valueOf(cartaBuscada.getDefensa()));
	    		vista.getBoxNivel().setSelectedItem(String.valueOf(cartaBuscada.getNivel()));
	    		vista.getBoxElemento().setSelectedItem(cartaBuscada.getElemento());
	    		
	    		vista.getTextUrl().setText(cartaBuscada.getImagen());
	    		
	    		visualizarImagen(vista.getTextUrl().getText());
	    		
	    	}
	    });
	}
	
	@SuppressWarnings("deprecation")
	public void visualizarImagen(String link) {
		vista.getLblImagen().setIcon(null); //Para limpiar la anterior imagen
        Image image = null;
        URL url = null;
        
        try {
        	
            url = new URL(link); 
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
	
    public static void main(String[] args) {
        new ControladorEditarCarta();
    }
}