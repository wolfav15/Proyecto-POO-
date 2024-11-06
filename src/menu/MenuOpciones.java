package menu;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import musica.ReproductorMusica;

import javax.swing.*;
import java.awt.*;
public class MenuOpciones extends JFrame {    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ReproductorMusica reproductorMusica;

    public MenuOpciones() {        
        setTitle("Opciones");         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setBounds(100, 100, 450, 300);        
        contentPane = new JPanel();        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));        
        setContentPane(contentPane);        
        contentPane.setLayout(new GridBagLayout());                

        GridBagConstraints gbc = new GridBagConstraints();        
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre botones          

        JButton botonDificultad = new JButton("Dificultad");         
        JButton botonSalir = new JButton("Salir");         
        JButton botonReproducirMusica = new JButton("Reproducir Música");         
        JButton botonPararMusica = new JButton("Parar Música");          

        // Añadir los botones al panel de menú centrado        
        gbc.gridx = 0;        
        gbc.gridy = 0;         
        contentPane.add(botonDificultad, gbc);              
        
        gbc.gridy++;          
        contentPane.add(botonReproducirMusica, gbc);          
        
        gbc.gridy++;          
        contentPane.add(botonPararMusica, gbc);          
        
        gbc.gridy++;          
        contentPane.add(botonSalir, gbc);      
        
        // Acción para Dificultad       
        botonDificultad.addActionListener(e -> mostrarMensaje("Seleccionando Dificultad"));       

        // Inicializar ReproductorMusica       
        reproductorMusica = new ReproductorMusica();

        // Acción para Reproducir Música       
        botonReproducirMusica.addActionListener(e -> {       
            String rutaArchivo = "C:\\Users\\samue\\Desktop\\Rata Blanca - La Leyenda del Hada y el Mago (En Vivo).mp3";           
            reproductorMusica.reproducir(rutaArchivo);           
            mostrarMensaje("Reproduciendo: Rata Blanca - La Leyenda del Hada y el Mago");       
        });

        // Acción para Parar Música       
        botonPararMusica.addActionListener(e -> {        
            reproductorMusica.detener();           
            mostrarMensaje("Música detenida");
        });

        // Acción para Salir       
        botonSalir.addActionListener(e -> System.exit(0));    
    }    

    private void mostrarMensaje(String mensaje) {        
        JOptionPane.showMessageDialog(this, mensaje);    
    }    

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(() -> {            
            MenuOpciones frame = new MenuOpciones();            
            frame.setVisible(true);        
        });    
    }
}
