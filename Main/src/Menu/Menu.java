import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Juego de Cartas de Monstruos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Batalla
        JMenu menuBatalla = new JMenu("Batalla");
        JMenuItem mostrarMazo = new JMenuItem("Mostrar Mazo");
        JMenuItem mostrarTabla = new JMenuItem("Mostrar Tabla");
        JMenuItem cpuJugador = new JMenuItem("CPU o Jugador");
        JMenuItem reglasBatalla = new JMenuItem("Reglas de Batalla");

        menuBatalla.add(mostrarMazo);
        menuBatalla.add(mostrarTabla);
        menuBatalla.add(cpuJugador);
        menuBatalla.add(reglasBatalla);

        // Menú Opciones
        JMenu menuOpciones = new JMenu("Opciones");
        JMenuItem seleccionMusical = new JMenuItem("Selección Musical");
        JMenuItem dificultad = new JMenuItem("Dificultad");

        menuOpciones.add(seleccionMusical);
        menuOpciones.add(dificultad);

        // Menú Salir
        JMenu menuSalir = new JMenu("Salir");
        JMenuItem salirJuego = new JMenuItem("Salir");
        salirJuego.addActionListener(e -> System.exit(0));

        menuSalir.add(salirJuego);

        // Añadir menús a la barra de menús
        menuBar.add(menuBatalla);
        menuBar.add(menuOpciones);
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        // Acción para Mostrar Mazo
        mostrarMazo.addActionListener(e -> mostrarMensaje("Mostrando Mazo"));

        // Acción para Mostrar Tabla
        mostrarTabla.addActionListener(e -> mostrarMensaje("Mostrando Tabla"));

        // Acción para CPU o Jugador
        cpuJugador.addActionListener(e -> mostrarMensaje("CPU o Jugador"));

        // Acción para Reglas de Batalla
        reglasBatalla.addActionListener(e -> mostrarMensaje("Mostrando Reglas de Batalla"));

        // Acción para Selección Musical
        seleccionMusical.addActionListener(e -> mostrarMensaje("Seleccionando Música"));

        // Acción para Dificultad
        dificultad.addActionListener(e -> mostrarMensaje("Seleccionando Dificultad"));
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu frame = new Menu();
            frame.setVisible(true);
        });
    }
}
