package controlador;

import modelo.JugadorDAO;
import vista.VistaInicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorInicioSesion {
    private VistaInicioSesion vista; 
    private JugadorDAO JugadorDAO; 


    public ControladorInicioSesion(VistaInicioSesion vista, JugadorDAO jugadorDAO) {
        this.vista = vista;
        this.JugadorDAO = new JugadorDAO();

        iniciarVista();

        this.vista.getBotonLogin().setEnabled(true);

        //Al construirlo, se crea un evento al tocar el boton de login
        this.vista.getBotonLogin().addActionListener(e -> {
            
                iniciarSesion();
                
            });

            this.vista.getBotonCrearCuenta().addActionListener(e -> {
            
                CrearUsuario();
                
            });
        }
    

    public void iniciarVista() {
        this.vista.setVisible(true);
    }

    

    public void iniciarSesion() {
        String usuario = this.vista.getCampoUsuario().getText();
        String contrasenia = this.vista.getCampoContra().getText();


        if (usuario.isEmpty() || contrasenia.isEmpty()) {
        //Comprobamos que el campo usuario no este vacio
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de usuario no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Comprobamos que la contraseña no este vacia
        if (contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de contraseña no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        else {
           try {
        // El metodo login retorna el ID del usuario si es correcto, si no retorna 0
        int idUsuario = JugadorDAO.login(usuario, contrasenia);

        if (idUsuario > 0) {
            JOptionPane.showMessageDialog(vista, "¡Inicio de sesión exitoso! ID: " + idUsuario);

            try {
                Thread.sleep(2000);
                ControladorMenu controladorMenu = new ControladorMenu();

                vista.setVisible(false);
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        } else {
            JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(vista, "Error en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // No tengo idea de esto
    }
        }
    }
    }

    public static void main(String[] args) {
        VistaInicioSesion vista = new VistaInicioSesion();
        new ControladorInicioSesion(vista, null);
    }

}
