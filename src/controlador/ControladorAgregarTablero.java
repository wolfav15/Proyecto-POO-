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
import modelo.TableroDAO;
import vista.AgregarTablero;

public class ControladorAgregarTablero {

	private TableroDAO dao;
	private JugadorDAO dao2;
	private AgregarTablero vista;
	
	public ControladorAgregarTablero() {
		dao = new TableroDAO();
		vista = new AgregarTablero();
		dao2 = new JugadorDAO();
		inicializarEventos();
		vista.setVisible(true);
	}

	private void inicializarEventos() {
	    vista.getBtnPrevisualizar().addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		visualizarImagen(vista.getTextUrl().getText());
	    	}
	    });
	    vista.getBtnAgregar().addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		String elemento = vista.getBoxElemento().getSelectedItem().toString().trim();
	    		String url = vista.getTextUrl().getText().trim();
	    		
	    		String usuarioAdmin = vista.getTextUsuario().getText().trim();
	    		String passAdmin = String.valueOf(vista.getPasswordField().getPassword()).trim();

	    		
	    		try {
					if (dao2.esAdmin(usuarioAdmin, passAdmin)) {

								dao.crearTablero(elemento, url);
								vista.mostrarMensaje("Tablero creada.");
							
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
            Image imagenNueva = image.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
            // Poner la imagen redimensionada en el JLabel
            vista.getImagenLbl().setIcon(new ImageIcon(imagenNueva));
        }




		
	}
}
