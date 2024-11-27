package controlador;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.JugadorDAO;
import modelo.Tablero;
import modelo.TableroDAO;
import vista.EditarTablero;

public class ControladorEditarTablero {

	private TableroDAO dao;
	private JugadorDAO dao2;
	private EditarTablero vista;
	
	public ControladorEditarTablero() {
		dao = new TableroDAO();
		vista = new EditarTablero();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}

	private void inicializarEventos() {
		vista.getBtnBuscar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Integer id = Integer.parseInt(vista.getTextId().getText().trim());
	    		Tablero tableroBuscado = null;
	    		try {
	    			tableroBuscado = dao.buscarTablero(id);
	    			vista.getTextUrl().setText(tableroBuscado.getImagenUrlTablero());
	    			vista.getBoxElemento().setSelectedItem(tableroBuscado.getTipo_elemento_tablero());
	    			visualizarImagen(tableroBuscado.getImagenUrlTablero());
	    			
				} catch (SQLException e1) {
					vista.mostrarMensaje("No se encontró la carta");
					e1.printStackTrace();
				}

	    	}
	    });
		
	    vista.getBtnPrevisualizar().addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		visualizarImagen(vista.getTextUrl().getText());
	    	}
	    });
	    vista.getBtnEditar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		Integer id = Integer.parseInt(vista.getTextId().getText().trim());
	    		String elemento = vista.getBoxElemento().getSelectedItem().toString().trim();
	    		String url = vista.getTextUrl().getText().trim();
	    		
	    		String usuarioAdmin = vista.getTextUsuario().getText().trim();
	    		String passAdmin = String.valueOf(vista.getPasswordField().getPassword()).trim();

	    		
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin)) {

								dao.actualizarTablero(id, elemento, url);
								vista.mostrarMensaje("Tablero actualizado para el ID: " +id);
							
						}else {
						vista.mostrarMensaje("Debes ser administrador para crear cartas.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	    		
	    	}
	    	
	    });
	    
	    
	    
	}
	
	@SuppressWarnings("deprecation")
	public void visualizarImagen(String link) {
		vista.getImagenLbl().setIcon(null); //Para limpiar la anterior imagen
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
            Image imagenNueva = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

            // Poner la imagen redimensionada en el JLabel
            vista.getImagenLbl().setIcon(new ImageIcon(imagenNueva));
        }
	}
}

