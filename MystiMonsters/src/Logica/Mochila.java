package Logica;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mochila {
    public static final Point MAPA_PRINCIPAL = new Point(0, 0);
    private BufferedImage mochilaImage;
    private List monstruosCapturados;
    public Mochila() {
        cargarImagen();
        monstruosCapturados = new List();
    }

    private void cargarImagen() {
        try {
            mochilaImage = ImageIO.read(new File("Imagenes/mochila.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getMochilaImage() {
        return mochilaImage;
    }

    public String getComponent() {
        return null;
    }

    public void agregarMonstruoCapturado(String nombreMonstruo) {
        monstruosCapturados.add(nombreMonstruo);
        System.out.println("Monstruo capturado: " + nombreMonstruo);
    }

    public List getMonstruosCapturados() {
        return monstruosCapturados;
    }

    public void agregarMonstruo(Monstruo monstruo) {
    }
}
