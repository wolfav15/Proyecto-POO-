package controlador;

import modelo.JugadorDAO;
import vista.VistaInicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorInicioSesion {
    private VistaInicioSesion vista; 
    private JugadorDAO JugadorDAO; 


    public ControladorInicioSesion(VistaInicioSesion vista, JugadorDAO jugadorDAO) {
        this.vista = vista;
        this.JugadorDAO = new JugadorDAO();

        //Al construirlo, se crea un evento al tocar el boton de login
        this.vista.getBotonLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
    }

    public void iniciarSesion() {
        String usuario = this.vista.getCampoUsuario().getText();
        String contrasenia = this.vista.getCampoContra().getText();
        int ID;


        if (usuario.isEmpty() || contrasenia.isEmpty()) {
        //Comprobamos que el usuario no este vacio
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
           
        }
    }



        // //Comprobamos que el usuario exista
        // if (!this.jugadorDAO.existeUsuario(usuario)) {
        //     JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        //     return;
        // }

        // //Comprobamos que la contraseña sea correcta
        // if (!this.jugadorDAO.existeContrasenia(usuario, contrasenia)) {
        //     JOptionPane.showMessageDialog(null, "La contraseña no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
        //     return;
        // }

        
    }


}
