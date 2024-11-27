package musica;


import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ReproductorMusica {
    private Player player;
    private Thread playThread;
    
    	public void reproducir(String rutaArchivo) {
            try {
                FileInputStream fis = new FileInputStream(rutaArchivo);
                player = new Player(fis);
                playThread = new Thread(() -> {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                });
                playThread.start();
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        }
    

    public void detener() {
        if (player != null) {
            player.close();
        } if(playThread != null) {
            playThread.interrupt();
        }
    }
}
